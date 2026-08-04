package main

import (
	"encoding/json"
	"fmt"
	"os"
	"os/exec"
	"path/filepath"
	"runtime"
	"sort"
	"strconv"
	"sync"
)

type problem struct {
	QuestionFrontendID string `json:"questionFrontendId"`
	TitleSlug          string `json:"titleSlug"`
}

type result struct {
	dir    string
	output string
	err    error
}

func main() {
	if _, err := exec.LookPath("javac"); err != nil {
		fatal("javac is required: %v", err)
	}

	raw, err := os.ReadFile("problems.json")
	if err != nil {
		fatal("read problems.json: %v", err)
	}
	var problems []problem
	if err := json.Unmarshal(raw, &problems); err != nil {
		fatal("parse problems.json: %v", err)
	}

	outputRoot, err := os.MkdirTemp("", "leetcode-java-")
	if err != nil {
		fatal("create temporary output: %v", err)
	}
	defer os.RemoveAll(outputRoot)

	jobs := make(chan problem)
	results := make(chan result, len(problems))
	workers := min(runtime.NumCPU(), 4)
	var group sync.WaitGroup
	for range workers {
		group.Add(1)
		go func() {
			defer group.Done()
			for item := range jobs {
				results <- compile(item, outputRoot)
			}
		}()
	}
	go func() {
		for _, item := range problems {
			jobs <- item
		}
		close(jobs)
		group.Wait()
		close(results)
	}()

	failures := make([]result, 0)
	for compiled := range results {
		if compiled.err != nil {
			failures = append(failures, compiled)
		}
	}
	sort.Slice(failures, func(i, j int) bool { return failures[i].dir < failures[j].dir })
	for _, failure := range failures {
		fmt.Fprintf(os.Stderr, "\n%s: %v\n%s", failure.dir, failure.err, failure.output)
	}
	if len(failures) > 0 {
		fatal("%d of %d Java solutions failed compilation", len(failures), len(problems))
	}
	fmt.Printf("compiled %d Java solutions\n", len(problems))
}

func compile(item problem, outputRoot string) result {
	id, err := strconv.Atoi(item.QuestionFrontendID)
	if err != nil {
		return result{dir: item.TitleSlug, err: err}
	}
	dir := fmt.Sprintf("%04d-%s", id, item.TitleSlug)
	files := []string{filepath.Join(dir, "Solution.java")}
	if _, err := os.Stat(filepath.Join(dir, "Types.java")); err == nil {
		files = append(files, filepath.Join(dir, "Types.java"))
	}
	args := append([]string{"--release", "17", "-encoding", "UTF-8", "-d", filepath.Join(outputRoot, dir)}, files...)
	output, err := exec.Command("javac", args...).CombinedOutput()
	return result{dir: dir, output: string(output), err: err}
}

func fatal(format string, args ...any) {
	fmt.Fprintf(os.Stderr, format+"\n", args...)
	os.Exit(1)
}
