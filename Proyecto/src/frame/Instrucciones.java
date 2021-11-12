package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author EdgarCarrero
 */

//Clase encargada de mostrar las instrucciones// 
class Instrucciones {

    JPanel panel;
    JLabel inst;
    //JFrame fr;//
    index fr;
    JButton regresar;
    Inicio vn;

    public Instrucciones() {
        //fr = new JFrame();//

    }

    Instrucciones(index frame) {
        this.fr = frame;
        componentes();
        ventana();
        panel.setVisible(true);
        fr.frame.add(panel);

    }

    private void componentes() {
        panel = new JPanel();
        GroupLayout grupo = new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBackground(new Color(193, 205, 193));
        panel.setBounds(0, 0, 1000, 600);
        //Se agrega el boton para poder regresar a la pantalla de inicio//
        panel.setLayout(null);
        regresar = new JButton("Regresar");
        //Se le da las dimensiones como las coordenadas del boton//
        regresar.setBounds(10, 50, 200, 50);
        panel.add(regresar);
        
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           panel.setVisible(false);
            fr.frame.remove(panel);
           vn = new Inicio(fr);
            }
        });

    }

    private void ventana() {
        //las instrucciones son una imagen//
        inst = new JLabel();
        //se coloca que ocupe todo el frame//
        inst.setBounds(0, 0, 1000, 600);
        URL url = getClass().getResource("object/Instrucciones.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(inst.getWidth(), inst.getHeight(), inst.getHeight()));
        inst.setIcon(icon);
        inst.repaint();
        panel.add(inst);
    }


    
}
