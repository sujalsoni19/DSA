package leetcode.Basics;

// LC: 9. Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int ognum = x;
        int reverse = 0;

        while(num>0){
            int digit = num%10;
            reverse = (reverse*10) + digit;
            num = num/10;
        }

        if(ognum == reverse){
            return true;
        }
        else{
            return false;
        }
    }
}
