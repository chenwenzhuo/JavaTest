package stackTrace;

import java.util.*;
public class StackTraceTest {
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable throwable = new Throwable();
        StackTraceElement[] frames = throwable.getStackTrace();
        for (StackTraceElement frame : frames) {
            System.out.println(frame);
        }

        int r;
        if (n <= 1) {
            r = 1;
        }
        else{
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = in.nextInt();
        factorial(num);
    }
}
