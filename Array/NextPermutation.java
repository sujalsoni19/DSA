package leetcode.Array;

// Lc 31. Next Permutation

// will work only for sorted array, not for all cases
// class Solution {
//     public void nextPermutation(int[] nums) {
//         boolean isAsc = false;
//         boolean isDesc  = false;
//         int n = nums.length;
//         int temp;

//         for(int i = 1;i<n;i++){
//             if(nums[i]>=nums[i-1]){
//                 isAsc = true;
//             }
//             else if(nums[i]<=nums[i-1]){
//                 isDesc = true;
//             }
//             else{
//                 isAsc = false;
//                 isDesc = false;
//                 break;
//             }
//         }

//         for(int i=0;i<n;i++){
//             if(isAsc){
//                 temp = nums[n-2];
//                 nums[n-2] = nums[n-1];
//                 nums[n-1] = temp;
//                 break;
//             }
//             else if(isDesc){
//                 Arrays.sort(nums);
//                 break;
//             }
//         }
//     }
// }

// optimal solution
// steps:
// 1. find the rightmost pair of indice i such that i < i+1 and nums[i] < nums[i+1]. If no such indices exist, the permutation is the last permutation. In this case, we can simply reverse the array to get the first permutation.
// 2. Find the rightmost index k such that nums[i] < nums[k]. Since i < i+1, such an index must exist.
// 3. Swap the value of nums[i] with that of nums[k].
// 4. Reverse the sequence from nums[i + 1] up to and including the final element nums[n - 1].
// Time complexity: O(n) where n is the length of the input array. In the worst case, we might have to reverse the entire array, which takes O(n) time.

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n - 1);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }

            reverse(nums, index + 1, n - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}