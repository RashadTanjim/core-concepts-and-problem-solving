// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

class Solution {
    public boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (mx < i) {
                return false;
            }
            mx = Math.max(mx, i + nums[i]);
        }
        return true;
    }
}
