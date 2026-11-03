package leetcode.Array;

import java.util.Arrays;

// lc 462. Minimum Moves to Equal Array Elements II
// potd:  2 november 2026

class MinMovestoequalArray2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int moves = 0;

        for(int n:nums){
            moves += Math.abs(median - n);
        }

        return moves;
    }
}