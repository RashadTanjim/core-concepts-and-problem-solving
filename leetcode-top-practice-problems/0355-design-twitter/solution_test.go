package p0355

import (
	"reflect"
	"testing"
)

func TestTwitterFeedAndFollowLifecycle(t *testing.T) {
	twitter := Constructor()
	twitter.PostTweet(1, 5)
	if got := twitter.GetNewsFeed(1); !reflect.DeepEqual(got, []int{5}) {
		t.Fatalf("own feed = %v, want [5]", got)
	}
	twitter.Follow(1, 2)
	twitter.PostTweet(2, 6)
	if got := twitter.GetNewsFeed(1); !reflect.DeepEqual(got, []int{6, 5}) {
		t.Fatalf("followed feed = %v, want [6 5]", got)
	}
	twitter.Unfollow(1, 2)
	if got := twitter.GetNewsFeed(1); !reflect.DeepEqual(got, []int{5}) {
		t.Fatalf("unfollowed feed = %v, want [5]", got)
	}
}
