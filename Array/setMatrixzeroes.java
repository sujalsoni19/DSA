
// LC: 73. Set Matrix Zeroes

// 1st approach:
// wont work if there are -1 in the matrix already
// class Solution {
//     public void setZeroes(int[][] matrix) {

//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[i].length;j++){
//                 if(matrix[i][j] == 0){
//                     markrow(matrix,i);
//                     markcol(matrix,j);
//                 }
//             }
//         }

//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[i].length;j++){
//                 if(matrix[i][j] == -1){
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
//     public void markrow(int[][] matrix,int i){
//         for(int j=0;j<matrix[i].length;j++){
//             if(matrix[i][j] != 0){
//                 matrix[i][j] = -1;
//             }
//         }
//     }

//     public void markcol(int[][] matrix,int j){
//         for(int i=0;i<matrix.length;i++){
//             if(matrix[i][j] != 0){
//                 matrix[i][j] = -1;
//             }
//         }
//     }
// }

// 2nd approach: using first row and first column as markers
// wont work if there are 0 in the first row and first column already, so we need to check that separately and mark it with a boolean variable

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 if (matrix[i][j] == 0) {
//                     matrix[0][j] = 0;
//                     matrix[i][0] = 0;
//                 }
//             }
//         }
//         for (int i = matrix.length - 1; i >= 0; i--) {
//             for (int j = matrix[i].length - 1; j >= 0; j--) {
//                 checkforzero(matrix, i, j);
//             }
//         }
//     }

//     void checkforzero(int[][] matrix, int i, int j) {
//         if (matrix[0][j] == 0 || matrix[i][0] == 0) {
//             matrix[i][j] = 0;
//         }
//     }
// }

// 3rd approach: using two boolean variables to check if there are 0 in the first row and first column already, so we can use them as markers without worrying about overwriting them

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstrowzero = false;
        boolean firstcolzero = false;

        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j] == 0) firstrowzero = true;
        }

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0) firstcolzero = true;
        }
       
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstrowzero){
            for(int j=0;j<matrix[0].length;j++) matrix[0][j] = 0;
        }

        if(firstcolzero){
            for(int i=0;i<matrix.length;i++) matrix[i][0] = 0;
        }

        
        
    }
    
}