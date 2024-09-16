import java.util.Scanner;

public class my_class {
    public static void main(String args[]) {

        // Define new scanner
        Scanner sc = new Scanner(System.in);
        // Tell the user what he should type
        System.out.println("Enter the name of your student");
        // Get input from the user
        String name = sc.nextLine();
        // Print out something useful
        System.out.println("Your student is called "+name);

    }
}
