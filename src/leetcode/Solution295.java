package leetcode;

import java.util.*;

public class Solution295 {

    private final PriorityQueue<Integer> maxHeap; // Left half (stores smaller numbers, maxHeap)
    private final PriorityQueue<Integer> minHeap; // Right half (stores larger numbers, minHeap)

    public Solution295() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max-Heap
        minHeap = new PriorityQueue<>(); // Min-Heap
    }

    public void addNum(int num) {
        // Step 1: Insert into appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Step 2: Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move from maxHeap to minHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move from minHeap to maxHeap
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // Odd number of elements
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0; // Even number of elements
    }

    public static void main(String[] args) {
        Solution295 medianFinder = new Solution295();

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian()); // Output: 1.0

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5

        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0

        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian()); // Output: 2.5
    }
}
