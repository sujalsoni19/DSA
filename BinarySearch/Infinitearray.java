public class Infinitearray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,18 ,19, 20 };
        int target = 25;

        int start = 0;
        int end = 1;

        while (end < arr.length - 1 && target > arr[end]) {
            // start = end + 1;
            // end = end * 2;

            // more efficient way to update start and end
            int newstart = end + 1;
            // end = previous end + size of the previous box * 2
            end = end + (end - start + 1) * 2;

            // to avoid out of bound error
            if(end >= arr.length){
                end = arr.length - 1;
                break;
            }

            start = newstart;
        }

        System.out.println(binarysearch(arr, target, start, end));
    }

    static int binarysearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}