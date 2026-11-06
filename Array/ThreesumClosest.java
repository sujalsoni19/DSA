import java.util.Arrays;

// lc 16. 3Sum Closest

public class ThreesumClosest {

    //1st approach: Brute Force
    // time complexity: O(n^3)
    // approach is to use three nested loops to find all possible triplets and calculate their sum. We keep track of the closest sum to the target and return it at the end.
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int proximity = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (proximity > Math.abs(target - sum)) {
                            proximity = Math.abs(target - sum);
                            result = sum;
                        }
                    }
                }
            }
            return result;
        }
    }

    //2nd approach: Two Pointers
    // time complexity: O(n^2)
    // approach is to sort the array first and then use two pointers to find the closest sum to the target.

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target)
                    return target;

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum > target)
                    right--;
                else
                    left++;
            }

        }
        return result;
    }
}