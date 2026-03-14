package leetcode.Array;

// LC 1752. Check if Array Is Sorted and Rotated

// atmost 1 decrease allowed; if more than 1 decrease, then not sorted and rotated; if 0 decrease, then sorted but not rotated; if 1 decrease, then sorted and rotated
// decrease means nums[i] > nums[i+1]; we can use modulo to check last element with first element as well

class Solution {
    public boolean check(int[] nums) {
       int count = 0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]>nums[(i+1)%nums.length]){
            count++;
           }
        }
        return count <= 1;
    }
}
