# 150. Evaluate Reverse Polish Notation - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [Java implementation](./Solution.java) | [LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

## Pattern recognition

The main signal is **Array Stack**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

Repeatedly searching backward for an unresolved predecessor is quadratic. A stack keeps only candidates that may still affect future input.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Array Stack**.
3. Process each state in the order used by the implementations, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** Stack order matches unresolved nesting or monotonic dominance, and every removed item has just found its final match or can never be useful again.

## Why it works

Each push records an unresolved candidate; each pop occurs only when the current item proves its resolution. Thus all valid relationships are processed exactly once.

## Complexity

Amortized time is linear because each item is pushed and popped at most once; auxiliary space is linear in the worst case. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

## Edge cases to call out

- Empty or minimum-size input when permitted by the prompt.
- Duplicate values, repeated characters, or equal-priority states.
- Already optimal, fully sorted, or fully invalid input.
- Integer overflow and boundary indices where arithmetic is involved.
- Degenerate structures such as a one-sided tree, a cycle, or a disconnected graph when relevant.

## Submission notes

- Submit the imports and implementation from <code>solution.go</code>.
- For Java, submit <code>Solution.java</code> or the problem-specific design class it contains.
- <code>types.go</code> and <code>Types.java</code> exist only when local compilation needs a LeetCode-provided type or callback.
- Explain the invariant before coding, use descriptive state names, and finish by testing one normal case plus one boundary case aloud.
