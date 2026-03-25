package BSon2DArray;


// LC 74. Search a 2D Matrix

// BRUTE FORCE: O(m*n) time -> MESTED FOR LOOP

// BETTER: O(m+logn) time -> FIRST FIND THE ROW IN WHICH TARGET IS PRESENT THEN DO BINARY SEARCH IN THAT ROW

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int start = 0;
//         boolean isPresent = false; 
        
//         while(start<matrix.length){
//             int m = matrix[start].length - 1; 
//             if(target >= matrix[start][0] && target <= matrix[start][m]){
//                 isPresent = bs(matrix[start], target, 0, m);
//                 break;
//             }
//             start++;
//         }
//         return isPresent;
//     }

    // private boolean bs(int[] nums, int target, int start, int end){
    //     while(start<=end){
    //         int mid = start + (end-start) / 2;

    //         if(nums[mid] < target){
    //             start = mid+1;
    //         }
    //         else if(nums[mid] > target){
    //             end = mid-1;
    //         }
    //         else{
    //             return true;
    //         }
    //     }
    //     return false;
    // }
// }

// OPTIMAL: O(log(m*n)) time -> TREAT THE 2D MATRIX AS A 1D ARRAY AND DO BINARY SEARCH IN THAT ARRAY

// The matrix is stored row by row, so each row contains n elements.
// Therefore we divide and take modulo with n to determine the row and column.

// row = mid / n;
// col = mid % n;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n - 1;

        while(start<=end){
            int mid = start + (end-start) / 2;

            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col] == target){
                return true;
            }

            if(matrix[row][col] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return false;
    }
}