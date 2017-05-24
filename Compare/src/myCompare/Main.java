package myCompare;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        primeNumber();
    }
    static void primeNumber(){
        System.out.print("输入一个上限:");
        Scanner input = new Scanner(System.in);
        double upperLimit = input.nextDouble();

        for (double i = 2; i <= upperLimit; ++i) {
            System.out.println(i / 2 + "      " + Math.sqrt(i));
        }
    }
}
