package leetcode.Array;

// lc 453. Minimum Moves to Equal Array Elements
// potd:  1 november 2026

public class MinMovestoequalArray {

    // 1st approach is to find the minimum element in the array and then increment
    // all other elements by 1 until all elements are equal to the minimum element.
    // The number of moves required will be equal to the difference between the
    // maximum and minimum elements in the array.
    public int minMoves(int[] nums) {

        int moves = 0;

        while (true) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int n : nums) {
                min = Math.min(n, min);
                max = Math.max(n, max);
            }

            if (min == max)
                return moves;

            boolean isSkipped = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max && !isSkipped) {
                    isSkipped = true;
                    continue;
                }
                nums[i]++;
            }
            moves++;
        }

    }

    // 2nd approach is reversing the logic of the first approach. Instead of
    // incrementing all elements except the maximum element, we can decrement the
    // maximum element until all elements are equal to the minimum element. The
    // number of moves required will be equal to the difference between the maximum
    // and minimum elements in the array.

    public int minMoves2(int[] nums) {

        int moves = 0;

        while (true) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int n : nums) {
                min = Math.min(n, min);
                max = Math.max(n, max);
            }

            if (min == max)
                return moves;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max) {
                    nums[i]--;
                    break;
                }
            }
            moves++;
        }

    }

    // 3rd approach is using the formula: sum - (n * min), where sum is the sum of all elements in the array, n is the number of elements in the array, and min is the minimum element in the array.
    public int minMoves3(int[] nums) {

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int n : nums) {
            sum += n;
            min = Math.min(n, min);
        }

        return sum - (nums.length * min);

    }

}
