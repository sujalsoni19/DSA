package leetcode.Basics;

// lc 204. Count Primes

public class CountPrimes {
    class Solution {
        public int countPrimes(int n) {
            if (n < 2)
                return 0;

            boolean[] primes = new boolean[n];
            int count = 0;

            for (int i = 2; i * i < n; i++) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }

            for (int k = 2; k < primes.length; k++) {
                if (!primes[k])
                    count++;
            }

            return count++;

        }
    }
}
