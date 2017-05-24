
package testFinally;

public class Main {
    static void procA(){
        try{
            System.out.println("inside procA.");
            throw new RuntimeException("demo");
        }finally {
            System.out.println("proA's finally.");
        }
    }
    static void procB(){
        try{
            System.out.println("inside procB.");
            return;
        }finally {
            System.out.println("proB's finally.");
        }
    }
    static void procC(){
        try{
            System.out.println("inside procC.");
        }finally {
            System.out.println("proC's finally.");
        }
    }
    public static void main(String[] args) {
	// write your code here
        try{
            procA();
        }catch (Exception e){
            System.out.println("Exception caught.");
        }
        procB();
        procC();
    }
}
