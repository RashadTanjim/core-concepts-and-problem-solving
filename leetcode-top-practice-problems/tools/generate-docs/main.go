package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"html"
	"os"
	"path/filepath"
	"regexp"
	"strconv"
	"strings"
)

type payload struct {
	Data struct {
		List struct {
			Questions []question `json:"questions"`
		} `json:"favoriteQuestionList"`
	} `json:"data"`
}

type question struct {
	Difficulty         string `json:"difficulty"`
	QuestionFrontendID string `json:"questionFrontendId"`
	Title              string `json:"title"`
	TitleSlug          string `json:"titleSlug"`
	PaidOnly           bool   `json:"paidOnly"`
	TopicTags          []tag  `json:"topicTags"`
	Approach           string `json:"approach,omitempty"`
}

type tag struct {
	Name string `json:"name"`
	Slug string `json:"slug"`
}

var (
	solutionHeading  = regexp.MustCompile(`(?m)^### Solution(?: \d+)?:\s*([^\n]*)`)
	descriptionBlock = regexp.MustCompile(`(?s)<!-- description:start -->(.*?)<!-- description:end -->`)
	paragraph        = regexp.MustCompile(`(?s)<p[^>]*>(.*?)</p>`)
	htmlTag          = regexp.MustCompile(`<[^>]+>`)
)

func main() {
	raw, err := os.ReadFile("source-list.json")
	must(err)
	var source payload
	must(json.Unmarshal(raw, &source))

	referenceDocs := indexReferenceDocs(os.Getenv("DOOCS_ROOT"))
	for i := range source.Data.List.Questions {
		q := &source.Data.List.Questions[i]
		referencePath := referenceDocs[q.QuestionFrontendID]
		q.Approach = inferApproach(*q, referencePath)
		id, _ := strconv.Atoi(q.QuestionFrontendID)
		readmePath := filepath.Join(fmt.Sprintf("%04d-%s", id, q.TitleSlug), "README.md")
		if _, err := os.Stat(readmePath); errors.Is(err, os.ErrNotExist) {
			writeProblemReadme(*q, promptExcerpt(referencePath))
		}
		writeSolutionGuide(*q)
	}
	writeManifest(source.Data.List.Questions)
	writeIndex(source.Data.List.Questions)
}

func indexReferenceDocs(root string) map[string]string {
	docs := make(map[string]string)
	if root == "" {
		return docs
	}
	_ = filepath.WalkDir(filepath.Join(root, "solution"), func(path string, entry os.DirEntry, err error) error {
		if err != nil || entry.IsDir() || entry.Name() != "README_EN.md" {
			return nil
		}
		base := filepath.Base(filepath.Dir(path))
		if len(base) >= 4 {
			if id, err := strconv.Atoi(base[:4]); err == nil {
				docs[strconv.Itoa(id)] = path
			}
		}
		return nil
	})
	return docs
}

func inferApproach(q question, referencePath string) string {
	overrides := map[string]string{
		"355":  "Hash Map + K-way Heap Merge",
		"394":  "Stack + String Parsing",
		"432":  "Hash Map + Doubly Linked Frequency Buckets",
		"1520": "Greedy Interval Expansion",
		"2336": "Cursor + Min Heap",
		"1438": "Sliding Window + Monotonic Deques",
		"150":  "Array Stack",
	}
	if approach := overrides[q.QuestionFrontendID]; approach != "" {
		return approach
	}
	if referencePath != "" {
		if raw, err := os.ReadFile(referencePath); err == nil {
			if match := solutionHeading.FindSubmatch(raw); len(match) == 2 {
				name := strings.TrimSpace(string(match[1]))
				if name != "" && !strings.HasPrefix(name, "###") {
					return name
				}
			}
		}
	}

	topics := topicSet(q)
	priority := []string{
		"Sliding Window", "Monotonic Stack", "Binary Search", "Dynamic Programming",
		"Backtracking", "Trie", "Union Find", "Divide and Conquer", "Prefix Sum",
		"Bit Manipulation", "Two Pointers", "Heap (Priority Queue)", "Greedy",
	}
	for _, candidate := range priority {
		if topics[candidate] {
			return candidate
		}
	}
	for _, candidate := range []string{"Tree", "Binary Tree", "Binary Search Tree"} {
		if topics[candidate] {
			return "Tree Traversal"
		}
	}
	if topics["Graph"] {
		return "Graph Traversal"
	}
	if topics["Linked List"] {
		return "Pointer Manipulation"
	}
	if topics["Design"] {
		return "Data Structure Design"
	}
	if topics["Hash Table"] {
		return "Hash Table"
	}
	if topics["Stack"] {
		return "Stack"
	}
	if topics["Queue"] {
		return "Queue"
	}
	if topics["String"] {
		return "String Scan"
	}
	return "Linear Scan"
}

