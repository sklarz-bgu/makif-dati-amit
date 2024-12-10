import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseHandler extends MouseAdapter implements MouseMotionListener {

    public static int wind = 0;
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if(e.getX() < Painter.size * Automaton.width && e.getY() < Painter.size * Automaton.height && e.getX() >=0 &&e.getY() >= 0) {
        if(wind == 0){
            Automaton.left[e.getY() / Painter.size][e.getX() / Painter.size] = new Element(Gui.element);
        } else {
            Automaton.left[e.getY() / Painter.size][e.getX() / Painter.size].windy = wind;
        }
        Main.painter.repaint();
    }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getX() < Painter.size * Automaton.width && e.getY() < Painter.size * Automaton.height && e.getX() >=0 &&e.getY() >= 0){
            if(wind == 0){
                Automaton.left[e.getY() / Painter.size][e.getX() / Painter.size] = new Element(Gui.element);
            } else {
                Automaton.left[e.getY() / Painter.size][e.getX() / Painter.size].windy = wind;
            }
        }
        super.mouseDragged(e);
        Main.painter.repaint();

    }
}
