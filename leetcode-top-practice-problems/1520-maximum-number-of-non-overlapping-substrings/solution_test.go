package p1520

import (
	"reflect"
	"testing"
)

func TestMaxNumOfSubstrings(t *testing.T) {
	if got := maxNumOfSubstrings("adefaddaccc"); !reflect.DeepEqual(got, []string{"e", "f", "ccc"}) {
		t.Fatalf("maxNumOfSubstrings() = %v, want [e f ccc]", got)
	}
}
