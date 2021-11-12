package frame;

import java.awt.*;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author EdgarCarrero
 */
 //Agregamos las fotos de los corazones para que se vean las vidas//
public class Vidas {

    JLabel vida1 = new JLabel();
    JLabel vida2 = new JLabel();
    JLabel vida3 = new JLabel();
    public static int ALTO = 40, ANCHO = 40;
    Point p, p2, p3;

    //Constructor por defecto//
    public Vidas() {
        this.p = new Point(82, 0);
        this.p2 = new Point(41, 0);
        this.p3 = new Point(0, 0);
        setTamaño();
        paint1();
        paint2();
        paint3();
    }

    //Tamaño de los corazones y posicion de cada uno pa el panel//
    private void setTamaño() {
        vida1.setSize(ANCHO, ALTO);
        vida1.setLocation(p);
        vida2.setSize(ANCHO, ALTO);
        vida2.setLocation(p2);
        vida3.setSize(ANCHO, ALTO);
        vida3.setLocation(p3);
    }

    //Agregamos una imagen//
    private void paint1() {

        URL url = getClass().getResource("object/corazon.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(vida1.getWidth(), vida1.getHeight(), Image.SCALE_DEFAULT));
        vida1.setIcon(icon);
        vida1.repaint();

    }

    //Agregamos una imagen//
    private void paint2() {
        URL url = getClass().getResource("object/corazon.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(vida2.getWidth(), vida2.getHeight(), Image.SCALE_DEFAULT));
        vida2.setIcon(icon);
        vida2.repaint();
    }

    //Agregamos una imagen//
    private void paint3() {
        URL url = getClass().getResource("object/corazon.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(vida3.getWidth(), vida3.getHeight(), Image.SCALE_DEFAULT));
        vida3.setIcon(icon);
        vida3.repaint();
    }

}
