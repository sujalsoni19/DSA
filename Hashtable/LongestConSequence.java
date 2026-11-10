import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// lc 128. Longest Consecutive Sequence

public class LongestConSequence {

    // optimized approach: use a HashSet to store the numbers and then iterate
    // through the set to find the longest consecutive sequence. This approach has a
    // time complexity of O(n), where n is the number of elements in the input
    // array.
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) { // only check for the start of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // brute force approach: sort the array and then iterate through it to find the longest consecutive sequence. This approach has a time complexity of O(n log n), where n is the number of elements in the input array.

    class Solution {
        public int longestConsecutive(int[] nums) {

            if (nums.length == 0)
                return 0;

            Arrays.sort(nums);

            int count = 1;
            int maxCount = 1;

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] == nums[i - 1])
                    continue;

                if (nums[i] == nums[i - 1] + 1) {
                    count++;
                } else {
                    count = 1;
                }

                maxCount = Math.max(count, maxCount);
            }

            return maxCount;
        }
    }

}