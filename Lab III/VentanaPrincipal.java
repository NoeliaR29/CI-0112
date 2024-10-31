import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Formulario de usuario");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");

        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        salirItem.addActionListener(e -> System.exit(0));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

        JLabel etiquetaEmail = new JLabel("Email");
        JTextField campoEmail = new JTextField(20);

        JLabel etiquetaNombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Teléfono");
        JTextField campoTelefono = new JTextField(20);

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout()); 
        JButton limpiar = new JButton("Limpiar");
        JButton botonGuardar = new JButton("Guardar");

        JLabel comboBoxLabel = new JLabel ("tipos de usuario: ");
        String[] tiposDeUsuario = {"Cliente", "Empleado", "Administrador"};
        JComboBox<String> tiposDeUsuarioComboBox = new JComboBox<String>(tiposDeUsuario);
        panelFormulario.add(comboBoxLabel);
        panelFormulario.add(tiposDeUsuarioComboBox);

        JLabel checkBoxLabel = new JLabel("términos y condiciones: ");
        JCheckBox elegir = new JCheckBox("Aceptar términos y condiciones.");
        checkBoxLabel.setBounds(20,10,20,10);
        elegir.setBounds(50,10,20,10);
        panelFormulario.add(checkBoxLabel);
        panelFormulario.add(elegir);

        panelBotones.add(limpiar);
        panelBotones.add(botonGuardar);
        panelFormulario.add(panelBotones);

         
        elegir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (elegir.isSelected()) {
                    JOptionPane.showMessageDialog(panelFormulario, "Has aceptado los términos y condiciones.");
                } else {
                    JOptionPane.showMessageDialog(panelFormulario, "No has aceptado los términos y condiciones.");
                }
            }
        });

        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoNombre.setText("");
                campoEmail.setText("");
                campoTelefono.setText("");
                tiposDeUsuarioComboBox.setSelectedIndex(0);
                elegir.setSelected(false);
            }
        });

        add(panelFormulario);
        setVisible(true);

        botonGuardar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String telefono = campoTelefono.getText();
            String tiposUsuario = (String) tiposDeUsuarioComboBox.getSelectedItem(); 
        
            if (tiposUsuario == null || tiposUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "seleccione un tipo de usuario.");
                return; 
            }
            
            if (!elegir.isSelected()) {
                JOptionPane.showMessageDialog(null, "Debes aceptar términos y condiciones para continuar.");
                return; 
            }
        
            try {
                FileWriter writer = new FileWriter("datos_usuario.txt", true);
                writer.write("Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono + ", Tipo de usuario: " + tiposUsuario + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
            }

        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
