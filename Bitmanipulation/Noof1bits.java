
// LC. 191. Number of 1 Bits

public class Noof1bits {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

}
