package leetcode.Basics;

// LC.2427 number of common factors

class NoOfCommonFactors {
    public int commonFactors(int a, int b) {
        int min = Math.min(a,b);

        int count = 0;

        for(int i=1; i<=min; i++){
            if(a%i == 0 && b%i == 0) count++;
        }
        return count++;
    }
}