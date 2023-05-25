package BinarySearch;

public class FindInMountainArray {

    public int findInMountainArray(int target, int[] mountainArr) {
        // Find the Peek element
        int peak = findPeak(mountainArr);
        // search in left part of Peek element (0 to peek)
        int find = orderAgnostic(mountainArr, target, 0, peak);
        if(find!=-1){
            return find;
        }
        // if not found in left then search in right part of Peek element (peek + 1 to end of the array)
        return orderAgnostic(mountainArr, target, peak+1, mountainArr.length-1);
    }

   static int findPeak(int[] mountainArr) {
        int start=0;
        int end=mountainArr.length-1;
        while(start < end) { 
            int mid = start + (end - start) / 2;
           if(mountainArr[mid] > mountainArr[mid + 1]) {
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        return start;
   }

  static int orderAgnostic(int[] mountainArr, int target, int start, int end) {
        boolean asc = mountainArr[start] < mountainArr[end];
    while(start <= end) {
        int mid = start + (end - start) / 2;
        if(mountainArr[mid]==target) {
            return mid;
        }
        if(asc) {
            if(mountainArr[mid]>target) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        else {
            if(mountainArr[mid]<target){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
    }
        return -1;
    }
}
