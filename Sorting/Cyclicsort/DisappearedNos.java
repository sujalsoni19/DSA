package leetcode.Sorting.Cyclicsort;

import java.util.ArrayList;
import java.util.List;

// LC 448. Find All Numbers Disappeared in an Array

public class DisappearedNos {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

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

        for(int j = 1; j<=nums.length; j++){
            if(j != nums[j-1]) list.add(j);
        }

        return list;
    }

}
