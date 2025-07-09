package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution933 { // RecentCounter
    private final Queue<Integer> queue;

    public Solution933() { // RecentCounter()
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Solution933 counter = new Solution933();

        System.out.println(counter.ping(1));     // 1
        System.out.println(counter.ping(100));   // 2
        System.out.println(counter.ping(3001));  // 3
        System.out.println(counter.ping(3002));  // 3
    }
}
