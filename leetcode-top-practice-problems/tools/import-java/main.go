package main

import (
	"encoding/json"
	"fmt"
	"os"
	"path/filepath"
	"regexp"
	"strconv"
	"strings"
)

type problem struct {
	QuestionFrontendID string `json:"questionFrontendId"`
	TitleSlug          string `json:"titleSlug"`
}

var publicType = regexp.MustCompile(`(?m)^public (class|interface|enum|record) ([A-Za-z_][A-Za-z0-9_]*)`)

func main() {
	if len(os.Args) != 2 {
		fmt.Fprintln(os.Stderr, "usage: go run ./tools/import-java /path/to/doocs/leetcode")
		os.Exit(2)
	}

	problems := readProblems("problems.json")
	sources := indexJavaSolutions(filepath.Join(os.Args[1], "solution"))
	for _, item := range problems {
		id, err := strconv.Atoi(item.QuestionFrontendID)
		must(err)
		sourcePath := sources[id]
		if sourcePath == "" {
			if id == 1520 {
				continue
			}
			must(fmt.Errorf("no Java solution found for problem %d", id))
		}

		raw, err := os.ReadFile(sourcePath)
		must(err)
		dir := fmt.Sprintf("%04d-%s", id, item.TitleSlug)
		must(os.WriteFile(filepath.Join(dir, "Solution.java"), normalizeJava(raw), 0o644))
	}
}

func readProblems(path string) []problem {
	raw, err := os.ReadFile(path)
	must(err)
	var problems []problem
	must(json.Unmarshal(raw, &problems))
	return problems
}

func indexJavaSolutions(root string) map[int]string {
	solutions := make(map[int]string)
	must(filepath.WalkDir(root, func(path string, entry os.DirEntry, err error) error {
		if err != nil {
			return err
		}
		if entry.IsDir() || entry.Name() != "Solution.java" {
			return nil
		}
		name := filepath.Base(filepath.Dir(path))
		if len(name) < 5 || name[4] != '.' {
			return nil
		}
		id, err := strconv.Atoi(name[:4])
		if err != nil {
			return nil
		}
		if previous := solutions[id]; previous != "" {
			return fmt.Errorf("multiple Java solutions for problem %d: %s and %s", id, previous, path)
		}
		solutions[id] = path
		return nil
	}))
	return solutions
}

func normalizeJava(raw []byte) []byte {
	source := strings.TrimPrefix(string(raw), "\ufeff")
	source = publicType.ReplaceAllStringFunc(source, func(declaration string) string {
		parts := strings.Fields(declaration)
		if len(parts) == 3 && parts[2] != "Solution" {
			return strings.TrimPrefix(declaration, "public ")
		}
		return declaration
	})

	const header = `// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

`
	return []byte(header + strings.TrimSpace(source) + "\n")
}

func must(err error) {
	if err != nil {
		panic(err)
	}
}
