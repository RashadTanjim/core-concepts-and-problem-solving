// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ++ans;
        }
        return ans;
    }
}
