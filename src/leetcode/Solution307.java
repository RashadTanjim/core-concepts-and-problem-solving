package leetcode;

public class Solution307 { // NumArray  -- Using Segment Tree
    private int[] tree;
    private int n;

    public Solution307(int[] nums) { // NumArray
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[2 * n];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        // fill leaf nodes
        if (n >= 0) System.arraycopy(nums, 0, tree, n, n);

        // build the tree by calculating parents
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        index += n; // Move to leaf
        tree[index] = val;

        while (index > 0) {
            int left = index;
            int right = index;
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            // move one level up
            tree[index / 2] = tree[left] + tree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;

        while (left <= right) {

            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Solution307 numArray = new Solution307(nums);

        System.out.println("sumRange(0, 2): " + numArray.sumRange(0, 2)); // 9
        numArray.update(1, 2);
        System.out.println("sumRange(0, 2): " + numArray.sumRange(0, 2)); // 8
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * <p>
 * Output
 * [null, 9, null, 8]
 * <p>
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 */