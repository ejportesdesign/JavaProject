package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author EdgarCarrero
 */
public class Game {

    private JFrame fr;
    private Archivo archivo;
    private User user;
    private JPanel panel;
    private Vidas v;
    private Enemy enemy, enemy2, enemy3, enemy4;
    private Key key;
    private Puerta puerta;
    JLabel fondo;
    Level level;
    int vidas = 0;
    private Wall wall1, wall2, wall3, wall4, wall5, wall6;
    private boolean up = true, down = true, left = true, right = true;
    private boolean controlEnemy1 = false;
    private int nivel = 1;
    Timer t;

    Game(JFrame frame) throws IOException {
        this.fr = frame;
        fr.requestFocus();
        archivo = new Archivo("s");
        String [] leer= archivo.leer();
        if(leer!=null){
            int vida=Integer.parseInt(leer[2]);
        int niveles=Integer.parseInt(leer[3]);
        vidas=vida;
        nivel=niveles;
        } 
        
        ventana();
        movimiento();
        addElemets();
        agregarMuros();       
        t = new Timer(5, escuchante);
        t.start();
        fr.add(panel);
    }

    private void addElemets() {
        
        agregarVida();
        agregarPersonaje();
        agregarEnemigos();
        agregarLlave();
        agregarPuerta();
       
        
    }

    private void ventana() {
        panel = new JPanel();
        GroupLayout grupo = new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBounds(0, 0, 1000, 600);
        panel.setBackground(new Color(152, 245, 255));
    }

