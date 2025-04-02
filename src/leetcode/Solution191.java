package leetcode;

public class Solution191 {
    public int hammingWeight(int n) { // Brian Kernighan’s Algorithm
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);  // Flip the least significant 1-bit
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution191 sol = new Solution191();
        int input = 11;  // Binary: 00000000000000000000000000001011
        System.out.println("Hamming Weight: " + sol.hammingWeight(input));  // Output: 3
    }
}
