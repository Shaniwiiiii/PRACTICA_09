package ACTIVIDADES;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculadoraBasica {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Calculadora Básica");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 150);
        ventana.setLayout(new FlowLayout());

        JTextField campoNumero1 = new JTextField(5);
        JTextField campoNumero2 = new JTextField(5);
        JButton botonSumar = new JButton("Sumar");
        JLabel etiquetaResultado = new JLabel("Resultado: ");

        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(campoNumero1.getText());
                    int numero2 = Integer.parseInt(campoNumero2.getText());
                    int suma = numero1 + numero2;
                    etiquetaResultado.setText("Resultado: " + suma);
                } catch (NumberFormatException ex) {
                    etiquetaResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });

        ventana.add(campoNumero1);
        ventana.add(campoNumero2);
        ventana.add(botonSumar);
        ventana.add(etiquetaResultado);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}