package leetcode;

import java.util.Arrays;

public class Solution75 {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) count[num]++;

        int index = 0;
        for (int i = 0; i <= 2; i++) {

            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution75 sol = new Solution75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // [0, 0, 1, 1, 2, 2]
    }

}
