/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemareinas;

import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author xisco
 */
public class Main {

    static int N = 0;
    int soluciones[];
    Tauler tauler;
    Ventana ventana;

    public static void main(String[] args) throws InterruptedException {
        (new Main()).comienzo();
    }

    public void comienzo() throws InterruptedException {
        ventana = new Ventana();

        ventana.intro();
        while (N == 0) {
            sleep(1);
        }
        
        soluciones = new int[N];
        tauler = new Tauler(N);

        ProblemaReinas solucion = new ProblemaReinas(N, tauler);

        if (solucion.solucionProblema(soluciones, 0)) {
            JOptionPane.showMessageDialog(null, "NO HAY  MAS SOLUCIONES");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY SOLUCION");
            System.exit(0);        
        }
    }
}
