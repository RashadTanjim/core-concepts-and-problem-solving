package repository_test

import (
	"encoding/json"
	"fmt"
	"go/parser"
	"go/token"
	"os"
	"path/filepath"
	"strconv"
	"testing"
)

type problem struct {
	QuestionFrontendID string `json:"questionFrontendId"`
	TitleSlug          string `json:"titleSlug"`
}

func TestManifestMatchesProblemDirectories(t *testing.T) {
	raw, err := os.ReadFile("problems.json")
	if err != nil {
		t.Fatal(err)
	}
	var problems []problem
	if err := json.Unmarshal(raw, &problems); err != nil {
		t.Fatal(err)
	}
	if len(problems) != 333 {
		t.Fatalf("manifest contains %d problems, want 333", len(problems))
	}

	seen := make(map[string]bool, len(problems))
	for _, item := range problems {
		if seen[item.QuestionFrontendID] {
			t.Errorf("duplicate problem ID %s", item.QuestionFrontendID)
		}
		seen[item.QuestionFrontendID] = true

		id, err := strconv.Atoi(item.QuestionFrontendID)
		if err != nil {
			t.Errorf("invalid problem ID %q", item.QuestionFrontendID)
			continue
		}
		dir := fmt.Sprintf("%04d-%s", id, item.TitleSlug)
		for _, name := range []string{"README.md", "solution.md", "solution.go", "Solution.java"} {
			path := filepath.Join(dir, name)
			if _, err := os.Stat(path); err != nil {
				t.Errorf("%s: %v", path, err)
			}
		}

		path := filepath.Join(dir, "solution.go")
		if _, err := parser.ParseFile(token.NewFileSet(), path, nil, parser.AllErrors); err != nil {
			t.Errorf("parse %s: %v", path, err)
		}
	}
}
