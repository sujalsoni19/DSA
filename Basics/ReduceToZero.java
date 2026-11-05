package leetcode.Basics;

// lc 1342. Number of Steps to Reduce a Number to Zero

public class ReduceToZero {
    class Solution {
        public int numberOfSteps(int num) {

            // 1st approach: iterative
            // int count = 0;
            // while(num > 0){
            // count++;
            // if(num%2 == 0) num /= 2;
            // else num -= 1;
            // }
            // return count;

            //2nd approach: recursive
            return helper(num, 0);
        }

        private int helper(int num, int count) {
            if (num == 0)
                return count;

            if ((num & 1) == 0)
                return helper(num / 2, count + 1);
            else
                return helper(num - 1, count + 1);
        }
    }
}
