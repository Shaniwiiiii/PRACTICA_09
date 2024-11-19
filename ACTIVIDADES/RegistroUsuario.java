package ACTIVIDADES;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistroUsuario {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Registro de Usuario");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 200); // Aumentar el tamaño de la ventana
        ventana.setLayout(new GridLayout(4, 2, 10, 10)); // Espaciado entre componentes

        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField();
        JLabel etiquetaCorreo = new JLabel("Correo:");
        JTextField campoCorreo = new JTextField();
        JButton botonRegistrar = new JButton("Registrar");
        JLabel etiquetaMensaje = new JLabel("", SwingConstants.CENTER);

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String correo = campoCorreo.getText();
                if (!nombre.isEmpty() && !correo.isEmpty()) {
                    etiquetaMensaje.setText("Usuario registrado: " + nombre + " (" + correo + ")");
                } else {
                    etiquetaMensaje.setText("Por favor, complete todos los campos.");
                }
            }
        });

        ventana.add(etiquetaNombre);
        ventana.add(campoNombre);
        ventana.add(etiquetaCorreo);
        ventana.add(campoCorreo);
        ventana.add(botonRegistrar);
        ventana.add(etiquetaMensaje);

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}