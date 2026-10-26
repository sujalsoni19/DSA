package leetcode.Bitmanipulation;

// LC: 231. Power of Two
// the approach is to use bit manipulation, if n is a power of two, then it has only one bit set in its binary representation. Therefore, n & (n - 1) will be 0 for powers of two. Additionally, we need to check that n is greater than 0 since negative numbers and zero are not powers of two.

public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        
        return n>0 && (n & (n-1)) == 0;
    }

}
