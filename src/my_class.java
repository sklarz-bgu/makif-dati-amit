import java.util.Scanner;

public class my_class {

    /*
    public static boolean is_letter_or_fail(char ch) {
        return(true);
    }
    */
    public static float P;
    public static boolean foo() {
        System.out.println(">>> "+P);
        return true;
    }
    public static void main(String args[]) {

        int dist = 10;
        P = 1/(float)dist;
        foo();
        //System.out.println(P);
    }
}
