package leetcode.String;

// lc 2243. Calculate Digit Sum of a String
// potd: 16th november 2026

public class CalDigitSum {
    class Solution {
        public String digitSum(String s, int k) {

            while (s.length() > k) {
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < s.length(); i += k) {
                    String sample = s.substring(i, Math.min(i + k, s.length()));

                    int sum = 0;

                    for (int j = 0; j < sample.length(); j++) {
                        sum += sample.charAt(j) - '0';
                    }

                    result.append(sum);
                }

                s = result.toString();
            }
            return s;
        }

    }
}
