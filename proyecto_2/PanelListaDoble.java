import java.awt.*;
import javax.swing.*;
public class PanelListaDoble extends JPanel {
    private ListaDoblementeEnlazada listaDoblementeEnlazada;
    private JTextField campoDato;
    private JButton botonAgregarInicio, botonAgregarFinal, botonEliminar, botonBuscar;

    public PanelListaDoble(ListaDoblementeEnlazada lista) {
        this.listaDoblementeEnlazada = lista;
        configInterfaz();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(204, 229, 255));
        if (listaDoblementeEnlazada != null) {
            dibujarListaDoblementeEnlazada(g, listaDoblementeEnlazada.getCabeza(), 100, 100); // Posición inicial arbitraria
        }
    }

    private void dibujarListaDoblementeEnlazada(Graphics g, NodoListaDoblemente nodo, int x, int y) {
        int espacioHorizontal = 100;  // Espacio entre nodos
        while (nodo != null) {
            // Dibujo del nodo
            g.drawRect(x, y, 50, 50); // Dibuja un cuadrado para el nodo
            String dato = String.valueOf(nodo.getDato());
            FontMetrics fm = g.getFontMetrics();
            int width = fm.stringWidth(dato);
            int height = fm.getAscent();
            g.drawString(dato, x + (50 - width) / 2, y + (50 + height) / 4); // Centra el texto en el nodo

            // Dibujo de las líneas hacia el siguiente y anterior nodo
            if (nodo.getNodoSiguiente() != null) {
                g.drawLine(x + 50, y + 25, x + espacioHorizontal + 50, y + 25); // Línea hacia el siguiente nodo
            }
            if (nodo.getNodoAnterior() != null) {
                g.drawLine(x, y + 25, x - espacioHorizontal, y + 25); // Línea hacia el nodo anterior
            }

            // Mover x para el siguiente nodo
            x += espacioHorizontal + 50;
            nodo = nodo.getNodoSiguiente();
        }
    }

    private void configInterfaz() {
        setLayout(new BorderLayout());
        campoDato = new JTextField(3);
        botonAgregarInicio = new JButton("Agregar al Inicio");
        botonAgregarFinal = new JButton("Agregar al Final");
        botonEliminar = new JButton("Eliminar Nodo");
        botonBuscar = new JButton("Buscar Nodo");

        // Panel de controles
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Valor del Nodo:"));
        controlPanel.add(campoDato);
        controlPanel.add(botonAgregarInicio);
        controlPanel.add(botonAgregarFinal);
        controlPanel.add(botonEliminar);
        controlPanel.add(botonBuscar);

        add(controlPanel, BorderLayout.SOUTH);

        // Asigna los ActionListeners
        botonAgregarInicio.addActionListener(e -> agregarNodoAlInicio());
        botonAgregarFinal.addActionListener(e -> agregarNodoAlFinal());
        botonEliminar.addActionListener(e -> eliminarNodo());
        botonBuscar.addActionListener(e -> buscarNodo());
    }

    private void agregarNodoAlInicio() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            listaDoblementeEnlazada.agregarAlInicio(valor); 
            campoDato.setText(""); // Limpia el campo de texto después de la operación
            repaint();  // Redibuja el panel para mostrar el nuevo nodo
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }

    private void agregarNodoAlFinal() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            listaDoblementeEnlazada.agregarAlFinal(valor);
            campoDato.setText(""); // Limpia el campo de texto después de la operación
            repaint();  // Redibuja el panel para mostrar el nuevo nodo
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }

    private void eliminarNodo() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            if (listaDoblementeEnlazada.eliminar(valor)) {  
                JOptionPane.showMessageDialog(this, "Nodo eliminado.");
            } else {
                JOptionPane.showMessageDialog(this, "Nodo no encontrado.");
            }
            campoDato.setText("");
            repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }

    private void buscarNodo() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            if (listaDoblementeEnlazada.buscar(valor)) {  // Suponiendo que devuelve un booleano
                JOptionPane.showMessageDialog(this, "Nodo encontrado: " + valor);
            } else {
                JOptionPane.showMessageDialog(this, "Nodo no encontrado.");
            }
            campoDato.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }
}
