# 4. Median of Two Sorted Arrays - Interview Solution

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
