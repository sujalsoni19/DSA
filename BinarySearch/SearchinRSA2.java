
// LC 81. Search in Rotated Sorted Array II

// class Solution {
//     public boolean search(int[] nums, int target) {
//         int pivot = pivot(nums);
//         if(pivot == -1){
//             return bs(nums,0,nums.length-1,target);
//         }
//         if(nums[pivot] == target){
//             return true;
//         }
//         if(nums[0] <= target){
//             return bs(nums,0,pivot-1,target);
//         }
//         else{
//             return bs(nums,pivot+1,nums.length-1,target);
//         }
//     }

//     private int pivot(int[] nums){
//         int start = 0;
//         int end = nums.length - 1;

//         while(start <= end){
//             int mid = start + (end-start) / 2;

//             if(mid < end && nums[mid]>nums[mid+1]){
//                 return mid;
//             }
//             if(start < mid && nums[mid]<nums[mid-1]){
//                 return mid-1;
//             }
//             if(nums[start] == nums[mid] && nums[mid] == nums[end]){
//                 if(start < end && nums[start] > nums[start+1]){
//                     return start;
//                 }
//                 start++;

//                 if(end > start && nums[end] < nums[end-1]){
//                     return end-1;
//                 }
//                 end--;
//             }
//             else if(nums[start] > nums[mid]){
//                 end = mid-1;
//             }
//             else{
//                 start = mid+1;
//             }
//         }
//         return -1;
//     }

//     private boolean bs(int[] nums, int start, int end, int target){
//         while(start <= end){
//             int mid = start + (end-start) / 2;

//             if(nums[mid] < target){
//                 start = mid+1;
//             }
//             else if(nums[mid] > target){
//                 end = mid-1;
//             }
//             else{
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// another approach without finding pivot and only using one binary search

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start) / 2;

            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
            }
            else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
}