package p2336

import "testing"

func TestSmallestInfiniteSet(t *testing.T) {
	set := Constructor()
	if got := set.PopSmallest(); got != 1 {
		t.Fatalf("first pop = %d, want 1", got)
	}
	if got := set.PopSmallest(); got != 2 {
		t.Fatalf("second pop = %d, want 2", got)
	}
	set.AddBack(1)
	set.AddBack(1)
	if got := set.PopSmallest(); got != 1 {
		t.Fatalf("pop after add-back = %d, want 1", got)
	}
	if got := set.PopSmallest(); got != 3 {
		t.Fatalf("next fresh pop = %d, want 3", got)
	}
}
