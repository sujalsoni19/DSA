package BSon2DArray;

// LC 240. Search a 2D Matrix II

// BRUTE FORCE: O(m*n) time -> MESTED FOR LOOP

// BETTER: O(m+logn) time -> FIRST FIND THE ROW IN WHICH TARGET IS PRESENT THEN DO BINARY SEARCH IN THAT ROW

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int start = 0;
//         int m = matrix[0].length - 1;
//         boolean isPresent = false;

//         while(start<matrix.length){
//             if(target >= matrix[start][0] && target <= matrix[start][m]){
//                 isPresent = bs(matrix[start], target, 0, m);
//                 if(isPresent == true) break; // rows are overlapping so we need to check in all the rows
//             }
//             start++;
//         }
//         return isPresent;
//     }

//     private boolean bs(int[] nums, int target, int start, int end){
//         while(start<=end){
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


// OPTIMAL: O(m+n) time -> START FROM THE TOP RIGHT CORNER or BOTTOM LEFT CORNER AND COMPARE THE ELEMENT WITH TARGET
// IF THE ELEMENT IS GREATER THAN TARGET THEN MOVE LEFT OTHERWISE MOVE DOWN

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n-1;

        while(row<m && col>=0){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

   
}
