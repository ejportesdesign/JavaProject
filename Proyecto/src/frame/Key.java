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
public class Key {
    JLabel key = new JLabel();
    //Coloco a mi personaje en una posicion dada//
    Point posicion = new Point(380, 170);
    private final int pos = 1;
    private boolean tengoLaLlave=false;
    public static int ALTO = 40, ANCHO = 40;
    Rectangle areaKey;

    Key(int x, int y) {
        setTamaño(x, y);
        areaKey = new Rectangle(x,y, ANCHO, ALTO);
        paint();
    }

    private void setTamaño(int x, int y) {
        key.setSize(ALTO, ANCHO);
        key.setLocation(x,y);
    }

    private void paint() {
        URL url = getClass().getResource("object/Key.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(key.getWidth(), key.getHeight(), Image.SCALE_DEFAULT));
        key.setIcon(icon);
        key.repaint();
    }

    public void setPosicion(int x, int y) {
        key.setLocation(x, y);
        areaKey.setBounds(x, y, (int) areaKey.getWidth(), (int) areaKey.getHeight());
    }

    public int posX() {
        return key.getX();
    }

    public int posY() {
        return key.getY();
    }
    
    public void llaveObtenida(){
        tengoLaLlave = true;
    }
    
    public boolean getLlave(){
        return tengoLaLlave;
    }

}
