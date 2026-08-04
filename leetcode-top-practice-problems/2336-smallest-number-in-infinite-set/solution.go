package p2336

import "container/heap"

type SmallestInfiniteSet struct {
	next    int
	added   intHeap
	inAdded map[int]bool
}

func Constructor() SmallestInfiniteSet {
	return SmallestInfiniteSet{next: 1, inAdded: make(map[int]bool)}
}

func (this *SmallestInfiniteSet) PopSmallest() int {
	if len(this.added) > 0 {
		smallest := heap.Pop(&this.added).(int)
		delete(this.inAdded, smallest)
		return smallest
	}
	smallest := this.next
	this.next++
	return smallest
}

func (this *SmallestInfiniteSet) AddBack(num int) {
	if num >= this.next || this.inAdded[num] {
		return
	}
	heap.Push(&this.added, num)
	this.inAdded[num] = true
}

type intHeap []int

func (h intHeap) Len() int           { return len(h) }
func (h intHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h intHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *intHeap) Push(value any)    { *h = append(*h, value.(int)) }
func (h *intHeap) Pop() any {
	old := *h
	last := old[len(old)-1]
	*h = old[:len(old)-1]
	return last
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.PopSmallest();
 * obj.AddBack(num);
 */
