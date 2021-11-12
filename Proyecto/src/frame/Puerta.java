package frame;

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
public class Puerta {
    JLabel door = new JLabel();
    //Coloco a mi personaje en una posicion dada//
    Point posicion = new Point(380, 170);
    private final int pos = 1;
    public static int ALTO = 40, ANCHO = 40;
    Rectangle areaEnemy;

    Puerta(int x, int y) {
        setTamaño(x, y);
        areaEnemy = new Rectangle(x,y, ANCHO, ALTO);
        paint();
    }

    private void setTamaño(int x, int y) {
        door.setSize(ALTO, ANCHO);
        door.setLocation(x,y);
    }

    private void paint() {
        URL url = getClass().getResource("object/Door.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(door.getWidth(), door.getHeight(), Image.SCALE_DEFAULT));
        door.setIcon(icon);
        door.repaint();
    }

    public void setPosicion(int x, int y) {
        door.setLocation(x, y);
        areaEnemy.setBounds(x, y, (int) areaEnemy.getWidth(), (int) areaEnemy.getHeight());
    }

    public int posX() {
        return door.getX();
    }

    public int posY() {
        return door.getY();
    }

}
