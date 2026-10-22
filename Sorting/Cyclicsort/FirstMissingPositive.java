package leetcode.Sorting.Cyclicsort;

// LC 41. First Missing Positive
// the idea is to place the numbers in their correct index position, i.e. 1 at index 0, 2 at index 1 and so on. After that we can check for the first index where the number is not equal to index+1 and return that index+1 as the answer. If all numbers are in their correct position then we return n+1 as the answer.

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while(i<nums.length){
            if(nums[i] <= 0 || nums[i]>nums.length){
                i++;
                continue;
            }

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

        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1) return j+1;
        }
        return nums.length+1;
    }

}
