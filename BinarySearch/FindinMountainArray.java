

// LC 1095. Find in Mountain Array


/** 
 * 
 * * // This is MountainArray's API interface. 
 * * // You should not implement it, or speculate about its implementation * 
 * interface MountainArray 
 * { * public int get(int index) {} 
 * * public int length() {} * 
 * } 
 * */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peak = findPeak(mountainArr);

        int first = binarySearch(mountainArr, target, 0, peak, true);
        if (first != -1) {
            return first;
        }

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    int findPeak(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid + 1);

            if (midVal > nextVal) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean isAsc) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (isAsc) {
                if (target > midVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < midVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}