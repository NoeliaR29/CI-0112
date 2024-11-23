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
        
    // Lista Circular 
        
        ListaCircular listaCircular = new ListaCircular(); 
        
        JPanel panelTituloListaCircular = new JPanel();
        panelTituloListaCircular.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        JLabel tituloListaCircular = new JLabel("LISTA CIRCULAR");
        panelTituloListaCircular.add(tituloListaCircular);
        
        JPanel controlesListaCircular = new JPanel();
        controlesListaCircular.setLayout(new BoxLayout(controlesListaCircular, BoxLayout.Y_AXIS));
        JTextField campoDatoListaCircular = new JTextField(3);

        JPanel panelBotonesListaCircular = new JPanel();
        panelBotonesListaCircular.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton botonAgregarListaCircular = new JButton("Agregar dato");
        JButton botonEliminarListaCircular = new JButton("Eliminar dato");
        JButton botonBuscarListaCircular = new JButton("Buscar dato");
        
        panelBotonesListaCircular.add(botonAgregarListaCircular);
        panelBotonesListaCircular.add(botonEliminarListaCircular);
        panelBotonesListaCircular.add(botonBuscarListaCircular);
        
        controlesListaCircular.add(Box.createVerticalStrut(20));
        controlesListaCircular.add(new JLabel("Valor del dato:"));
        controlesListaCircular.add(campoDatoListaCircular);
        controlesListaCircular.add(Box.createVerticalStrut(20));
        controlesListaCircular.add(panelBotonesListaCircular);
        
        panelListaCircular.add(panelTituloListaCircular, BorderLayout.NORTH);
        panelListaCircular.add(controlesListaCircular, BorderLayout.SOUTH);
        
        // actions para botones de la lista circular
        
        //  agregar dato a lista circular
        
        botonAgregarListaCircular.addActionListener(e-> {
            try{
                String dato =  campoDatoListaCircular.getText();
                listaCircular.insertarDato(dato);
                JOptionPane.showMessageDialog(ventana, "Se ha agregado el dato: " + dato + " a la lista");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(ventana, "Ha ingresado un dato inválido");
            }
        });
        
        // action para botón de eliminar dato en lista circular
        
        botonEliminarListaCircular.addActionListener(e-> {
            try{
                String dato = campoDatoListaCircular.getText();
                listaCircular.eliminarDato(dato);
                JOptionPane.showMessageDialog(ventana, "El dato se ha eliminado");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(ventana, "Ha ingresado un dato inválido");
            }
        });
        
        // action para botón de buscar dato en la lsita circular
        
        botonBuscarListaCircular.addActionListener(e-> {
            try{
                String dato= campoDatoListaCircular.getText();
                boolean encontrado = listaCircular.buscarDato(dato);
                if(encontrado){
                    JOptionPane.showMessageDialog(ventana, "El dato: " + dato + "se encuentra en la lista");
                }else{
                    JOptionPane.showMessageDialog(ventana, "El dato no se ha encontrado en la lista");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(ventana, "Ha ingresado un dato inválido");
                
            }
        });
                
    }
                       
}
