package leetcode.Array;

// lc 3736. Minimum Moves to Equal Array Elements III
// potd:  3 november 2026

public class MinMovestoequalArray3 {
    class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int n:nums){
            sum += n;
            max = Math.max(n,max);
        }

        return (nums.length*max) - sum;
      
    }
}
}
