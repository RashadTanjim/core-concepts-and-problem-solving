// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, mi = prices[0];
        for (int v : prices) {
            ans = Math.max(ans, v - mi);
            mi = Math.min(mi, v);
        }
        return ans;
    }
}
