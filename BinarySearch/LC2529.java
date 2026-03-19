
// LC 2529. Maximum Count of Positive Integer and Negative Integer

// BRUTE FORCE

// linear scan to count positive and negative integers and return the max of the two counts

// class solution {
//     public int maximumCount(int[] nums) {
//         int positiveCount = 0;
//         int negativeCount = 0;

//         for (int num : nums) {
//             if (num > 0) {
//                 positiveCount++;
//             } else if (num < 0) {
//                 negativeCount++;
//             }
//         }

//         return Math.max(positiveCount, negativeCount);
//     }
// }





// optimal approach

// use two binary searches to find the first positive integer and the last negative integer, then calculate the counts of positive and negative integers based on the indices found and return the maximum of the two counts

class Solution {
    public int maximumCount(int[] nums) {

    int pstart = positiveFirst(nums, 0, nums.length - 1);
    int nend = negativeLast(nums, 0, nums.length - 1);
        
    int positiveCount = (pstart == -1) ? 0 : nums.length - pstart;
    int negativeCount = (nend == -1) ? 0 : nend + 1;

    return Math.max(positiveCount, negativeCount);

    }

 private int positiveFirst(int[] nums,int start, int end){
    int pindex=-1;
    while(start<=end){
            int mid = start + (end-start) / 2;

            if(nums[mid]>0){
                pindex = mid;
                end=mid-1;
            }
            else{
                start = mid+1;
            }
        }

    return pindex;
 }

 private int negativeLast(int[] nums, int start, int end){
    int nindex=-1;
    while(start<=end){
        int mid = start + (end-start) / 2;

        if(nums[mid]<0){
            nindex = mid;
            start = mid+1; 
        }
        else{
            end=mid-1;
        }
    }
    return nindex;
 }
}