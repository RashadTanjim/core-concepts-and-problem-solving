package p0432

type bucket struct {
	count      int
	keys       map[string]struct{}
	prev, next *bucket
}

type AllOne struct {
	head, tail *bucket
	keyBucket  map[string]*bucket
}

func Constructor() AllOne {
	head := &bucket{}
	tail := &bucket{}
	head.next = tail
	tail.prev = head
	return AllOne{head: head, tail: tail, keyBucket: make(map[string]*bucket)}
}

func (a *AllOne) Inc(key string) {
	current := a.keyBucket[key]
	if current == nil {
		if a.head.next == a.tail || a.head.next.count != 1 {
			a.insertAfter(a.head, &bucket{count: 1, keys: make(map[string]struct{})})
		}
		a.head.next.keys[key] = struct{}{}
		a.keyBucket[key] = a.head.next
		return
	}

	next := current.next
	if next == a.tail || next.count != current.count+1 {
		next = &bucket{count: current.count + 1, keys: make(map[string]struct{})}
		a.insertAfter(current, next)
	}
	a.move(key, current, next)
}

func (a *AllOne) Dec(key string) {
	current := a.keyBucket[key]
	if current == nil {
		return
	}
	if current.count == 1 {
		delete(a.keyBucket, key)
		delete(current.keys, key)
		a.removeIfEmpty(current)
		return
	}

	previous := current.prev
	if previous == a.head || previous.count != current.count-1 {
		previous = &bucket{count: current.count - 1, keys: make(map[string]struct{})}
		a.insertAfter(current.prev, previous)
	}
	a.move(key, current, previous)
}

func (a *AllOne) GetMaxKey() string {
	if a.tail.prev == a.head {
		return ""
	}
	return anyKey(a.tail.prev.keys)
}

func (a *AllOne) GetMinKey() string {
	if a.head.next == a.tail {
		return ""
	}
	return anyKey(a.head.next.keys)
}

func (a *AllOne) insertAfter(left, node *bucket) {
	node.prev, node.next = left, left.next
	left.next.prev = node
	left.next = node
}

func (a *AllOne) move(key string, from, to *bucket) {
	delete(from.keys, key)
	to.keys[key] = struct{}{}
	a.keyBucket[key] = to
	a.removeIfEmpty(from)
}

func (a *AllOne) removeIfEmpty(node *bucket) {
	if len(node.keys) != 0 {
		return
	}
	node.prev.next = node.next
	node.next.prev = node.prev
}

func anyKey(keys map[string]struct{}) string {
	for key := range keys {
		return key
	}
	return ""
}
