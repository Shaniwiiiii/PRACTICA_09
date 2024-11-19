package ACTIVIDADES;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TemporizadorSimple {
    private static int tiempoRestante;

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Temporizador Simple");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 150);
        ventana.setLayout(new BorderLayout());

        JTextField campoTiempo = new JTextField("10"); // Tiempo inicial en segundos
        JButton botonIniciar = new JButton("Iniciar");
        JLabel etiquetaTemporizador = new JLabel("Tiempo restante: ", SwingConstants.CENTER);

        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tiempoRestante = Integer.parseInt(campoTiempo.getText());
                    etiquetaTemporizador.setText("Tiempo restante: " + tiempoRestante + " segundos");
                    new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (tiempoRestante > 0) {
                                tiempoRestante--;
                                etiquetaTemporizador.setText("Tiempo restante: " + tiempoRestante + " segundos");
                            } else {
                                ((Timer) evt.getSource()).stop();
                                etiquetaTemporizador.setText("¡Tiempo terminado!");
                            }
                        }
                    }).start();
                } catch (NumberFormatException ex) {
                    etiquetaTemporizador.setText("Por favor, ingrese un número válido.");
                }
            }
        });

        ventana.add(campoTiempo, BorderLayout.NORTH);
        ventana.add(botonIniciar, BorderLayout.CENTER);
        ventana.add(etiquetaTemporizador, BorderLayout.SOUTH);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}