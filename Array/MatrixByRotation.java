package leetcode.Array;

// LC 1886. Determine Whether Matrix Can Be Obtained By Rotation
// idea is to rotate the matrix and check if it is equal to the target matrix.

public class MatrixByRotation {

    // optimized soln with checking the matrix with target before rotating the matrix. This will save us from rotating the matrix 4 times in case the target is already equal to the matrix.
    public static boolean check(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void rotate(int[][] mat) {
        int n = mat.length;

        //transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (check(mat, target))
                return true;
            if (i < 3)
                rotate(mat);
        }
        return false;
    }

    // my soln: almost same as above but without checking the matrix with target before rotating the matrix. This will rotate the matrix 4 times even if the target is already equal to the matrix.

    // public void swap(int[][] matrix, int i, int j){
    //     int temp = matrix[i][j];
    //     matrix[i][j] = matrix[j][i];
    //     matrix[j][i] = temp;
    // }

    // public void swap(int[][] matrix, int i, int left, int right){
    //     int temp = matrix[i][left];
    //     matrix[i][left] = matrix[i][right];
    //     matrix[i][right] = temp;
    // }

    // public boolean findRotation(int[][] mat, int[][] target) {
    //     int n = mat.length;
    //     boolean isEqual = true;

    //     for(int z=0; z<4; z++){

    //         isEqual = true;
            
    //         for(int i=0; i<n; i++){
    //             for(int j=i+1; j<n; j++){
    //                 swap(mat, i, j);
    //             }
    //         }

    //         for(int i=0; i<n; i++){
    //             int left = 0;
    //             int right = n-1;

    //             while(left<right){
    //                 swap(mat, i, left, right);
    //                 left++;
    //                 right--;
    //             }
    //         }

    //          for(int i=0; i<n; i++){
    //             for(int j=0; j<n; j++){
    //                 if(mat[i][j] == target[i][j]){
    //                     isEqual = true;
    //                 }
    //                 else{
    //                     isEqual = false;
    //                     break;
    //                 }
    //             }
    //             if(!isEqual) break;
    //         }
    //         if(isEqual) break;
    //     }
    //     return isEqual;
    // }
}
