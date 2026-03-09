// LC. 75 Sort Colors

// brute force -> sorting the array

// better approach:->  multiple loops(passes)
// public void sortColors(int[] nums) {
//         int rcount=0;
//         int wcount=0;
//         int bcount=0;

//         for(int i=0;i<nums.length;i++){
//             if(nums[i] == 0){
//                 rcount++;
//             }
//             else if(nums[i] == 1){
//                 wcount++;
//             }
//             else{
//                 bcount++;
//             }
//         }

//         for(int i=0;i<rcount;i++){
//             nums[i] =0;
//         }
//         for(int i=rcount;i<rcount+wcount;i++){
//             nums[i] =1;
//         }
//         for(int i=rcount+wcount;i<nums.length;i++){
//             nums[i] =2;
//         }
//     }

// optimal approach -> DNF(Dutch National Flag) algorithm

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low ++;
                mid ++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}