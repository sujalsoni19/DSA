// 1672. Richest Customer Wealth

public class LC1672{
    public static void main(String[] args){
        int[][] matrix = {{2,8,7},{7,1,3},{1,9,5}};
        int maxWealth = 0;
        for(int i=0;i<matrix.length;i++){
            int value = 0;
            for(int j=0;j<matrix[i].length;j++){
                value += matrix[i][j];
            }
            if(value>maxWealth) maxWealth = value;
        }
        System.out.println(maxWealth);
    }
}