func writeProblemReadme(q question, excerpt string) {
	id, _ := strconv.Atoi(q.QuestionFrontendID)
	dir := fmt.Sprintf("%04d-%s", id, q.TitleSlug)
	if id == 1 {
		writeTwoSumReadme(dir)
		return
	}
	topics := make([]string, len(q.TopicTags))
	for i, topic := range q.TopicTags {
		topics[i] = topic.Name
	}

	access := "Free"
	if q.PaidOnly {
		access = "Premium"
	}
	content := fmt.Sprintf(`# %s. %s

| Difficulty | Access | Topics |
|---|---|---|
| %s | %s | %s |

[Open the complete problem on LeetCode](https://leetcode.com/problems/%s/)

## Problem description

> %s

This is a short excerpt from the LeetCode prompt. Use the linked problem as the authoritative source for the complete statement, examples, and constraints.

## Files

- [Detailed interview solution](./solution.md)
- [Go implementation](./solution.go)
`, q.QuestionFrontendID, q.Title, titleCase(q.Difficulty), access,
		strings.Join(topics, ", "), q.TitleSlug, excerpt)
	must(os.WriteFile(filepath.Join(dir, "README.md"), []byte(content), 0o644))
}

func writeTwoSumReadme(dir string) {
	content := `# 1. Two Sum

| Difficulty | Access | Topics |
|---|---|---|
| Easy | Free | Array, Hash Table |

[Open the complete problem on LeetCode](https://leetcode.com/problems/two-sum/)

## Problem description

You are given an array of integers <code>nums</code> and an integer <code>target</code>. Return the indices of the two numbers such that they add up to <code>target</code>.

You may assume that each input has exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Examples

### Example 1

<pre>
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
</pre>

Because <code>nums[0] + nums[1] == 9</code>, the answer is <code>[0,1]</code>.

### Example 2

<pre>
Input: nums = [3,2,4], target = 6
Output: [1,2]
</pre>

### Example 3

<pre>
Input: nums = [3,3], target = 6
Output: [0,1]
</pre>

## Constraints

- <code>2 <= nums.length <= 10^4</code>
- <code>-10^9 <= nums[i] <= 10^9</code>
- <code>-10^9 <= target <= 10^9</code>
- Exactly one valid answer exists.

## Follow-up

Can you design an algorithm with better than $O(n^2)$ time complexity?

## Files

- [Detailed interview solution](./solution.md)
- [Go implementation](./solution.go)
`
	must(os.WriteFile(filepath.Join(dir, "README.md"), []byte(content), 0o644))
}

func writeSolutionGuide(q question) {
	id, _ := strconv.Atoi(q.QuestionFrontendID)
	dir := fmt.Sprintf("%04d-%s", id, q.TitleSlug)
	if id == 4 {
		writeMedianSolution(dir)
		return
	}
	baseline, invariant, proof, complexity := guidance(q.Approach)
	content := fmt.Sprintf(`# %s. %s - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/%s/)

## Pattern recognition

The main signal is **%s**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

%s

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **%s**.
3. Process each state in the order used by <code>solution.go</code>, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** %s

## Why it works

%s

## Complexity

%s State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

## Edge cases to call out

- Empty or minimum-size input when permitted by the prompt.
- Duplicate values, repeated characters, or equal-priority states.
- Already optimal, fully sorted, or fully invalid input.
- Integer overflow and boundary indices where arithmetic is involved.
- Degenerate structures such as a one-sided tree, a cycle, or a disconnected graph when relevant.

## Go submission notes

- Submit the imports and implementation from <code>solution.go</code>.
- <code>types.go</code> exists only when this repository needs a local version of a LeetCode-provided type or callback.
- Explain the invariant before coding, use descriptive state names, and finish by testing one normal case plus one boundary case aloud.
`, q.QuestionFrontendID, q.Title, q.TitleSlug, q.Approach, baseline,
		q.Approach, invariant, proof, complexity)
	must(os.WriteFile(filepath.Join(dir, "solution.md"), []byte(content), 0o644))
}

