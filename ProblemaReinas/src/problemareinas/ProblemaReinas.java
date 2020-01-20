/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemareinas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author xisco
 */
public class ProblemaReinas extends JFrame {

    int n;
    static boolean continuar = false;
    boolean haysolucion = false;
    Tauler tab;

    public ProblemaReinas(int dimension, Tauler t) {
        n = dimension;
        tab = t;
        init();
    }

    public boolean solucionProblema(int solucion[], int k) throws InterruptedException {

        solucion[k] = -1;
        do {
            solucion[k] = solucion[k] + 1;
            if (esValido(solucion, k)) {
                if (k != n - 1) {
                    solucionProblema(solucion, k + 1);
                } else {//Hemos enconrado una solucion
                    continuar = false;
                    haysolucion = true;
                    imprimirResultado(solucion);
                    while (!continuar) {
                        sleep(1);
                    }
                }
            }
        } while (solucion[k] != n - 1);
        return haysolucion;
    }

    public boolean esValido(int array[], int aux) {

        for (int i = 0; i < aux; i++) {

            if (array[i] == array[aux] || Math.abs(i - aux) == Math.abs(array[i] - array[aux])) {
                return false;
            }
        }

        return true;
    }

    public void imprimirResultado(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + "->" + array[i] + " ");
        }
        System.out.println();

        for (int q = 0; q < n; q++) {
            for (int k = 0; k < n; k++) {
                tab.buida(q, k);
            }
        }

        for (int j = 0; j < n; j++) {
            tab.Posa(Pesa.REINAN, array[j], j);
        }

        this.setSize(tab.getPreferredSize());
        this.pack();
        this.setVisible(true);
    }

    public void init() {
        JButton boton = new JButton("Siguiente");
        this.setTitle("PROBLEMA DE LAS N REINAS");
        this.setLayout(new FlowLayout());
        this.getContentPane().add(tab);
        this.getContentPane().add(boton);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                continuar = true;
            }
        });
    }
}
