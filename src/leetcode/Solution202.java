package leetcode;

public class Solution202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

//  Floyd’s Cycle Detection (Tortoise and Hare)
    private static int getNext(int n) {
        int squareSum = 0;
        while (n > 0) {
            int digit = n % 10;
            squareSum += digit * digit;
            n /= 10;
        }
        return squareSum;
    }

    public static boolean isHappy(int n) {
        int slow = n, fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast)); // Move fast twice
        }

        return fast == 1;
    }

//    public static boolean isHappy(int n) {
//        Set<Integer> seen = new HashSet<>();
//
//        while (n != 1 && !seen.contains(n)) {
//            seen.add(n);
//            int squareSum = 0;
//            while (n > 0) {
//                int digit = n % 10;
//                squareSum += digit * digit;
//                n /= 10;
//            }
//            n = squareSum;
//        }
//
//        return n == 1;
//    }

}

