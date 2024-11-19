import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CompraPasajes extends JFrame {
    private JTextField nombreField, documentoField, fechaField;
    private JCheckBox audifonos, manta, revistas;
    private JRadioButton primerPiso, segundoPiso;
    private JComboBox<String> origenCombo, destinoCombo;
    private JList<String> servicioList;
    private JButton comprarButton;

    public CompraPasajes() {
        super("Compra de Pasajes - Perú");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        // Panel de ingreso de datos
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del Pasajero"));
        panelDatos.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelDatos.add(nombreField);

        panelDatos.add(new JLabel("Documento:"));
        documentoField = new JTextField();
        panelDatos.add(documentoField);

        panelDatos.add(new JLabel("Fecha de viaje (DD/MM/AAAA):"));
        fechaField = new JTextField();
        panelDatos.add(fechaField);

        add(panelDatos, BorderLayout.NORTH);

        // Panel de selección de piso, origen y destino
        JPanel panelSeleccion = new JPanel(new GridLayout(3, 2, 10, 10));
        panelSeleccion.setBorder(BorderFactory.createTitledBorder("Selección de Piso y Destino"));
        panelSeleccion.add(new JLabel("Piso:"));
        ButtonGroup grupoPiso = new ButtonGroup();
        primerPiso = new JRadioButton("1er Piso");
        segundoPiso = new JRadioButton("2do Piso");
        grupoPiso.add(primerPiso);
        grupoPiso.add(segundoPiso);
        JPanel pisoPanel = new JPanel();
        pisoPanel.add(primerPiso);
        pisoPanel.add(segundoPiso);
        panelSeleccion.add(pisoPanel);

        panelSeleccion.add(new JLabel("Origen:"));
        origenCombo = new JComboBox<>(new String[]{"Lima", "Cusco", "Arequipa", "Trujillo", "Piura"});
        panelSeleccion.add(origenCombo);

        panelSeleccion.add(new JLabel("Destino:"));
        destinoCombo = new JComboBox<>(new String[]{"Lima", "Cusco", "Arequipa", "Trujillo", "Piura"});
        panelSeleccion.add(destinoCombo);

        add(panelSeleccion, BorderLayout.WEST);

        // Panel de opciones de servicios y calidad del servicio
        JPanel panelOpcionesCalidad = new JPanel();
        panelOpcionesCalidad.setLayout(new GridLayout(1, 2)); // Dos columnas

        // Panel de opciones de servicios
        JPanel panelOpciones = new JPanel();
        panelOpciones.setBorder(BorderFactory.createTitledBorder("Opciones de Servicio"));
        audifonos = new JCheckBox("Audífonos");
        manta = new JCheckBox("Manta");
        revistas = new JCheckBox("Revistas");
        panelOpciones.add(audifonos);
        panelOpciones.add(manta);
        panelOpciones.add(revistas);

        // Panel de selección de calidad del servicio
        JPanel panelServicio = new JPanel();
        panelServicio.setBorder(BorderFactory.createTitledBorder("Calidad del Servicio"));
        servicioList = new JList<>(new String[]{"Económico", "Estándar", "VIP"});
        servicioList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelServicio.add(new JScrollPane(servicioList));

        // Agregar los paneles al panel de opciones y calidad
        panelOpcionesCalidad.add(panelOpciones);
        panelOpcionesCalidad.add(panelServicio);

        add(panelOpcionesCalidad, BorderLayout.CENTER);

        // Botón de compra
        JPanel panelBoton = new JPanel();
        comprarButton = new JButton("Comprar");
        panelBoton.add(comprarButton);
        add(panelBoton, BorderLayout.SOUTH);

        // Acción del botón Comprar
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarDatos()) {
                    mostrarResumen();
                }
            }
        });

        setVisible(true);
    }

    private boolean validarDatos() {
        String nombre = nombreField.getText();
        String documento = documentoField.getText();
        String fecha = fechaField.getText();

        // Validar nombre (solo letras y espacios)
        if (nombre.isEmpty() || !nombre.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre válido (solo letras).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar documento (solo números)
        if (documento.isEmpty() || !documento.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un documento válido (solo números).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar fecha (formato DD/MM/AAAA)
        if (fecha.isEmpty() || !fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una fecha válida (DD/MM/AAAA).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void mostrarResumen() {
        String nombre = nombreField.getText();
        String documento = documentoField.getText();
        String fecha = fechaField.getText();
        String piso = primerPiso.isSelected() ? "1er Piso" : "2do Piso";
        String origen = (String) origenCombo.getSelectedItem();
        String destino = (String) destinoCombo.getSelectedItem();
        String servicios = "Servicios: " + (audifonos.isSelected() ? "Audífonos " : "") +
                (manta.isSelected() ? "Manta " : "") +
                (revistas.isSelected() ? "Revistas " : "");
        String calidadServicio = "Calidad del Servicio: " + servicioList.getSelectedValue();

        String resumen = String.format("Resumen de Compra:\nNombre: %s\nDocumento: %s\nFecha: %s\nPiso: %s\nOrigen: %s\nDestino: %s\n%s\n%s",
                nombre, documento, fecha, piso, origen, destino, servicios, calidadServicio);

        JOptionPane.showMessageDialog(this, resumen, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new CompraPasajes();
    }
}