// Order-agnostic means the algorithm works whether the array is sorted ascending or descending
// Normal binary search assumes ascending order, but order-agnostic binary search detects the order first.

public class OrderAgnosticBS {
    public static void main(String[] args) {
        // int[] nums = { -87, -43, -2, 0, 2, 23, 46, 123, 456, 466, 897, 998 };
        int[] nums ={567,543,423,89,69,24,1,-3,-567,-999,-1025};
        int target = 543;
        System.out.println(OrderAgnosticBinarySearch(nums, target));

    }

    static int OrderAgnosticBinarySearch(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        boolean isAsc = nums[start] < nums[end];

        while (start <= end) {

            // int mid = (start+end) / 2;
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
