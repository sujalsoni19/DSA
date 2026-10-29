

// LC. 260. Single Number III
// the approach is to use XOR to find the two unique numbers in an array where every other number appears twice. First, we XOR all the numbers to get a combined XOR of the two unique numbers. Then, we find a bit that is set in the combined XOR (this bit will be different for the two unique numbers). We can then partition the numbers into two groups based on this bit and XOR each group separately to find the two unique numbers.

public class Singlenumber3 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];

        int xorAll = nums[0];

        for(int i=1; i<nums.length; i++){
            xorAll ^= nums[i];
        }

        int rmb = xorAll & -xorAll;

        for(int i=0; i<nums.length; i++){
            if((nums[i] & rmb) != 0){
                result[0] ^= nums[i];
            }
            else{
                result[1] ^= nums[i];
            }
        }

        return result;
    }
}
