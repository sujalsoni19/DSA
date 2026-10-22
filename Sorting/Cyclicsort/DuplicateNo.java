package leetcode.Sorting.Cyclicsort;

// LC 287. Find the Duplicate Number

public class DuplicateNo {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while(i<nums.length){
            int index = nums[i] - 1;

            if(nums[index] != nums[i]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }
        return nums[nums.length - 1];
    }

}
