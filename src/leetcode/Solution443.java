package leetcode;

public class Solution443 {

    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count the number of repeating characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        Solution443 sc = new Solution443();

        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(sc.compress(chars1)); // Output: 6 → ['a','2','b','2','c','3']

        char[] chars2 = {'a'};
        System.out.println(sc.compress(chars2)); // Output: 1 → ['a']

        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(sc.compress(chars3)); // Output: 4 → ['a','b','1','2']
    }
}
