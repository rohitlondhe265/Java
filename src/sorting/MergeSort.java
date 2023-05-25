package sorting;

public class MergeSort {
    // divide and conquere technique
    // time complexity of merge sort is O[n*log(n)]
    // conquere time complexity O[n]
    // divide time complexity O[log(n)]
    public static void divide(int arr[], int startidx, int endidx) {
        if (startidx >= endidx) {
            return;
        }
        int mididx = startidx + (endidx - startidx) / 2;
        divide(arr, startidx, mididx);
        divide(arr, mididx + 1, endidx);
        conquere(arr, startidx, mididx, endidx);
    }
    public static void conquere(int arr[], int startidx, int mididx, int endidx) {
        int mergedArr[] = new int[endidx - startidx + 1];
        int idx1 = startidx;
        int idx2 = mididx + 1;
        int x = 0;
        while (idx1 <= mididx && idx2 <= endidx) {
            if (arr[idx1] <= arr[idx2]) {
                mergedArr[x] = arr[idx1];
                x++;
                idx1++;
                // alternate to above two statements we can also write mergedArr[x++] =
                // arr[idx2++];
            } else {
                mergedArr[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mididx) {
            mergedArr[x++] = arr[idx1++];
        }
        while (idx2 <= endidx) {
            mergedArr[x++] = arr[idx2++];
        }

        for (int i = 0, j = startidx; i < mergedArr.length; i++, j++) {
            arr[j] = mergedArr[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 54, 4, 9, -48, 51 };
        int n = arr.length;
        divide(arr, 0, n - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
