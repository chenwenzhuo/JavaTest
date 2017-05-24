package stackTrace;

import java.util.Scanner;

public class StackTraceTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        factorial(num);
    }

    private static int factorial(int n) {
        System.out.println("Factorial of " + n + ":");
        Throwable throwable = new Throwable();
        StackTraceElement[] frame = throwable.getStackTrace();
        for (StackTraceElement s : frame) {
            System.out.println(s);
        }
        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }
}
