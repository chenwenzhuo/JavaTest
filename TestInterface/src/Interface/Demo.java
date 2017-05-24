package Interface;
import java.util.Random;
interface ShareConstants{
    int no=0;   int yes=1;  int maybe=2;
    int later=3;  int soon=4; int never=5;
}
class Question implements ShareConstants{
    Random rand=new Random();
    int ask(){
        int prob=(int)(100*rand.nextDouble());
        if(prob<30) return no;
        else if(prob<60) return yes;
        else if(prob<75) return maybe;
        else if(prob<98) return later;
        else if(prob<100) return soon;
        else return never;
    }
}
class Demo implements ShareConstants{
    static void answer(int result){
        switch(result){
            case no:System.out.println("NO.");break;
            case yes:System.out.println("YES.");break;
            case maybe:System.out.println("MAYBE.");break;
            case later:System.out.println("LATER.");break;
            case soon:System.out.println("SOON.");break;
            case never:System.out.println("NEVER.");break;
        }
    }
    public static void main(String args[]){
        Question q=new Question();
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
    }
}

