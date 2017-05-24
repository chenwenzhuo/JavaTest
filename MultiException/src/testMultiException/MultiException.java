
package testMultiException;
public class MultiException {
    public static void main(String[] args) {
        int a=10,b=0;
        int vals[]={1,2,3};

        try{
            int result=a/b;
            vals[5]=5;
        }catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("Exception caught:"+e);
        }
        System.out.println("After MultiCatch.");
    }
}



