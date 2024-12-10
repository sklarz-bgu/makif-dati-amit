import java.awt.*;

public class Element {
    public static int numOfTypes = 5;
    public int type = 1;
    public int height = 0; //from 0 to 60, represents 1 hundred meters.
    public int temper = 20; // natural number between 0 and 50;
    public int pollution = 0; // 0 to 5
    public boolean cloudy = false;
    public int windy =  0; //windDirection 1 south 2 west 3 east 4 north
    public boolean raining = false;
    /*
    0 = sea
    1 = land
    2 = iceberg
    3 = forest
    4 = city
    * */
    public Element(int type){
        this.type = type;
    }
    public Element(Element other) {
        this.type = other.type;
        this.height = other.height;
        this.temper = other.temper;
        this.pollution = other.pollution;
        this.cloudy = other.cloudy;
        this.windy = other.windy;
        this.raining = other.raining;
    }

}
