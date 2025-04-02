package leetcode;

public class Solution190 {
    // You need to treat n as an unsigned value

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n & 1);  // Extract last bit
            var v = (result << 1);  // Shift left
            result = v | bit;  // add bit
            n >>>= 1;  // Unsigned right shift
        }

        return result;
    }

    public static void main(String[] args) {
        Solution190 sol = new Solution190();

        int input = 0b00000000000000000000000000000100;  // Binary for 4
        System.out.println("Original Decimal Input: " + input);
        System.out.println("Original Binary Input: " +
                String.format("%32s", Integer.toBinaryString(input)).replace(' ', '0')); // 00000000000000000000000000000100

        int output = sol.reverseBits(input);

        System.out.println("Reversed Decimal Output: " + output); // 536870912
        System.out.println("Reversed Binary Output: " +
                String.format("%32s", Integer.toBinaryString(output)).replace(' ', '0')); // 00100000000000000000000000000000
    }
}
