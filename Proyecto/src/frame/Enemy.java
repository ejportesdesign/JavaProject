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
public class Enemy {

    JLabel enemy = new JLabel();
    //Coloco a mi personaje en una posicion dada//
    Point posicion = new Point(380, 170);
    boolean controlEnemy = true;
    private final int pos = 1;
    public static int ALTO = 40, ANCHO = 40;
    Rectangle areaEnemy;

    Enemy(int x, int y) {
        setTamaño(x, y);
        areaEnemy = new Rectangle(x, y, ANCHO, ALTO);
        paint();
    }

    private void setTamaño(int x, int y) {
        enemy.setSize(ALTO, ANCHO);
        enemy.setLocation(x, y);
    }

    private void paint() {
        URL url = getClass().getResource("object/Enemigo.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(enemy.getWidth(), enemy.getHeight(), Image.SCALE_DEFAULT));
        enemy.setIcon(icon);
        enemy.repaint();
    }

    public void setPosicion(int x, int y) {
        enemy.setLocation(x, y);
        areaEnemy.setBounds(x, y, (int) areaEnemy.getWidth(), (int) areaEnemy.getHeight());
    }

    public int posX() {
        return enemy.getX();
    }

    public int posY() {
        return enemy.getY();
    }

    public void setControlEnemy() {
        controlEnemy = !controlEnemy;
    }
    
    public boolean controlEnemy(){
        return controlEnemy;
    }

}
