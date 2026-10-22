package leetcode.Sorting.Cyclicsort;

import java.util.ArrayList;
import java.util.List;

// LC 442. Find All Duplicates in an Array

public class AllDuplicateNos {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int i = 0;

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
            if (nums[j] != j + 1)
                result.add(nums[j]);
        }

        return result;
    }

}
