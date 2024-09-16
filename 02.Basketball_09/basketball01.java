
public class my_class {
    public static void main(String args[]) {

        // Player parameters
        String name;
        String group;
        int age;
        int number;
        double height;
        double weight;

        // Jump parameters
        boolean jump;
        char angle; // f - front. a - angle. s - side
        double force;
        double distance; // Distance of player from hoop

        // Setting the player parameters
        name = "Kevin"; // מרכאות כפולות למחרוזות
        group = "Jays";
        age = 15;
        number = 7;
        height = 1.95;
        weight = 95;

        // Setting the jump parameters
        jump = true;
        angle = 'a'; // מרכאות יחידות לתוים בודדים
        force = 1.45;
        distance = 6.5;

        System.out.println(name + "is " + height + " meters tall!");

    }
}
