package leetcode.Basics;

// lc 69. Sqrt(x)

class SquareRoot {

    // 1st approach: Binary Search
    public int mySqrt(int x) {
        int start = 0;
        int end = x;

        int root = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((long) mid * mid == x)
                return mid;

            if ((long) mid * mid > x) {
                end = mid - 1;
            } else {
                root = mid;
                start = mid + 1;
            }
        }
        return root;
    }

    // 2nd approach: Newton's Method
    public int mySqrt2(int x) {

        if(x < 2) return x;

        long r = x;

        while(r * r > x) {
            r = (r + x / r) / 2;
        }

        return (int) r;
    }
}