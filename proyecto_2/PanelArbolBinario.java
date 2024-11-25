import java.awt.*;
import javax.swing.*;

/**
 * Clase PanelArbolBinario
 * Representa un panel gráfico para la visualización y manipulación del arbol binario en la interfaz
 * Permite agregar, eliminar y buscar nodos en el árbol mediante una interfaz gráfica, actualizandose cada ves que el usuario
 * realiza una acción.
 */
public class PanelArbolBinario extends JPanel {
    private ArbolBinario arbolBinario;
    private JTextField campoNodo;
    private JButton botonAgregar, botonEliminar, botonBuscar;

    /**
     * Constructor de la clase PanelArbolBinario
     * Inicializa el árbol binario y configura la interfaz gráfica llamando al método
     * @param arbolBinario Árbol binario que se relaciona al panel
     */
    public PanelArbolBinario(ArbolBinario arbolBinario) {
        this.arbolBinario = arbolBinario;
        configInterfaz();
    }

    /**
     * Sobrescribe el método paintComponent para dibujar el árbol binario en el panel
     * @param grafico Objeto Graphics que se usa para representr graficamente e arbol
     */
    protected void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        this.setBackground(new Color(193, 255, 193));
        this.setOpaque(true); 
        if (arbolBinario.getRaiz() != null) {
            dibujarArbol(grafico, arbolBinario.getRaiz(), getWidth() / 2, 40, 100); 
        }
    }

    /**
     * Método recursivo para dibujar el árbol binario en el panel
     * Dibuja el nodo actual y las lineas que conectan cada nodo con sus hijos con una separación pretederminada
     * @param grafico objeto utilizado para dibujar
     * @param nodo nodo actual que se va a dibujar
     * @param x posición en el eje X donde se dibujará el nodo
     * @param y posición en el eje Y donde se dibujará el nodo
     * @param separacion distancia entre los nodos hijos
     */
    private void dibujarArbol(Graphics grafico, Nodo nodo, int x, int y, int separacion) {
        if (nodo != null) {
            int tamaño = 25; 
            grafico.drawOval(x - tamaño / 2, y - tamaño / 2, tamaño, tamaño); 
            FontMetrics fm = grafico.getFontMetrics(); 
            int textoAncho = fm.stringWidth(String.valueOf(nodo.getValor()));
            int textoAltura = fm.getAscent();
            grafico.drawString(String.valueOf(nodo.getValor()), 
                        x - textoAncho / 2, 
                        y + textoAltura / 4
            );
            if (nodo.getIzquierdo() != null) {
                grafico.drawLine(x, y, x - separacion, y + 50); 
                dibujarArbol(grafico, nodo.getIzquierdo(), x - separacion, y + 50, separacion / 2);
            }
            if (nodo.getDerecho() != null) {
                grafico.drawLine(x, y, x + separacion, y + 50); 
                dibujarArbol(grafico, nodo.getDerecho(), x + separacion, y + 50, separacion / 2);
            }
        }
    }

    /**
     * Configura la interfaz gráfica del panel
     * Crea los elementos de la interfaz y los coloca en el panel
     */
    private void configInterfaz() {
        setLayout(new BorderLayout());
        campoNodo = new JTextField(3);
        botonAgregar = new JButton("Agregar Nodo");
        botonEliminar = new JButton("Eliminar Nodo");
        botonBuscar = new JButton("Buscar Nodo");

        
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Valor del Nodo:"));
        controlPanel.add(campoNodo);
        controlPanel.add(botonAgregar);
        controlPanel.add(botonEliminar);
        controlPanel.add(botonBuscar);

        add(controlPanel, BorderLayout.SOUTH);

       
        botonAgregar.addActionListener(e -> agregarNodo());
        botonEliminar.addActionListener(e -> eliminarNodo());
        botonBuscar.addActionListener(e -> buscarNodo());
    }

    /**
     * Agrega un nodo al árbol binario con el método implementado en la clase arbol
     * Valida la entrada del usuario antes de realizar la operación para evitar inconvenientes
     */
    private void agregarNodo() {
        try {
            int valor = Integer.parseInt(campoNodo.getText());
            Nodo nuevoNodo = new Nodo(valor); 
            arbolBinario.agregarNodo(nuevoNodo);
            repaint();
            JOptionPane.showMessageDialog(this, "Nodo agregado: " + valor);
            campoNodo.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresaste un dato inválido.");
            campoNodo.setText("");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            campoNodo.setText("");
        }
    }

     /**
     * Elimina un nodo del árbol binario
     * Valida la entrada del usuario antes de realizar la operación por medio del try catch
     */
    private void eliminarNodo() {
        try {
            int valor = Integer.parseInt(campoNodo.getText());
            arbolBinario.eliminarNodo(valor);
            JOptionPane.showMessageDialog(this, "Nodo eliminado: " + valor);
            campoNodo.setText("");
            repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresaste un dato inválido.");
            campoNodo.setText("");
        }catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage()); 
            campoNodo.setText(""); 
        }
    }

    /**
     * Busca un nodo en el árbol binario
     * Valida la entrada del usuario y muestra un mensaje con el resultado
     */
    private void buscarNodo() {
        try {
            int valor = Integer.parseInt(campoNodo.getText());
            if (arbolBinario.encontrarNodo(valor)) {  
                JOptionPane.showMessageDialog(this, "Nodo encontrado: " + valor);
            } else {
                JOptionPane.showMessageDialog(this, "Nodo no encontrado.");
            }
            campoNodo.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
        }
    }
}


