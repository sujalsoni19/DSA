
// LC 88. Merge Sorted Array 


// my approach
// unnecessary checks for m and n being greater than 0, as the loop will handle those cases correctly without needing explicit checks
// the loop can be simplified to just compare the elements of nums1 and nums2 and merge them accordingly, without needing to check for the counts of remaining elements in each array

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int j = m-1;
//         int k = n-1;
        
//         for(int i=m+n-1;i>=0;i--){
//             if(m>0 && n>0){
//                 if(k<0){
//                     nums1[i] = nums1[j--];
//                     continue;
//                 }
//                 if(j<0){
//                     nums1[i] = nums2[k--];
//                     continue;
//                 }
//                 if(nums1[j]<=nums2[k]){
//                     nums1[i] = nums2[k--];
//                 }
//                 else{
//                     nums1[i] = nums1[j--];
//                 }
//             }
//             else if(m>0 && n==0){
//                 nums1[i] = nums1[j--];
//             }
//             else if(n>0 && m==0){
//                 nums1[i] = nums2[k--];
//             }
//         }
//     }
// }


// optimal approach
// only check until k is greater than or equal to 0, as once k is less than 0, it means all elements from nums2 have been merged and we can stop the loop
// “We stop only when nums2 is fully merged — nums1 can take care of itself.”

// nums1 already contains its own elements in correct sorted order (first m elements)
// nums2 must be fully inserted into nums1

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1;
        int k = n - 1;
        int i = m + n - 1;

        while (k >= 0) {  // only need to check nums2
            if (j >= 0 && nums1[j] > nums2[k]) {
                nums1[i--] = nums1[j--];
            } else {
                nums1[i--] = nums2[k--];
            }
        }
    }
}