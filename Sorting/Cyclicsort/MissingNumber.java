package leetcode.Sorting.Cyclicsort;

// LC 268. Missing Number

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int index = nums[i];
            if (index >= n) {
                i++;
                continue;
            }

            if (nums[index] != nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (j != nums[j])
                return j;
        }

        return n;
    }
}
