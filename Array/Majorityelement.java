// LC. 169 Majority Element

//MOORE VOTING ALGORITHM -> THINK OF IT LIKE AS ** ELECTION **, THE ELEMENT WHICH HAS MORE THAN N/2 VOTES WILL BE THE MAJORITY ELEMENT

class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                element = nums[i];
                count = 1;
            }
            else if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
}
