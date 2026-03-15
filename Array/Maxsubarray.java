package leetcode.Array;

// LC 53. Maximum Subarray
// Kadane's Algorithm
// if we want to print the subarray also then we can maintain a start and end pointer and update them when we get a new maxsum


class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum=0;
        int maxsum=Integer.MIN_VALUE;

        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            maxsum = Math.max(sum,maxsum);

            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}