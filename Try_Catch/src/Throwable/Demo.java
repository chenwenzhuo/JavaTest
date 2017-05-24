package Throwable;

public class Demo {
	public static void main(String args[]){
        try {
            int a,b;
            a=0;
            b=3/a;
        }
        catch (ArithmeticException e){
            System.out.println("This will never be reached."+e);
        }
        catch (Exception e){
            System.out.println("Division by zero."+e);
        }

        System.out.println("After try/catch.");
        int len=args.length;
        for(int i=0;i<len;++i)
        	System.out.print(args[i]+"  ");
    }
}
