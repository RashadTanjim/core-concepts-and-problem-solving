package p1438

func longestSubarray(nums []int, limit int) (ans int) {
	minDeque := make([]int, 0, len(nums))
	maxDeque := make([]int, 0, len(nums))
	left := 0
	for right, value := range nums {
		for len(minDeque) > 0 && nums[minDeque[len(minDeque)-1]] > value {
			minDeque = minDeque[:len(minDeque)-1]
		}
		minDeque = append(minDeque, right)
		for len(maxDeque) > 0 && nums[maxDeque[len(maxDeque)-1]] < value {
			maxDeque = maxDeque[:len(maxDeque)-1]
		}
		maxDeque = append(maxDeque, right)

		for nums[maxDeque[0]]-nums[minDeque[0]] > limit {
			if minDeque[0] == left {
				minDeque = minDeque[1:]
			}
			if maxDeque[0] == left {
				maxDeque = maxDeque[1:]
			}
			left++
		}
		ans = max(ans, right-left+1)
	}
	return
}
