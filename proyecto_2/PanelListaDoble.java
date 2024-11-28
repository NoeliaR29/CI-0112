import java.awt.*;
import javax.swing.*;

/**
 * @class PanelListaDoble
 * @brief Clase que extiende de JPanel para representar visualmente una lista doblemente enlazada.
 *
 * Esta clase maneja la interacción con una lista doblemente enlazada, permitiendo agregar, eliminar y buscar nodos,
 * así como visualizar la estructura de la lista en una interfaz gráfica.
 */
public class PanelListaDoble extends JPanel {
    private ListaDoblementeEnlazada listaDoblementeEnlazada; // Instancia de la lista doblemente enlazada.
    private JTextField campoDato; // Campo de texto para introducir datos de los nodos.
    private JButton botonAgregarInicio, botonAgregarFinal, botonEliminar, botonBuscar; // Botones para las operaciones.

    
    /**
     * Constructor para PanelListaDoble.
     * @param lista Lista doblemente enlazada que será manejada por este panel.
     */
    public PanelListaDoble(ListaDoblementeEnlazada lista) {
        this.listaDoblementeEnlazada = lista;
        configInterfaz();
    }

    /**
     * Método sobreescrito de JPanel para dibujar componentes personalizados.
     * @param g Contexto gráfico en el que se dibuja el panel.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(204, 229, 255));
        if (listaDoblementeEnlazada != null) {
            dibujarListaDoblementeEnlazada(g, listaDoblementeEnlazada.getCabeza(), 100, 100); // Posición inicial arbitraria
        }
    }

    /**
     * Método privado para dibujar la lista doblemente enlazada.
     * @param g Contexto gráfico en el que se dibuja la lista.
     * @param nodo Nodo inicial desde el que se comienza a dibujar.
     * @param x Coordenada x inicial para el primer nodo.
     * @param y Coordenada y para todos los nodos.
     */
    private void dibujarListaDoblementeEnlazada(Graphics g, NodoListaDoblemente nodo, int x, int y) {
        int espacioHorizontal = 100;  // Espacio entre nodos
        while (nodo != null) {
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

     /**
     * Método privado para configurar la interfaz gráfica de usuario.
     */
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

    /**
     * Agrega un nodo al inicio de la lista doblemente enlzada
     * Valida la entrada del usuario antes de realizar la operación para evitar inconvenientes
     */
    private void agregarNodoAlInicio() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            listaDoblementeEnlazada.agregarAlInicio(valor); 
            campoDato.setText(""); 
            repaint();  
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }

    /**
     * Agrega un nodo al final de la lista doblemente enlazada
     * Valida la entrada del usuario antes de realizar la operación para evitar inconvenientes
     */
    private void agregarNodoAlFinal() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            listaDoblementeEnlazada.agregarAlFinal(valor);
            campoDato.setText(""); 
            repaint();  
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }
     /**
     * Elimina un nodo de la lista doblemente enlazada
     * Valida la entrada del usuario antes de realizar la operación por medio del try catch
     */
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

    /**
     * Busca un nodo en la lista doblemente enlazada
     * Valida la entrada del usuario y muestra un mensaje con el resultado
     */
    private void buscarNodo() {
        try {
            int valor = Integer.parseInt(campoDato.getText());
            if (listaDoblementeEnlazada.buscar(valor)) {  
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
