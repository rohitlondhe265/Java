package sorting;

import java.util.Arrays;

public class CycleSort {
    // Check Swap Move
    public static void Swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            // correct index for current element we are at
            int correctIndex = arr[i] - 1;
            // Move element to it's correct postion if it is not there
            if (arr[i] != arr[correctIndex]) {
                Swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    
    public static void main(String[] args) {
        int[] arr = {6,3,4,1,2,5};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
