
// LC. 137. Single Number II
// the approach is to count the number of bits in each position for all numbers. Since every number except one appears three times, the sum of bits at each position will be a multiple of 3 for those numbers. The unique number will contribute to the sum in such a way that it will not be a multiple of 3. By checking each bit position, we can reconstruct the unique number.

public class Singlenumber2{
    

    // Function to find the single number using the bit counting approach
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // Iterate through all 32 bits of an integer
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            
            // Count how many numbers have the i-th bit set
            for (int num : nums) {
                if ((num & (1 << i)) == 1) {
                    sum++;
                }
            }
            
            // If the sum is not a multiple of 3, the unique number has this bit set
            if (sum % 3 != 0) {
                result = result | (1 << i);
            }
        }
        
        return result;
    }

}