import javax.swing.*;
import java.awt.*;


public class Main {
    public  static  Painter painter = new Painter();
    public static void main(String[] args)
    {

        painter.setLayout(null);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Chess");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Get the size of the window (frame)
        window.setSize(1800,1000);
        Dimension windowSize = window.getSize();


        int x = (screenSize.width - windowSize.width) / 2;
        int y = (screenSize.height - windowSize.height) / 2;
        window.setLocation(x,y);





        Automaton world = new Automaton();
        world.init();
        window.add(painter);
        Gui gui = new Gui();
        gui.addButtons();
        MouseHandler mouseHandler = new MouseHandler();
        painter.addMouseListener(mouseHandler);
        painter.addMouseMotionListener(mouseHandler);


        window.setVisible(true);

        for (int i  =0; i < 365; i ++){
            try {
                Thread.sleep(gui.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(Gui.stop){
                i-= 1;
            } else {
                world.rules();
            }
            painter.repaint();

        }

    }
}