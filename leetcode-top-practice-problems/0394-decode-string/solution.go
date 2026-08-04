package p0394

import "strings"

func decodeString(s string) string {
	counts := make([]int, 0)
	prefixes := make([]string, 0)
	current := ""
	repeat := 0

	for _, ch := range s {
		switch {
		case ch >= '0' && ch <= '9':
			repeat = repeat*10 + int(ch-'0')
		case ch == '[':
			counts = append(counts, repeat)
			prefixes = append(prefixes, current)
			repeat = 0
			current = ""
		case ch == ']':
			last := len(counts) - 1
			current = prefixes[last] + strings.Repeat(current, counts[last])
			counts = counts[:last]
			prefixes = prefixes[:last]
		default:
			current += string(ch)
		}
	}
	return current
}
