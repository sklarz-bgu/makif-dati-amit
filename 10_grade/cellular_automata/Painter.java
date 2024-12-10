import javax.swing.*;
import java.awt.*;

public class Painter extends JPanel {
    static Element element;
    public static Color[] colors = {Color.BLUE, Color.decode("#A7C957"),
            Color.decode("#90E0EF"),Color.decode("#386641"),Color.decode("#6C757D")};

    public static int size = 20;
    public static int xOffset = 900;
    public static int yOffset = 750;


    public static void drawWorld(Graphics g) {
        for (int i = 0; i < Automaton.height; i++) {
            for (int j = 0; j < Automaton.width; j++) {
                g.setColor(colors[(element = Automaton.left[i][j]).type]);
                g.fillRect(j * size, i * size, size, size);
                if(element.cloudy){
                    g.setColor(Color.decode("#f6f6f6"));
                    g.fillRect(j * size, i * size , size , size );
                }
                if(element.raining){
                    g.setColor(Color.BLUE);
                    g.fillRect(j * size, i * size , size / 10 , size / 10 );
                    g.fillRect(j * size + size / 2, i * size  , size / 10 , size / 10 );
                    g.fillRect(j * size + size / 4, i * size + size / 4 , size / 10 , size / 10 );
                    g.fillRect(j * size + 3 * size /4, i * size + size / 4 , size / 10 , size / 10 );
                    g.fillRect(j * size, i * size + size / 2 , size / 10 , size / 10 );
                    g.fillRect(j * size + size / 2, i * size + size / 2 , size / 10 , size / 10 );
                    g.fillRect(j * size + size /4, i * size + size * 3 / 4 , size / 10 , size / 10 );
                    g.fillRect(j * size + size * 3 / 4, i * size + size * 3 / 4 , size / 10 , size / 10 );
                }
                if(element.pollution > 0 ){
                    g.setColor(Color.decode("#40FD14"));
                    g.fillRect(j * size, i * size , element.pollution *size / 10 , element.pollution * size / 10);
                }
                if(element.temper > 30) {
                    g.setColor(Color.decode("#CF0107"));
                    g.fillRect(j * size+ size / 2, i * size  , element.temper *size / 150 , size );
                }
            }
        }
    }
    /*
  0 = sea
  1 = land
  2 = iceberg
  3 = forest
  4 = city
  * */
    public static void paintWind(Graphics g){
        String s = "none";//windDirection 1 south 2 west 3 east 4 north
        switch (MouseHandler.wind){
            case 1:
                s = "south";
                break;
            case 2:
                s = "west";
                break;
            case 3:
                s = "east";
                break;
            case 4:
                s = "north";
                break;
        }
        g.setColor(Color.black);
        g.drawString("wind directon " + s, 1200, 200 );
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Painter.drawWorld(g);
        Painter.paintWind(g);
        paintGraph(g);
        printStats(g);
    }

    private void paintGraph(Graphics g){

        g.drawLine(900, 550, 900, 900);
        g.drawLine(900,900, 1700,900);
        Automaton.graphDaysX[0] = xOffset;
        Automaton.graphTemps[0] = yOffset;
        Automaton.graphPols[0] = yOffset;
        Automaton.graphWinds[0] = yOffset;
        g.setColor(Color.decode("#CF0107"));
        g.drawString("temperature", 830, 700);
        g.drawPolyline(Automaton.graphDaysX,Automaton.graphTemps, Automaton.numOfDays);

        g.setColor(Color.decode("#40FD14"));
        g.drawString("pollution", 830, 720);
        g.drawPolyline(Automaton.graphDaysX,Automaton.graphPols, Automaton.numOfDays);

        g.setColor(Color.blue);
        g.drawString("wind", 830, 740);
        g.drawPolyline(Automaton.graphDaysX,Automaton.graphWinds, Automaton.numOfDays);
    }

    private void printStats(Graphics g){
        g.setColor(Color.black);
        g.drawString("temperature: ", 900, 50);
        g.drawString("average temp today: " + Automaton.dailyTemp, 900, 65);
        g.drawString("average temp yearly: " + Automaton.avgYearlyTemp, 900, 80);
        g.drawString("standard deviation: " + Automaton.tempStdDev , 900, 95 );
        g.drawString("minimum temp so far: " + Automaton.minDailyTemp, 900, 110);
        g.drawString("maximum temp so far: " + Automaton.maxDailyTemp, 900, 125);


        g.drawString("pollution: ", 1300, 50);
        g.drawString("average pollution today: " + Automaton.dailyPollution, 1300, 65);
        g.drawString("average pollution yearly: " + Automaton.avgYearlyPol, 1300, 80);
        g.drawString("standard deviation: " + Automaton.polStdDev , 1300, 95 );
        g.drawString("minimum pollution so far: " + Automaton.minDailyPol, 1300, 110);
        g.drawString("maximum pollution so far: " + Automaton.maxDailyPol, 1300, 125);

        g.drawString("wind: ", 900, 400);
        g.drawString("average wind today: " + Automaton.dailyWind, 900, 415);
        g.drawString("average wind yearly: " + Automaton.avgYearlyWind, 900, 430);
        g.drawString("standard deviation: " + Automaton.windStdDev , 900, 445 );

        g.drawString("day count: " + Automaton.numOfDays, 900, 300);



    }

}
