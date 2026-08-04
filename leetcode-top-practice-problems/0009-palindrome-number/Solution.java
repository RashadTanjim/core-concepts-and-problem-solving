// Adapted from doocs/leetcode under CC BY-SA 4.0.
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        for (; y < x; x /= 10) {
            y = y * 10 + x % 10;
        }
        return x == y || x == y / 10;
    }
}
