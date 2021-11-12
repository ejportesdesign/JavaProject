package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author EdgarCarrero
 */
public class Inicio {

    index fr;
    JLabel fondo;
    JPanel panel;
    Instrucciones in;
    JButton ins, star, score, cred, salir, top;
    JTextField f1;
    Game gm;

    public Inicio(index frame) {
        this.fr = frame;
        componentes();
        frame.frame.add(panel);
        fondo();

    }

    private void componentes() {
        panel = new JPanel();
        GroupLayout grupo = new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBackground(new Color(193, 205, 193));
        panel.setBounds(0, 0, 1000, 600);
        //Agrego los botones//
        panel.setLayout(null);

        star = new JButton("JUGAR");
        Font str = new Font("arial", 22, 32);
        star.setFont(str);
        star.setBounds(50, 120, 200, 50);
        
        ins = new JButton("Instrucciones");
         Font x = new Font("arial", 12, 26);
        ins.setFont(x);
        ins.setBounds(50, 180, 200, 50);
        
        salir = new JButton("Salir");
        Font c2 = new Font("arial", 22, 32);
        salir.setFont(c2);
        salir.setBounds(50, 360, 200, 50);

        panel.add(star);
        panel.add(ins);
        panel.add(salir);

        star.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panel.setVisible(false);
                    fr.frame.remove(panel);
                    //Constructor de la clase instrucciones//
                    //mando por parametros el fr//
                    fr.game = new Game(fr.frame);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        ins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                //Constructor de la clase instrucciones// 
                //mando por parametros el fr//
               in = new Instrucciones(fr);
             
            
            }


        });
        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
    }
    
     private void fondo() {
        fondo = new JLabel();
        fondo.setBounds(0, 0, 1000, 600);
        URL url = getClass().getResource("object/fondo.jpg");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), fondo.getHeight()));
        fondo.setIcon(icon);
        fondo.repaint();
        panel.add(fondo);

    }

}
