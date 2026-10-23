package leetcode.Array;

// LC 48. Rotate Image
// steps are : to first transpose the matrix and then reverse each row of the matrix. This will give us the rotated matrix.

public class RotateMatrix {
    static void swap(int[][] matrix, int i, int left, int right){
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;
    }

    public void rotate(int[][] matrix) {

        //transpose the matrix
        for(int i=0; i<matrix.length; i++ ){
            for(int j=i+1; j<matrix[i].length; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
            }
        }

        //reverse each row of the matrix
        for(int i=0; i<matrix.length; i++){
            int left = 0;
            int right = matrix.length - 1;

            while(left<right){
                swap(matrix, i, left, right);
                left++;
                right--;
            }
        }
    }

}
