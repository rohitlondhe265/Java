package Recursion;

public class Basic_Questions {

    // sum of first n natural numbers
    public static void helper(int i, int n, int sum) {
        if (i == n) {
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        helper(i + 1, n, sum);
        System.out.println(i); // just to understand flow of recursion
    }

    public static void sum(int n) {
        helper(1, n, 0);
    }

    // print factorial
    public static void factorial(int n, int ans) {
        if (n == 1) {
            System.out.println(ans);
            return;
        }
        ans *= n;
        factorial(n - 1, ans);
    }

    // second way of doing this
    public static int factorial2(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int factorial_n_minus_1 = factorial2(n - 1);
        int factorial = n * factorial_n_minus_1;
        return factorial;
    }

    // fibonacci series till nth term e.g. 0,1,1,2,3,5,8,13
    // using iteration
    public static void fibonacci(int n) {
        int a = 0;
        int b = 1;
        System.out.println(a + " " + b);
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }
    }

    // using recursion a is secondlast and b is lasterm
    public static void fibonacci2(int n, int a, int b) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        fibonacci2(n - 1, b, c);
    }

    // print X^n
    // recursion call stack height = n
    public static int calPower(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int xpower_nm1 = calPower(x, n - 1);
        int xpower = x * xpower_nm1;
        return xpower;
    }

    // recursion call stack height = log(n) {memory optimization}
    // in dynamic programming we use Memoization for recursion and Tabulation for
    // iteration methods to optimize the program.
    public static int calPower2(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        // if the power is even
        if (n % 2 == 0) {
            return calPower2(x, n / 2) * calPower2(x, n / 2);
        }
        // if power is odd
        else {
            return calPower2(x, n / 2) * calPower2(x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        // sum(5);
        // factorial(5, 1);
        // System.out.println(factorial2(5));

        // fibonacci(8);
        // System.out.println(0 + " " + 1);
        // fibonacci2(8-2, 0, 1);

        System.out.println(calPower2(2, 18));
    }
}
