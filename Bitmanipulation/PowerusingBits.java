
// LC. 50. Pow(x, n)

public class PowerusingBits {
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(power(x, n));
    }

    static double power(int x, int n){
        double result = 1;
        while(n>0){
            if((n&1) == 1){
                result *= x;
            }
            n >>= 1;
            x *= x;
        }
        return result;
    }
}
