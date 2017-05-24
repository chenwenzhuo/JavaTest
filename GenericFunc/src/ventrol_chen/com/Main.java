package ventrol_chen.com;

public class Main {

    public static void main(String[] args) {
        Generic generic = new Generic();
        String result = generic.getMiddle("good", "god", "zero", "a", "there");
        System.out.println(result);
    }
}
