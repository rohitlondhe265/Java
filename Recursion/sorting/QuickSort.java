package sorting;

public class QuickSort {

// using the recursion [pivot and partition approach]
// time complexity of quick sort in worst case is O(n^2) and in average case is O(n*long(n))
// worst case occurs when the pivot is always smallest or largest element i.e. array is sorted ascending or descending

public static int partition(int arr[], int startidx, int endidx){
    int pivot = arr[endidx];
    int i = startidx-1; // elements less than pivot
    for(int j=startidx; j<endidx; j++){
        if(arr[j]<pivot){
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    i++;
    int temp = arr[i];
    arr[i] = arr[endidx];
    arr[endidx] = temp;
    return i;
}
public static void quickSort(int arr[], int startidx, int endidx){
    if(startidx < endidx){
        int pivotInx = partition(arr, startidx, endidx);
        quickSort(arr, startidx, pivotInx-1);
        quickSort(arr, pivotInx+1, endidx);
    }
}
public static void main(String[] args) {
    int arr[] = {5,54,4,9,-48,51};
    int n = arr.length;
    quickSort(arr, 0, n-1);
    for(int i : arr){
        System.out.println(i);
    }
}
}
