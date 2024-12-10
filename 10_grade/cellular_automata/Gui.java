import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    public static Element element = new Element(0);
    public int sleepTime = 1000;
    private JButton sea;
    private JButton land;
    private JButton iceberg;
    private JButton forest;
    private JButton city;
    private JButton incPollution;
    private JButton setCloudy;
    private JButton incTemp;
    private JButton incHeight;
    private JButton windDirection;
    private JButton incSpeed;
    private JButton pause;
    private JButton decSpeed;
    public static boolean stop = true;
    /*
   0 = sea
   1 = land
   2 = iceberg
   3 = forest
   4 = city
   * */
    public void addButtons(){
        sea = new JButton("sea");
        sea.setBounds(1200,300,100,40);
        sea.addActionListener(this);
        Main.painter.add(sea);
        land = new JButton("land");
        land.setBounds(1200,340,100,40);
        land.addActionListener(this);
        Main.painter.add(land);
         iceberg = new JButton("iceberg");
        iceberg.setBounds(1200,380,100,40);
        iceberg.addActionListener(this);
        Main.painter.add(iceberg);
         forest = new JButton("forest");
        forest.setBounds(1200,420,100,40);
        forest.addActionListener(this);
        Main.painter.add(forest);
        city = new JButton("city");
        city.setBounds(1200,460,100,40);
        city.addActionListener(this);
        Main.painter.add(city);
        incPollution = new JButton("incPollution");
        incPollution.setBounds(1300,300,100,40);
        incPollution.addActionListener(this);
        Main.painter.add(incPollution);
        setCloudy = new JButton("set cloudy");
        setCloudy.setBounds(1300,340,100,40);
        setCloudy.addActionListener(this);
        Main.painter.add(setCloudy);
        incTemp = new JButton("incTemper");
        incTemp.setBounds(1300,380,100,40);
        incTemp.addActionListener(this);
        Main.painter.add(incTemp);
        incHeight = new JButton("incHeight");
        incHeight.setBounds(1300,420,100,40);
        incHeight.addActionListener(this);
        Main.painter.add(incHeight);
        windDirection = new JButton("windDirection");
        windDirection.setBounds(1300,460,100,40);
        windDirection.addActionListener(this);
        Main.painter.add(windDirection);
        incSpeed = new JButton("incSpeed");
        incSpeed.setBounds(1400,300,100,40);
        incSpeed.addActionListener(this);
        Main.painter.add(incSpeed);
        decSpeed = new JButton("decSpeed");
        decSpeed.setBounds(1400,340,100,40);
        decSpeed.addActionListener(this);
        Main.painter.add(decSpeed);
        pause = new JButton("pause/play");
        pause.setBounds(1500,340,100,40);
        pause.addActionListener(this);
        Main.painter.add(pause);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sea) {
            element = new Element(0);
        } else if (e.getSource() == land) {
            element = new Element(1);
        } else if (e.getSource() == iceberg) {
            element = new Element(2);
        } else if (e.getSource() == forest) {
            element = new Element(3);
        } else if (e.getSource() == city) {
            element = new Element(4);
        } else if(e.getSource() == incPollution && element.pollution < 5){
            element.pollution += 1;
        } else if(e.getSource() == setCloudy){
        element.cloudy = true;
        } else if(e.getSource() == incTemp && element.temper < 50){
            element.temper += 10;
        }else if(e.getSource() == incHeight && element.height < 60){
            element.height += 10;
        } else if(e.getSource() == windDirection){
            MouseHandler.wind += 1;
            if (MouseHandler.wind == 5) {
                MouseHandler.wind = 0;
            }
        } else if(e.getSource() == incSpeed && sleepTime > 0){
            sleepTime -= 50;
        }
        else if(e.getSource() == decSpeed){
            sleepTime += 50;
        }else if(e.getSource() == pause){
            stop = !stop;
        }
        if(e.getSource() != windDirection){
            MouseHandler.wind = 0;
        }
        Main.painter.repaint();
    }
}
