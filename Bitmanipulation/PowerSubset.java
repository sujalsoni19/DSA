import java.util.ArrayList;
import java.util.List;

// LC. 78. Subsets
// THE approach is to use bit manipulation to generate all possible subsets of a given set of numbers. Each subset can be represented by a binary number where each bit indicates whether the corresponding element is included in the subset or not. By iterating through all possible binary numbers from 0 to 2^n - 1 (where n is the number of elements), we can generate all subsets.

public class PowerSubset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int listNumber = 1 << nums.length;

        for (int mask = 0; mask < listNumber; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            result.add(subset);
        }

        return result;
    }
}
