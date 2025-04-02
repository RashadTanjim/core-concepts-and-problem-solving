package leetcode;

public class Solution67 {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0'; // Convert char to int
            if (j >= 0) sum += b.charAt(j--) - '0'; // Convert char to int

            result.append(sum % 2); // Append remainder
            carry = sum / 2; // Update carry
        }

        return result.reverse().toString(); // Reverse final result
    }

    public static void main(String[] args) {
        Solution67 sol = new Solution67();
        System.out.println(sol.addBinary("1010", "1011")); // Output: "10101"
    }
}
