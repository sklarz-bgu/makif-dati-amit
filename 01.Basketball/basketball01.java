
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
        name = "Kevin";
        group = "Jays";
        age = 15;
        number = 7;
        height = 1.95;
        weight = 95;

        // Setting the jump parameters
        jump = true;
        angle = 'a';
        force = 1.45;
        distance = 6.5;

        // Calculate probability of hitting based on distance
        double P = 1/distance;
        // Correct probability for angle
        if(angle == 'f') {
            P = P * 1;
        } else if(angle == 'a') {
            P = P * 0.8;
        } else if(angle == 's') {
            P = P * 0.6;
        } else {
            System.out.println("Invalid angle");
        }

        // Correct probability for jumping vs. standing
        if(jump) {
            P = P * 1.3;
        }
        // Calculate a random number between 0 and 1
        double rand = Math.random();
        // Check if the shot was good from P and the random number
        if(P > rand) {
            System.out.println("Great shot! (" + P + ":" + rand+")");
        } else {
            System.out.println("Maybe next time (" + P + ":" + rand+")");
        }
    }
}
