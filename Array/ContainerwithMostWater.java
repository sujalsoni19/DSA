package leetcode.Array;


// LC 11. Container With Most Water

// time complexity o(n^2) and it fails for large input as it is a brute force approach. We can optimize it using two pointer approach.

// class Solution {
//     public int maxArea(int[] height) {

//         int maxprofit = 0;

//         for(int i=0;i<height.length;i++){
//             for(int j=i+1;j<height.length;j++){
//                 int profit = Math.min(height[i],height[j]) * (j - i);
//                 maxprofit = Math.max(maxprofit,profit);
//             }
//         }
//         return maxprofit;
//     }
// }

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;

        while(left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            maxarea = Math.max(area,maxarea);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
    }
}