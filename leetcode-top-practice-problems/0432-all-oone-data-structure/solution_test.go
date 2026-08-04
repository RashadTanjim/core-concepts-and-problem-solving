package p0432

import "testing"

func TestAllOne(t *testing.T) {
	all := Constructor()
	all.Inc("hello")
	all.Inc("hello")
	all.Inc("leet")
	if got := all.GetMaxKey(); got != "hello" {
		t.Fatalf("max = %q, want hello", got)
	}
	if got := all.GetMinKey(); got != "leet" {
		t.Fatalf("min = %q, want leet", got)
	}
	all.Dec("hello")
	all.Dec("leet")
	if got := all.GetMinKey(); got != "hello" {
		t.Fatalf("remaining key = %q, want hello", got)
	}
}