func writeMedianSolution(dir string) {
	content := `# 4. Median of Two Sorted Arrays - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays/)

## What the interviewer is testing

The arrays are already sorted, so the real question is whether we can discard large groups of values without merging them. The required logarithmic running time rules out a complete scan in the final solution.

Let the total length be $N=m+n$:

- If $N$ is odd, the answer is the element at one-indexed rank $(N+1)/2$.
- If $N$ is even, the answer is the average of ranks $N/2$ and $N/2+1$.

This reduces the problem to finding the k-th smallest element across two sorted suffixes.

## Approach 1: Merge both arrays

Use the standard merge step from merge sort:

1. Keep one pointer in each array.
2. Append the smaller current value to a new array.
3. Continue until both arrays are exhausted.
4. Read the middle value or values from the merged array.

This is easy to explain and difficult to get wrong, which makes it a useful baseline. It does not satisfy the requested logarithmic time.

**Time:** $O(m+n)$  
**Space:** $O(m+n)$

## Approach 2: Two pointers without storing the merge

Perform the same logical merge, but stop after reaching the middle rank. Keep only the previous and current selected values instead of building an output array.

This removes the merged-array allocation, but it still examines up to half of all values.

**Time:** $O(m+n)$  
**Space:** $O(1)$

## Approach 3: Eliminate half of k

Define <code>kth(i, j, k)</code> as the k-th smallest value among:

- <code>nums1[i:]</code>
- <code>nums2[j:]</code>

At each call:

1. If one suffix is empty, answer directly from the other suffix.
2. If <code>k == 1</code>, return the smaller leading value.
3. Let <code>half = k/2</code>.
4. Compare the <code>half</code>-th remaining value from each array. Treat a missing candidate as positive infinity.
5. Discard <code>half</code> values from the array with the smaller candidate.
6. Recurse for rank <code>k-half</code>.

### Why discarding is safe

Suppose the candidate in <code>nums1</code> is smaller. The first <code>half</code> remaining values of <code>nums1</code> are no greater than that candidate. There are therefore at least <code>half</code> values that must appear before the requested k-th value. None of them can be the k-th value, so removing them preserves the answer while reducing <code>k</code> by the same amount.

The other comparison is symmetric.

### Median ranks

The implementation asks for:

- <code>leftRank = (m+n+1)/2</code>
- <code>rightRank = (m+n+2)/2</code>

For an odd total, both expressions produce the same rank. For an even total, they produce the two middle ranks. Their average is therefore the median in both cases.

## Dry run

For <code>nums1 = [1,3]</code> and <code>nums2 = [2]</code>:

1. The total length is 3, so both median ranks are 2.
2. To find rank 2, compare the first remaining elements: 1 and 2.
3. Discard 1 from <code>nums1</code> and search for rank 1.
4. The smaller leading value is now 2, so the median is 2.

## Correctness argument

Each recursive step either returns from a base case or removes values that are provably earlier than the requested rank. The rank is reduced by exactly the number of removed values, so <code>kth</code> continues to refer to the same logical element. Because <code>k</code> decreases on every recursive call, a base case is eventually reached and returns the correct ranked value. Computing the two middle ranks then gives the correct median.

## Complexity

Each recursive call reduces <code>k</code> by about half.

- **Time:** $O(\log(m+n))$
- **Space:** $O(\log(m+n))$ recursion depth

An iterative version can reduce auxiliary space to $O(1)$.

## Edge cases

- One input array is empty.
- One array is much shorter than the other.
- The combined length is even.
- Duplicate and negative values.
- A <code>k/2</code> candidate falls beyond one array's remaining length.
- Avoid integer overflow when averaging two middle values in languages with narrower integer types.

## Interview delivery

Start with the merge baseline, use the logarithmic requirement to reject it, reduce median selection to k-th-element selection, and state the discard proof before writing the recursion. That proof is the key signal the interviewer is looking for.
`
	must(os.WriteFile(filepath.Join(dir, "solution.md"), []byte(content), 0o644))
}

