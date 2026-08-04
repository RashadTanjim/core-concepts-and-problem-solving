package p0150

import "testing"

func TestEvalRPN(t *testing.T) {
	if got := evalRPN([]string{"4", "13", "5", "/", "+"}); got != 6 {
		t.Fatalf("evalRPN() = %d, want 6", got)
	}
}
