import java.util.Scanner;

public class Fib {
    public static int fib1(int n) {
        if (n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k) {
            return f0;
        } else {
            return fib2(n, k + 1, f1, f0 + f1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fib1(n));
        System.out.println(fib2(n, 0, 0, 1));
    }
}