func promptExcerpt(referencePath string) string {
	if referencePath == "" {
		return "See the linked LeetCode prompt for the current problem statement."
	}
	raw, err := os.ReadFile(referencePath)
	if err != nil {
		return "See the linked LeetCode prompt for the current problem statement."
	}
	block := descriptionBlock.FindSubmatch(raw)
	if len(block) != 2 {
		return "See the linked LeetCode prompt for the current problem statement."
	}
	for _, match := range paragraph.FindAllSubmatch(block[1], -1) {
		text := htmlTag.ReplaceAllString(string(match[1]), " ")
		text = html.UnescapeString(text)
		text = strings.Join(strings.Fields(text), " ")
		words := strings.Fields(text)
		if len(words) < 4 {
			continue
		}
		if len(words) > 25 {
			words = words[:25]
			words[len(words)-1] += "..."
		}
		return strings.Join(words, " ")
	}
	return "See the linked LeetCode prompt for the current problem statement."
}

func guidance(approach string) (baseline, invariant, proof, complexity string) {
	p := strings.ToLower(approach)
	switch {
	case strings.Contains(p, "sliding window"):
		return "A direct solution checks every candidate range and recomputes its validity. That repeats work across heavily overlapping ranges.",
			"The active window is valid after each shrink step, and every discarded left boundary can never improve a later window ending at the same position.",
			"The right boundary considers every possible ending position. The left boundary advances only when validity is violated, so every retained window is valid and no better valid window is skipped.",
			"The scan is linear when both boundaries move monotonically; auxiliary space is the state used to validate the current window."
	case strings.Contains(p, "binary search"):
		return "A linear scan is the simplest baseline, but it ignores the monotonic ordering or monotonic feasibility condition exposed by the constraints.",
			"The answer remains inside the current search interval; each comparison safely eliminates the half that cannot contain it.",
			"Every branch follows directly from the monotonic predicate. Because the discarded half cannot contain a valid answer, termination leaves exactly the requested boundary or value.",
			"Binary search contributes a logarithmic factor; include any per-check work when giving the final time bound. Iterative search uses constant auxiliary space."
	case strings.Contains(p, "dynamic programming"), strings.Contains(p, "memo"):
		return "Plain recursion or enumeration explores the same subproblem many times. Draw the state graph to expose that overlap before optimizing it.",
			"Each DP entry stores the correct answer for its precisely defined prefix, suffix, interval, or remaining resource before a dependent state reads it.",
			"The base cases are correct by definition. Assuming smaller dependency states are correct, the transition enumerates every legal final choice, so induction proves the computed optimum or count.",
			"Time is the number of reachable states multiplied by transitions per state; space is the memo/table size plus recursion depth when applicable."
	case strings.Contains(p, "backtrack"), strings.Contains(p, "dfs"):
		return "Brute force generates every raw combination and validates only at the end. Move validation into construction so invalid prefixes stop immediately.",
			"At recursion depth `d`, the current path is a valid partial candidate containing exactly the decisions made for the first `d` positions or choices.",
			"Each recursive branch represents one legal next decision, and backtracking restores the previous state. Therefore every valid candidate is visited and no invalid completed candidate is emitted.",
			"Time is proportional to the explored search tree (often exponential); space is the recursion depth plus the current path, excluding returned output."
	case strings.Contains(p, "bfs"), strings.Contains(p, "level order"):
		return "A repeated search from every target state wastes work. Start from the natural source set and visit the state graph once.",
			"The queue contains the current frontier in nondecreasing distance or level order, and visited states are never enqueued twice.",
			"BFS exhausts all states at distance `d` before distance `d+1`, so the first discovered shortest state has minimum distance and every reachable state is processed correctly.",
			"For graphs, time is `O(V+E)` and space is `O(V)`; for grids or trees, translate those symbols to the number of cells or nodes."
	case strings.Contains(p, "heap"), strings.Contains(p, "priority queue"):
		return "Sorting all candidates is a valid baseline, but it performs more ordering work than necessary when only the next best or top `k` candidates matter.",
			"The heap root is always the best currently eligible candidate, while every future candidate is inserted before it can be selected.",
			"The heap property makes each extraction locally optimal. Since the heap contains every eligible alternative, repeatedly choosing its root produces the required global order or top-k set.",
			"Each heap insertion or removal is logarithmic in heap size; multiply by the number of processed candidates. Space is the maximum heap size."
	case strings.Contains(p, "two pointer"), strings.Contains(p, "fast and slow"), strings.Contains(p, "three pointer"):
		return "A nested-loop baseline checks pairs or boundaries independently. Use the input order or pointer-speed relationship to remove impossible candidates in groups.",
			"Everything outside the active pointer range has already been finalized or proven unable to improve the answer.",
			"At each step, the comparison identifies a pointer whose current candidate cannot participate in a better unresolved answer. Moving it preserves all viable candidates and guarantees progress.",
			"Pointers usually give linear time after any required sorting and constant auxiliary space; include sorting cost and output storage separately."
	case strings.Contains(p, "hash"):
		return "The direct baseline repeatedly scans earlier data to find a match or recomputes frequencies. Cache exactly the lookup information needed by future iterations.",
			"Before processing the current item, the map summarizes all relevant information from the already processed prefix.",
			"A required counterpart or prior state is found exactly when it is present in the processed prefix. Updating after the lookup prevents illegal self-reuse when the prompt forbids it.",
			"Expected time is linear in processed items with hash lookups; auxiliary space is linear in the number of distinct stored keys."
	case strings.Contains(p, "greedy"):
		return "Enumeration considers many decision sequences. Look for an exchange argument showing that one locally best safe decision can always lead to an optimum.",
			"After each choice, the constructed prefix is at least as good as the corresponding prefix of some optimal solution.",
			"If an optimum makes a different first unresolved choice, exchange it with the greedy choice without worsening feasibility or value. Repeating the exchange yields the algorithm's solution.",
			"The main scan is typically linear; include sorting or heap operations when they establish greedy order."
	case strings.Contains(p, "sort"):
		return "Without ordering, candidate relationships are expensive to discover repeatedly. Sort once so relevant neighbors or monotonic boundaries become adjacent.",
			"The sorted prefix has been fully resolved, and unresolved candidates appear in an order that permits safe one-way movement.",
			"Sorting exposes candidates in the exact comparison order used by the algorithm. Each scan step finalizes the next candidate without invalidating earlier decisions.",
			"Sorting costs `O(n log n)` and the following scan is usually linear; auxiliary space depends on the Go sorting implementation and result storage."
	case strings.Contains(p, "stack"):
		return "Repeatedly searching backward for an unresolved predecessor is quadratic. A stack keeps only candidates that may still affect future input.",
			"Stack order matches unresolved nesting or monotonic dominance, and every removed item has just found its final match or can never be useful again.",
			"Each push records an unresolved candidate; each pop occurs only when the current item proves its resolution. Thus all valid relationships are processed exactly once.",
			"Amortized time is linear because each item is pushed and popped at most once; auxiliary space is linear in the worst case."
	case strings.Contains(p, "tree"), strings.Contains(p, "traversal"), strings.Contains(p, "recursion"):
		return "A tree solution starts by defining what information a subtree must return. Avoid rescanning descendants by computing that summary once per node.",
			"After a node returns, its result is correct for the entire subtree rooted at that node.",
			"Null and leaf cases establish the base. Combining correct left and right subtree summaries according to the node rule proves correctness by structural induction.",
			"Each node is normally visited once for `O(n)` time; space is `O(h)` for recursion or an explicit frontier, where `h` is tree height."
	case strings.Contains(p, "graph"), strings.Contains(p, "union"):
		return "The baseline may launch redundant reachability checks. Build an adjacency or component representation and process each relationship systematically.",
			"Visited/component state exactly represents the vertices already proven reachable or connected under processed edges.",
			"Traversal follows every edge from each reached vertex, while component merging preserves connectivity equivalence. Consequently no reachable relation is missed and no disconnected relation is invented.",
			"Adjacency traversal is `O(V+E)`; union-find is near-linear at `O(E alpha(V))`. Space is `O(V+E)` or `O(V)` respectively."
	case strings.Contains(p, "trie"):
		return "Repeated full-string comparisons duplicate prefix work. Store shared prefixes once and traverse them character by character.",
			"The current trie node represents exactly the prefix consumed so far; terminal markers distinguish whole keys from prefixes.",
			"Following one edge per character succeeds exactly when the prefix exists. Insertions create precisely the missing edges, so later searches reflect all inserted keys.",
			"Each operation is linear in key length; space is proportional to the number of created prefix nodes."
	case strings.Contains(p, "bit"):
		return "A per-value or per-bit counting baseline uses extra state. Exploit the algebraic identities of XOR, masks, or shifts to combine information directly.",
			"After processing each value or bit position, the accumulator represents the required property for the processed prefix.",
			"The chosen bit identity is associative or preserves each bit independently, so applying it across all inputs yields exactly the requested final representation.",
			"The scan is linear in the number of values, or linear times the fixed machine-word width; auxiliary space is constant."
	default:
		return "Start with the most literal simulation and identify which values it recomputes or which candidates it revisits. The optimized implementation stores only state needed by the next step.",
			"After each iteration, all processed input has been represented correctly in the maintained state and the partial answer matches that prefix.",
			"Initialization satisfies the invariant. Each update preserves it for one more input item, and at termination the processed prefix is the entire input, which is the required result.",
			"Count how many times each input item and maintained state can be processed; auxiliary space is the maximum live state, excluding returned output."
	}
}

