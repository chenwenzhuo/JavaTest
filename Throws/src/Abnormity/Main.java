
package Abnormity;

public class Main {
    static void throwOne() throws IllegalAccessError{
        System.out.println("Inside throwOne.");
        throw new IllegalAccessError("demo");
    }
    public static void main(String[] args) {
        try{
            throwOne();
        }catch (IllegalAccessError e){
            System.out.println("Caught "+e);
        }
    }
}





