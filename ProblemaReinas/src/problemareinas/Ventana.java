/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemareinas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static problemareinas.Main.N;

/**
 *
 * @author xisco
 */
public class Ventana {
    
    

    public Ventana() {

    }

    public void intro() {
        JFrame ventana = new JFrame();
        JLabel etiqueta = new JLabel("Introduzca la dimension");
        JTextField texto = new JTextField();
        JButton boton = new JButton("Confirmar");
        
        ventana.setLayout(null);
        ventana.setSize(400, 200);
        etiqueta.setBounds(20, 0, 400,100);
        ventana.add(etiqueta);
        texto.setBounds(220, 40, 100,25);
        ventana.add(texto);
        boton.setBounds(135, 100, 100,25);
        ventana.add(boton);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                N = Integer.parseInt(texto.getText());
                
                ventana.dispose();
            }
        });
       
    }
}
