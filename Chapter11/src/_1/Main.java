package _1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            int a = 3;
            int b = 0;
            System.out.println(a / b);
        } catch (Exception e) {
            System.out.println("Divided by zero.");
        }
        finally {
            System.out.println("In finally statement.");
        }
    }
}
