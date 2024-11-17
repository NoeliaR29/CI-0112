import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class interfaz {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Árbol Binario y Lista Circular");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1200, 1000);

        JPanel panelLista = new JPanel();
        panelLista.setBackground(new Color(255, 228, 225)); 
        panelLista.add(new JLabel("LISTA CIRCULAR"));

        JPanel panelArbol = new JPanel();
        panelArbol.setBackground(new Color(193, 255, 193)); 
        panelArbol.setLayout(new BorderLayout()); 

        JPanel panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout());

        JTextField campoNodo = new JTextField(5);
        JButton botonAgregar = new JButton("Agregar Nodo");
        JButton botonEliminar = new JButton("Eliminar Nodo");
        JButton botonBuscar = new JButton("Buscar Nodo");
        
        panelControles.add(new JLabel("Valor del Nodo:"));
        panelControles.add(campoNodo);
        panelControles.add(botonAgregar);
        panelControles.add(botonEliminar);
        panelControles.add(botonBuscar);
       
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        JLabel titulo = new JLabel("ÁRBOL BINARIO");
        panelTitulo.add(titulo);

        panelArbol.add(panelTitulo, BorderLayout.NORTH);
        panelArbol.add(panelControles, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLista, panelArbol);
        splitPane.setDividerLocation(600); 

        ventana.setLayout(new BorderLayout());
        ventana.add(splitPane, BorderLayout.CENTER);
        ventana.setVisible(true);
    }
}
