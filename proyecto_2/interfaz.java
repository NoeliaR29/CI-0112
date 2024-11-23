import javax.swing.*;
import java.awt.*;

public class interfaz {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Árbol Binario, lista circular y doblemente enlazada");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1200, 1000);

        JPanel panelListaCircular = new JPanel();
        panelListaCircular.setBackground(new Color(255, 228, 225)); 
        panelListaCircular.setLayout(new BorderLayout()); 

        JPanel panelListaDoble = new JPanel();
        panelListaDoble.setBackground(new Color(230, 230, 250)); 
        panelListaDoble.setLayout(new BorderLayout());

        // ARBOL BINARIO
        ArbolBinario arbolBinario = new ArbolBinario();
        PanelDibujos graficaArbol = new PanelDibujos(arbolBinario);
        graficaArbol.setPreferredSize(new Dimension(300, 200));
        ventana.add(graficaArbol);
        
        
        JPanel panelArbol = new JPanel();
        panelArbol.setBackground(new Color(193, 255, 193)); 
        panelArbol.setLayout(new BorderLayout()); 

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        JLabel titulo = new JLabel("ÁRBOL BINARIO");
        panelTitulo.add(titulo);

        JPanel controlesArbol = new JPanel();
        controlesArbol.setLayout(new BoxLayout(controlesArbol, BoxLayout.Y_AXIS));
        JTextField campoNodo = new JTextField(3);

        //creación del panel para manejar los botones juntos en un solo Jpanel
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));  

        JButton botonAgregar = new JButton("Agregar Nodo");
        JButton botonEliminar = new JButton("Eliminar Nodo");
        JButton botonBuscar = new JButton("Buscar Nodo");

        panelBotones.add(botonAgregar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonBuscar);

        //Panel en el que están los botones y el espacio para que el usuario ingrese el valor que quiere 
        controlesArbol.add(Box.createVerticalStrut(20)); 
        controlesArbol.add(new JLabel("Valor del Nodo:"));
        controlesArbol.add(campoNodo);
        controlesArbol.add(Box.createVerticalStrut(20));
        controlesArbol.add(panelBotones);
        
        //agregar titulo y el panel donde están botones y text field
        panelArbol.add(panelTitulo, BorderLayout.NORTH);
        panelArbol.add(controlesArbol, BorderLayout.SOUTH);
        panelArbol.add(graficaArbol, BorderLayout.CENTER);

        //divisores de la ventana para que se muestren los tres a la vez
        JSplitPane splitPaneIzquierdo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListaCircular, panelArbol); 
        splitPaneIzquierdo.setDividerLocation(500);
        
        JSplitPane splitPanePrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPaneIzquierdo, panelListaDoble);
        splitPanePrincipal.setDividerLocation(1000);

    
        //action listener para que los botones hagan su función, implementando el manejo de excepciones para algun error de ingreso de datos

        //agregar los nodos al arbol
        botonAgregar.addActionListener(e -> {
                try {
                    int valor = Integer.parseInt(campoNodo.getText());
                    Nodo nuevoNodo = new Nodo(valor); 
                    arbolBinario.agregarNodo(nuevoNodo);
                    graficaArbol.repaint();
                    JOptionPane.showMessageDialog(ventana, "Nodo agregado: " + valor);
                    campoNodo.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Ingresaste un dato inválido.");
                    campoNodo.setText("");
                }catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(ventana, ex.getMessage());
                    campoNodo.setText("");
                }
            }
        );

        //buscar un nodo especifico en el árbol
        botonBuscar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(campoNodo.getText());
                if (arbolBinario.buscarNodoRec(arbolBinario.getRaiz(), valor)) {
                    JOptionPane.showMessageDialog(ventana, "Nodo encontrado: " + valor);
                    campoNodo.setText("");
                }else {
                    JOptionPane.showMessageDialog(ventana, "Nodo no encontrado: " + valor);
                    campoNodo.setText("");
                }
                graficaArbol.repaint();
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Ingresaste un dato inválido.");
                campoNodo.setText("");
                }
            }
        );

        //eliminar nodos del arbol
        botonEliminar.addActionListener(e -> {
                try {
                    int valor = Integer.parseInt(campoNodo.getText());
                    arbolBinario.eliminarNodo(valor);
                    JOptionPane.showMessageDialog(ventana, "Nodo eliminado: " + valor);
                    campoNodo.setText("");
                    graficaArbol.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Ingresaste un dato inválido.");
                    campoNodo.setText("");
                }
            }   
        );

        ventana.setLayout(new BorderLayout());
        ventana.add(splitPanePrincipal, BorderLayout.CENTER);
        ventana.setVisible(true);
    }
}