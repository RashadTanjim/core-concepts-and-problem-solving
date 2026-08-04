# 1707. Maximum XOR With an Element From Array - Interview Solution

[Problem description](./README.md) | [Go implementation](./solution.go) | [Java implementation](./Solution.java) | [LeetCode](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/)

## Pattern recognition

The main signal is **Offline Query + Binary Trie**. Before coding, state what information the algorithm must remember and why that removes repeated work from the direct approach.

## Approach 1: Brute force

Repeated full-string comparisons duplicate prefix work. Store shared prefixes once and traverse them character by character.

This is useful as a correctness baseline, but it revisits candidates or recomputes state. Explain which repeated work causes it to miss the target complexity.

## Approach 2: Optimized

1. Identify the state that must be available when processing the next element, node, or decision.
2. Represent that state with the data structure implied by **Offline Query + Binary Trie**.
3. Process each state in the order used by the implementations, updating the answer only after the invariant is restored.
4. Return the accumulated result or the final state required by the prompt.

**Invariant:** The current trie node represents exactly the prefix consumed so far; terminal markers distinguish whole keys from prefixes.

## Why it works

Following one edge per character succeeds exactly when the prefix exists. Insertions create precisely the missing edges, so later searches reflect all inserted keys.

## Complexity

Each operation is linear in key length; space is proportional to the number of created prefix nodes. State the bound in terms of the prompt's dimensions (for example <code>n</code>, <code>m</code>, vertices, edges, or generated states) during the interview.

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
