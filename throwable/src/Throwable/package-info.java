/**
 * Created by Chenw on 2016/2/21 0021.
 */
package Throwable;
class Main{
    static void demoproc(){
        try{
            throw new NullPointerException("demo");
        }catch(NullPointerException e){
            System.out.println("Caught inside demoproc.   "+e);
            throw e;
            //System.out.println("This is unreachable.");
        }
    }
    public static void main(String args[]){
        try{
            demoproc();
        }catch(NullPointerException e){
            System.out.println("Recaught.   "+e);
            System.out.println(e.getMessage());
        }
    }
}