    private void agregarPersonaje() {
        try {
            archivo = new Archivo("s");
            String [] leer= archivo.leer();
            
            
            user = new User(50, 50);
            if(leer!=null){
            int x=Integer.parseInt(leer[0]);
            int y=Integer.parseInt(leer[1]); 
                user.setPosicion(x, y);
            }
            
            panel.add(user.personaje);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void agregarVida() {
        v = new Vidas();
        if(vidas==0){
            panel.add(v.vida1);
        panel.add(v.vida2);
        panel.add(v.vida3);
        }else if(vidas==1){
            panel.add(v.vida2);
        panel.add(v.vida3);
        }else{
            panel.add(v.vida3);
        }
    }

    private void agregarMuros() {
        level = new Level();
        int[] wallPosition;
        if (nivel == 1) {
            wallPosition = level.wallLevel1();
        } else if(nivel==2){
            wallPosition = level.wallLevel2();
            panel.removeAll();
            panel.updateUI();
            addElemets();
        }else{
            wallPosition = level.wallLevel3();
            panel.removeAll();
            panel.updateUI();
            addElemets();
        }

        Wall barra1 = new Wall(0, -20, 20, 600);
        Wall barra2 = new Wall(0, 0, 1000, 20);
        Wall barra3 = new Wall(970, -20, 20, 600);
        Wall barra4 = new Wall(0, 550, 1000, 20);

        wall1 = new Wall(wallPosition[0], wallPosition[1], wallPosition[2], wallPosition[3]);
        wall2 = new Wall(wallPosition[4], wallPosition[5], wallPosition[6], wallPosition[7]);
        wall3 = new Wall(wallPosition[8], wallPosition[9], wallPosition[10], wallPosition[11]);
        wall4 = new Wall(wallPosition[12], wallPosition[13], wallPosition[14], wallPosition[15]);
        wall5 = new Wall(wallPosition[16], wallPosition[17], wallPosition[18], wallPosition[19]);

        panel.add(barra4.wall);
        panel.add(barra2.wall);
        panel.add(barra3.wall);
        panel.add(barra1.wall);

        panel.add(wall1.wall);
        panel.add(wall2.wall);
        panel.add(wall3.wall);
        panel.add(wall3.wall);
        panel.add(wall3.wall);
        panel.add(wall4.wall);
        panel.add(wall5.wall);
         fondo();

    }

    private void agregarEnemigos() {
        Level l1 = new Level();
        int[] enemyLevel;
        if (nivel == 1) {
            enemyLevel = l1.enemyLevel1();
        } else if(nivel==2){
            enemyLevel = l1.enemyLevel2();
        }
        else {
            enemyLevel = l1.enemyLevel3();
        }

        enemy = new Enemy(enemyLevel[0], enemyLevel[1]);
        enemy2 = new Enemy(enemyLevel[2], enemyLevel[3]);
        enemy3 = new Enemy(enemyLevel[4], enemyLevel[5]);
        enemy4 = new Enemy(enemyLevel[6], enemyLevel[7]);
        panel.add(enemy4.enemy);
        panel.add(enemy2.enemy);
        panel.add(enemy3.enemy);
        panel.add(enemy.enemy);

    }

    private void agregarLlave() {
        Level l1 = new Level();
        int[] enemyLevel;
        if (nivel == 1) {
            enemyLevel = l1.llaveLevel1();
        } else if(nivel==2){
            enemyLevel = l1.llaveLevel2();
        }else {
            enemyLevel = l1.llaveLevel3();
        }
        key = new Key(enemyLevel[0], enemyLevel[1]);
        panel.add(key.key);

    }

    private void agregarPuerta() {
        Level l1 = new Level();
        int[] enemyLevel;
        if (nivel == 1) {
            enemyLevel = l1.PuertaLevel1();
        } else if(nivel==2) {
            enemyLevel = l1.PuertaLevel2();
        }
        else if(nivel==3){
            enemyLevel = l1.PuertaLevel3();
        }
        else{
            enemyLevel = l1.PuertaLevel1();
            archivo = new Archivo("s");
            archivo.ArchivoPosition(400, 450,0,1);
            JOptionPane.showMessageDialog(null, "Has Ganado gracias por jugae");
            fr.remove(panel);
            panel.setVisible(false);
            t.stop();
             
            System.exit(0);
            
        }
        puerta = new Puerta(enemyLevel[0], enemyLevel[1]);
        panel.add(puerta.door);
    }
    
    private void fondo() {
        fondo = new JLabel();
        fondo.setBounds(0, 0, 1000, 600);
        URL url = getClass().getResource("object/fondoJuego.jpg");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), fondo.getHeight()));
        fondo.setIcon(icon);
        fondo.repaint();
        panel.add(fondo);

    }

    private void deleteVida() {
        Level l1 = new Level();
        int[] enemyLevel;
        if (nivel == 1) {
            enemyLevel = l1.positionUserLevel1();
        } else {
            enemyLevel = l1.positionUserLevel2();
        }
        if (vidas == 0) {
            user.setPosicion(enemyLevel[0], enemyLevel[1]);
            v.vida1.setVisible(false);
        }
        if (vidas == 1) {
            user.setPosicion(enemyLevel[0], enemyLevel[1]);
            v.vida2.setVisible(false);
        }
        if (vidas == 3) {
            archivo = new Archivo("s");
            archivo.ArchivoPosition(400, 450,0,1);
            JOptionPane.showMessageDialog(null, "Perdio Gracias por jugar");
            fr.remove(panel);
            panel.setVisible(false);
            t.stop();
             
            System.exit(0);
        }
        vidas++;
    }

    private void movimiento() {
        fr.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                Listener encargado de escuchar los movimientos de el teclado para el avion

                accion(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

    }

    private void accion(KeyEvent e) {
        int numeroDeDesplazamiento = 10;
        int bandera = e.getExtendedKeyCode();
        //Escape
        if (bandera == KeyEvent.VK_ESCAPE) {
            archivo = new Archivo("s");
            archivo.ArchivoPosition(user.posX(), user.posY(),vidas,nivel);
            System.exit(0);
        }
        if (bandera == KeyEvent.VK_RIGHT && right || bandera == KeyEvent.VK_D && right) {

            if (user.posX() < 910) {
                user.setPosicion(user.posX() + numeroDeDesplazamiento, user.posY());
            }

        }
        //Izquierda
        if (bandera == KeyEvent.VK_LEFT && left || bandera == KeyEvent.VK_A && left) {

            if (user.posX() > 10) {
                user.setPosicion(user.posX() - numeroDeDesplazamiento, user.posY());
            }

        }

        if (bandera == KeyEvent.VK_UP && up || bandera == KeyEvent.VK_W && up) {
            if (user.posY() > 30) {
                user.setPosicion(user.posX(), user.posY() - numeroDeDesplazamiento);
            }

        }
        if (bandera == KeyEvent.VK_DOWN && down || bandera == KeyEvent.VK_S && down) {
            if (user.posY() < 490) {
                user.setPosicion(user.posX(), user.posY() + numeroDeDesplazamiento);
            }

        }
    }

    ActionListener escuchante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            left = true;
            right = true;
            up = true;
            down = true;

            if (user.area.intersects(wall1.area)) {
                if (user.posX() > wall1.posX()) {
                    left = false;
                } else {
                    right = false;
                }

                if (user.posY() > wall1.posY()) {
                    up = false;
                } else {
                    down = false;
                }
            }

            if (user.area.intersects(wall2.area)) {
                if (user.posX() > wall2.posX()) {
                    left = false;
                } else {
                    right = false;
                }

                if (user.posY() > wall2.posY()) {
                    up = false;
                } else {
                    down = false;
                }
            }
            if (user.area.intersects(wall3.area)) {
                if (user.posX() > wall3.posX()) {
                    left = false;
                } else {
                    right = false;
                }

                if (user.posY() > wall3.posY()) {
                    up = false;
                } else {
                    down = false;
                }
            }
            if (user.area.intersects(wall4.area)) {
                if (user.posX() > wall4.posX()) {
                    left = false;
                } else {
                    right = false;
                }

                if (user.posY() > wall4.posY()) {
                    up = false;
                } else {
                    down = false;
                }
            }
            if (user.area.intersects(wall5.area)) {
                if (user.posX() > wall5.posX()) {
                    left = false;
                } else {
                    right = false;
                }

                if (user.posY() > wall5.posY()) {
                    up = false;
                } else {
                    down = false;
                }
            }

            //380  170-350   670-300//
            if (user.area.intersects(enemy.areaEnemy)) {
                deleteVida();
            }
            if (user.area.intersects(enemy2.areaEnemy)) {
                deleteVida();
            }
            if (user.area.intersects(enemy3.areaEnemy)) {
                deleteVida();
            }
            if (user.area.intersects(enemy4.areaEnemy)) {
                deleteVida();
            }
            int[] moveEnemy = level.enemyMoveLevel1();
            if (enemy.posY() <= moveEnemy[0] && !controlEnemy1) {
                enemy.setPosicion(enemy.posX(), enemy.posY() + 1);
                if (enemy.posY() == moveEnemy[0]) {
                    controlEnemy1 = true;
                }
            } else {
                if (enemy.posY() == moveEnemy[1]) {
                    controlEnemy1 = false;
                }
                enemy.setPosicion(enemy.posX(), enemy.posY() - 1);
            }

            if (enemy2.posX() <= 910 && enemy2.controlEnemy) {
                enemy2.setPosicion(enemy2.posX() + 1, enemy2.posY());
                if (enemy2.posX() == 910) {
                    enemy2.setControlEnemy();
                }
            } else {
                enemy2.setPosicion(enemy2.posX() - 1, enemy2.posY());
                if (enemy2.posX() == 670) {
                    enemy2.setControlEnemy();
                }
            }

            if (enemy3.controlEnemy) {
                enemy3.setPosicion(enemy3.posX() + 1, enemy3.posY());
                if (enemy3.posX() == 160) {
                    enemy3.setControlEnemy();
                }
            } else {
                enemy3.setPosicion(enemy3.posX() - 1, enemy3.posY());
                if (enemy3.posX() == 25) {
                    enemy3.setControlEnemy();
                }
            }

            if (enemy4.controlEnemy) {
                enemy4.setPosicion(enemy4.posX(), enemy4.posY() + 1);
                if (enemy4.posY() == 110) {
                    enemy4.setControlEnemy();
                }
            } else {
                enemy4.setPosicion(enemy4.posX(), enemy4.posY() - 1);
                if (enemy4.posY() == 15) {
                    enemy4.setControlEnemy();
                }
            }

            if (user.area.intersects(key.areaKey)) {
                key.key.setVisible(false);
                key.llaveObtenida();
            }

            if (user.area.intersects(puerta.areaEnemy)) {
                if (key.getLlave()) {
                    archivo = new Archivo("s");
                    archivo.ArchivoPosition(400, 450,vidas,nivel);
                    nivel++;
                    agregarMuros();
                    
                }
            }
        }
    };

}
