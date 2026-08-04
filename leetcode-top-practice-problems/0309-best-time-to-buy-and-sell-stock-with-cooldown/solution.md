# 309. Best Time to Buy and Sell Stock with Cooldown - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

## Pattern recognition

The main signal is **Memoization Search**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

Plain recursion or enumeration explores the same subproblem many times. Draw the state graph to expose that overlap before optimizing it.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Memoization Search**.
3. Process each state in the order used by <code>solution.go</code>, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** Each DP entry stores the correct answer for its precisely defined prefix, suffix, interval, or remaining resource before a dependent state reads it.

## Why it works

The base cases are correct by definition. Assuming smaller dependency states are correct, the transition enumerates every legal final choice, so induction proves the computed optimum or count.

## Complexity

Time is the number of reachable states multiplied by transitions per state; space is the memo/table size plus recursion depth when applicable. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

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