func writeManifest(questions []question) {
	data, err := json.MarshalIndent(questions, "", "  ")
	must(err)
	data = append(data, '\n')
	must(os.WriteFile("problems.json", data, 0o644))
}

func writeIndex(questions []question) {
	counts := map[string]int{}
	for _, q := range questions {
		counts[q.Difficulty]++
	}
	var out strings.Builder
	fmt.Fprintln(&out, "# LeetCode Top Practice Problems in Go")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "Complete Go coverage of the shared [LeetCode problem list](https://leetcode.com/problem-list/24s7vlue/), organized as one independently compilable package per problem.")
	fmt.Fprintln(&out)
	fmt.Fprintf(&out, "- Total: **%d**\n- Easy: **%d**\n- Medium: **%d**\n- Hard: **%d**\n\n", len(questions), counts["EASY"], counts["MEDIUM"], counts["HARD"])
	fmt.Fprintln(&out, "## How to use this repository")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "1. Open a problem directory and read `README.md` for the prompt summary.")
	fmt.Fprintln(&out, "2. Work through `solution.md` from brute force to the optimized invariant.")
	fmt.Fprintln(&out, "3. Reimplement from memory, then compare with `solution.go`.")
	fmt.Fprintln(&out, "4. Run `go test ./...` from this directory to compile every package and run repository checks.")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "LeetCode supplies some node types and callback APIs. Their local equivalents live in `types.go`; submit only the imports and implementation from `solution.go`.")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "## Problems")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "| List order | # | Problem | Solution | Difficulty | Approach |")
	fmt.Fprintln(&out, "|---:|---:|---|---|---|---|")
	for i, q := range questions {
		id, _ := strconv.Atoi(q.QuestionFrontendID)
		dir := fmt.Sprintf("%04d-%s", id, q.TitleSlug)
		fmt.Fprintf(&out, "| %d | %s | [%s](./%s/) | [Approach](./%s/solution.md) | %s | %s |\n", i+1, q.QuestionFrontendID, q.Title, dir, dir, titleCase(q.Difficulty), q.Approach)
	}
	fmt.Fprintln(&out, "\n## Verification")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "```bash\ngo test ./...\n```")
	fmt.Fprintln(&out)
	fmt.Fprintln(&out, "See [NOTICE.md](./NOTICE.md) for source attribution.")
	must(os.WriteFile("README.md", []byte(out.String()), 0o644))
}

func topicSet(q question) map[string]bool {
	set := make(map[string]bool, len(q.TopicTags))
	for _, topic := range q.TopicTags {
		set[topic.Name] = true
	}
	return set
}

func titleCase(value string) string {
	value = strings.ToLower(value)
	return strings.ToUpper(value[:1]) + value[1:]
}

func must(err error) {
	if err != nil {
		panic(err)
	}
}
