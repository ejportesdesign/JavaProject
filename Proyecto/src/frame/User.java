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
public class User {
    JLabel personaje = new JLabel();
    //Coloco a mi personaje en una posicion dada//
    Point posicion = new Point(400, 450);
    private final int pos = 1;
    public static int ALTO = 50, ANCHO = 50;
    Rectangle area;

    User(int x, int y) {
        setTamaño(x, y);
        area = new Rectangle(400,450, x, y);
        paint();
    }

    private void setTamaño(int x, int y) {
        personaje.setSize(ALTO, ANCHO);
        personaje.setLocation(posicion);
    }

    private void paint() {
        URL url = getClass().getResource("object/user.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(personaje.getWidth(), personaje.getHeight(), Image.SCALE_DEFAULT));
        personaje.setIcon(icon);
        personaje.repaint();
    }

    public void setPosicion(int x, int y) {
        personaje.setLocation(x, y);
        area.setBounds(x, y, (int) area.getWidth(), (int) area.getHeight());
    }

    public int posX() {
        return personaje.getX();
    }

    public int posY() {
        return personaje.getY();
    }

}
