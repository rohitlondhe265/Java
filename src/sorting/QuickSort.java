package sorting;

import java.util.Arrays;

public class QuickSort {

public static void sort(int[] arr, int low, int high) {
    if (low >= high) {
        return;
    }
    int s = low;
    int e = high;
    int m = s+(e-s)/2;
    int pivot = arr[m];
    
    // iterate over the array using start and end
    while (s <= e) {
        // while the our check is not violeted keep moving forward and backword
        while (pivot < arr[e]) {
            e--;
        }
        while (pivot > arr[s]) {
            s++;
        }
        // swap start and end elements
        if (s <= e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    // now pivot is at it's correct postion sort the two halves aroun the pivot
    sort(arr, low, e);
    sort(arr, s, high);
}

// using the recursion [pivot and partition approach]
// time complexity of quick sort in worst case is O(n^2) and in average case is O(n*long(n))
// worst case occurs when the pivot is always smallest or largest element i.e. array is sorted ascending or descending
public static void quickSort(int arr[], int startIdx, int endIdx){
    if(startIdx < endIdx){
        int pivotInx = partition(arr, startIdx, endIdx);
        quickSort(arr, startIdx, pivotInx-1);
        quickSort(arr, pivotInx+1, endIdx);
    }
}
public static int partition(int arr[], int startIdx, int endIdx){
    int pivot = arr[endIdx];
    int i = startIdx-1; // elements less than pivot
    for(int j=startIdx; j<endIdx; j++){
        if(arr[j]<pivot){
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    i++;
    int temp = arr[i];
    arr[i] = arr[endIdx];
    arr[endIdx] = temp;
    return i;
}

public static void main(String[] args) {
    int arr[] = {5,54,4,9,-48,51};
    int n = arr.length;

    // // Java internal sorting
    // Arrays.sort(arr);

    // quickSort(arr, 0, n-1);
    // for(int i : arr){
    //     System.out.println(i);
    // }

    sort(arr, 0, n-1);
    System.out.println(Arrays.toString(arr));
}
}
