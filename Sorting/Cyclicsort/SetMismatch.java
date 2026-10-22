package leetcode.Sorting.Cyclicsort;

// LC 645. Set Mismatch

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int[] result = new int[2];

        while (i < nums.length) {
            int index = nums[i] - 1;

            if (nums[index] != nums[i]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result[0] = nums[j];
                result[1] = j + 1;
            }
        }
        return result;
    }

}
