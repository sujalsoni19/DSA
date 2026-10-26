package leetcode.Recursion;

// LC: 50. Pow(x, n)
// the approach is to use recursion, we can break down the problem into smaller subproblems. We can use the property that x^n = (x^(n/2))^2 if n is even, and x^n = x * (x^(n-1)) if n is odd. This allows us to reduce the exponent by half in each recursive call, leading to a logarithmic time complexity.

public class Power {
    public double myPow(double x, int n) {
        long exponent = n;

        if(exponent<0){
            exponent = -exponent;
            return 1.0/power(x, exponent);
        }

        return power(x,exponent); 
    }

    private double power(double x, long n){
        if(n == 0) return 1.0;

        double half = power(x, n/2);

        if(n%2 == 0) return half*half;

        else return half*half*x;
 
    }

}
