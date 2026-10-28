
// LC: 461. Hamming Distance

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;

        while(result != 0){
            result = result & (result-1);
            count++;
        }

        return count;
    }

}
