package p1520

func maxNumOfSubstrings(s string) []string {
	first, last := [26]int{}, [26]int{}
	for i := range first {
		first[i] = len(s)
		last[i] = -1
	}
	for i := 0; i < len(s); i++ {
		c := int(s[i] - 'a')
		if i < first[c] {
			first[c] = i
		}
		last[c] = i
	}

	answer := make([]string, 0)
	previousEnd := -1
	for start := 0; start < len(s); start++ {
		c := int(s[start] - 'a')
		if first[c] != start {
			continue
		}
		end := last[c]
		valid := true
		for i := start; i <= end; i++ {
			x := int(s[i] - 'a')
			if first[x] < start {
				valid = false
				break
			}
			if last[x] > end {
				end = last[x]
			}
		}
		if !valid {
			continue
		}

		if start > previousEnd {
			answer = append(answer, s[start:end+1])
		} else {
			answer[len(answer)-1] = s[start : end+1]
		}
		previousEnd = end
	}
	return answer
}
