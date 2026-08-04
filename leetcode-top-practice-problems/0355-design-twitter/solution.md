# 355. Design Twitter - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/design-twitter/)

## Pattern recognition

The main signal is **Hash Map + K-way Heap Merge**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

Sorting all candidates is a valid baseline, but it performs more ordering work than necessary when only the next best or top `k` candidates matter.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Hash Map + K-way Heap Merge**.
3. Process each state in the order used by <code>solution.go</code>, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** The heap root is always the best currently eligible candidate, while every future candidate is inserted before it can be selected.

## Why it works

The heap property makes each extraction locally optimal. Since the heap contains every eligible alternative, repeatedly choosing its root produces the required global order or top-k set.

## Complexity

Each heap insertion or removal is logarithmic in heap size; multiply by the number of processed candidates. Space is the maximum heap size. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

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
