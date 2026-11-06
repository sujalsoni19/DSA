import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 18. 4Sum
// same approach as 3sum, but with an additional loop(also additional checking for its duplicates) to fix the second number and then use two pointers to find the other two numbers that sum up to the target.

public class Foursum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;

                    int left = j + 1;
                    int right = nums.length - 1;

                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                        if (sum < target)
                            left++;
                        else if (sum > target)
                            right--;
                        else {
                            List<Integer> ans = new ArrayList<>(List.of(nums[i], nums[j], nums[left], nums[right]));
                            result.add(ans);
                            left++;
                            right--;

                            while (left < right && nums[left] == nums[left - 1])
                                left++;
                            while (left < right && nums[right] == nums[right + 1])
                                right--;
                        }

                    }

                }
            }
            return result;
        }
    }
}
