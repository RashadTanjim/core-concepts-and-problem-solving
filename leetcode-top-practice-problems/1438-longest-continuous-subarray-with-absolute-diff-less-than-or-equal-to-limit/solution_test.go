package p1438

import "testing"

func TestLongestSubarray(t *testing.T) {
	tests := []struct {
		nums  []int
		limit int
		want  int
	}{
		{[]int{8, 2, 4, 7}, 4, 2},
		{[]int{10, 1, 2, 4, 7, 2}, 5, 4},
		{[]int{4, 2, 2, 2, 4, 4, 2, 2}, 0, 3},
	}
	for _, test := range tests {
		if got := longestSubarray(test.nums, test.limit); got != test.want {
			t.Errorf("longestSubarray(%v, %d) = %d, want %d", test.nums, test.limit, got, test.want)
		}
	}
}
