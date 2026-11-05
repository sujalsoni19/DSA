package leetcode.Array;

import java.util.Arrays;

// lc 1385. Find the Distance Value Between Two Arrays
// potd : 5th nov 2026

public class DistanceValue {
    // brute force
    // time complexity: O(n*m)
    // public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    // int value = 0;
    // for (int i = 0; i < arr1.length; i++) {
    // boolean isValid = true;
    // for (int j = 0; j < arr2.length; j++) {
    // if (Math.abs(arr1[i] - arr2[j]) <= d) {
    // isValid = false;
    // break;
    // }
    // }
    // if (isValid)
    // value++;
    // }
    // return value;
    // }


    // optimized approach
    // time complexity: O(nlogm)
    // range is a-d to a+d
    // the arr2 is sorted and then for each element in arr1, we find the lower bound of (arr1[i]-d) in arr2. If the lower bound index is equal to the length of arr2 or the element at that index is greater than (arr1[i]+d), then we can say that the element in arr1 is valid and we can increment the count.


    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

            Arrays.sort(arr2);

            int count = 0;

            for (int x : arr1) {

                int index = lowerBound(arr2, x - d);

                if (index == arr2.length || arr2[index] > x + d) {
                    count++;
                }
            }

            return count;
        }

        public int lowerBound(int[] arr, int target) {

            int low = 0;
            int high = arr.length;

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }
    }
}
