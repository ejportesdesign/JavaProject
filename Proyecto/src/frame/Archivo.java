package frame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author EdgarCarrero
 */
class Archivo {

    Inicio p;
    int subir;
    int xD = 0;
    String arch = "Top.txt", a;
    int i = 0;

    public Archivo() throws IOException {

    }

    //nombre lo usamos para llegar por parametros el nombre ingresado por el usuario//
    Archivo(String nombre) {

        String a = nombre;
        try {

            File f = new File("SaveGame.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            fw.append("");

            fw.close();

        } catch (IOException ex) {
        }

    }

    public String[] leer() throws FileNotFoundException, IOException {
        File archivo = new File("SaveGame.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String last = null, line;

        while ((line = br.readLine()) != null) {
            last = line;
        }
        if(last==null){
            String[] frutas = {"0", "0", "0", "0"};
            return null;
        }
        String str = last;
        String[] newStr = new String[4];
         newStr = str.split("\\s+");
        
        return newStr;
    }

    //Total es la puntuacion final del jugador que se agrega al archivo//
    public void ArchivoPosition(int x, int y, int vidas,int niveles) {
        String punt2 = String.valueOf(y);
        String punt = String.valueOf(x);
        String vida = String.valueOf(vidas);
        String nivel = String.valueOf(niveles);
        File f = new File("SaveGame.txt");
        try {

            FileWriter fw;
            fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.append(punt + " " + punt2 + " " + vida + " " + nivel + "\r\n");
            bw.newLine();
            fw.close();
        } catch (IOException ex) {
        }

    }

    public void deleteArchivo() {

        File f = new File("SaveGame.txt");
        try {

            FileWriter fw;
            fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
            f.delete();
        } catch (IOException ex) {
        }

    }

}
