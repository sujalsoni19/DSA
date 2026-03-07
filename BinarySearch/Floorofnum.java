// Floor: largest element ≤ target

public class Floorofnum {
    public static void main(String[] args) {
        int[] nums = {-87, -43, -2 ,0, 2, 23, 46, 123, 456, 466, 897, 998};
        int target = 100000;
        System.out.println(binarySearch(nums, target));

    }

    static int binarySearch(int[] nums, int target){

         if(target < nums[0]) return -1; // imp edge case

        int start = 0;
        int end = nums.length -1;

        while(start<=end){

            int mid = (start+end) / 2;
        //  int mid = start + (end-start) / 2;

            if(nums[mid] > target){
                end = mid-1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                return nums[mid];
            }
        }
        return nums[end];
    }
}
