package p0355

import "container/heap"

type tweet struct {
	id, time int
	next     *tweet
}

type Twitter struct {
	clock   int
	tweets  map[int]*tweet
	follows map[int]map[int]struct{}
}

func Constructor() Twitter {
	return Twitter{
		tweets:  make(map[int]*tweet),
		follows: make(map[int]map[int]struct{}),
	}
}

func (t *Twitter) PostTweet(userID int, tweetID int) {
	t.clock++
	t.tweets[userID] = &tweet{id: tweetID, time: t.clock, next: t.tweets[userID]}
}

func (t *Twitter) GetNewsFeed(userID int) []int {
	h := tweetHeap{}
	if head := t.tweets[userID]; head != nil {
		heap.Push(&h, head)
	}
	for followee := range t.follows[userID] {
		if head := t.tweets[followee]; head != nil {
			heap.Push(&h, head)
		}
	}

	feed := make([]int, 0, 10)
	for h.Len() > 0 && len(feed) < 10 {
		latest := heap.Pop(&h).(*tweet)
		feed = append(feed, latest.id)
		if latest.next != nil {
			heap.Push(&h, latest.next)
		}
	}
	return feed
}

func (t *Twitter) Follow(followerID int, followeeID int) {
	if followerID == followeeID {
		return
	}
	if t.follows[followerID] == nil {
		t.follows[followerID] = make(map[int]struct{})
	}
	t.follows[followerID][followeeID] = struct{}{}
}

func (t *Twitter) Unfollow(followerID int, followeeID int) {
	delete(t.follows[followerID], followeeID)
}

type tweetHeap []*tweet

func (h tweetHeap) Len() int           { return len(h) }
func (h tweetHeap) Less(i, j int) bool { return h[i].time > h[j].time }
func (h tweetHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *tweetHeap) Push(x any)        { *h = append(*h, x.(*tweet)) }
func (h *tweetHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}
