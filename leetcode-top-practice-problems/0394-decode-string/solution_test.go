package p0394

import "testing"

func TestDecodeString(t *testing.T) {
	for input, want := range map[string]string{
		"3[a2[c]]":    "accaccacc",
		"2[abc]3[cd]": "abcabccdcdcd",
		"10[a]":       "aaaaaaaaaa",
	} {
		if got := decodeString(input); got != want {
			t.Errorf("decodeString(%q) = %q, want %q", input, got, want)
		}
	}
}
