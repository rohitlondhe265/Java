import java.util.Arrays;
import java.util.Scanner;

public class medium {
    // Game Of Two Stacks [Hacker Rank]
    // Given Two Stacks a , b and a maxSum. We can remove on number from stack at one step. What is maximum number of steps we can get such that the total Sum of Numbers Removed from stack does not exceed the given maxSum.
    public static int maxSumRemove(int[] a, int[] b, int maxSum) {
        return maxSumRemove(a, b, maxSum, 0, 0) - 1;
    }
    public static int maxSumRemove(int[] a, int[] b, int maxSum, int currSum, int steps) {
        if (currSum > maxSum) {
            return steps;
        }
        if (a.length == 0 || b.length == 0) {
            return steps;
        }
       int ans1 = maxSumRemove(Arrays.copyOfRange(a, 1, a.length), b, maxSum, currSum + a[0], steps + 1);
       int ans2 = maxSumRemove(a, Arrays.copyOfRange(b, 1, b.length), maxSum, currSum + b[0], steps + 1);
       return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int maxSum = s.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int j = 0; j < n; j++) {
                a[j] = s.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = s.nextInt();
            }
            System.out.println(maxSumRemove(a, b, maxSum));
        }
        // sample input
        // 1
        // 5 4 10
        // 4 2 4 6 1
        // 2 1 8 5
    }
}
