package frame;

import static frame.User.ALTO;
import static frame.User.ANCHO;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author EdgarCarrero
 */
public class Wall {
    JLabel wall = new JLabel();
    Rectangle area;
    
    Wall(int x,int y,int width, int height) {
        setTamaño(x,y,width, height);
        area = new Rectangle(x, y, width, height);
        setPosicion(x,y);
        paint();
    }
    
    private void setTamaño(int x,int y,int width, int height) {
        wall.setSize(width, height);
        wall.setLocation(x,y);
    }

    private void paint() {
        URL url = getClass().getResource("object/cuadrado.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(wall.getWidth(), wall.getHeight(), Image.SCALE_DEFAULT));
        wall.setIcon(icon);
        wall.repaint();
    }

    public void setPosicion(int x, int y) {
        wall.setLocation(x, y);
        area.setBounds(x, y, (int) area.getWidth(), (int) area.getHeight());
    }

    public int posX() {
        return wall.getX();
    }

    public int posY() {
        return wall.getY();
    }
    
}
