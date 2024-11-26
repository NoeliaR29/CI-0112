import java.awt.*;
import javax.swing.*;

/**
 * creación de clase PanelListaCircular
 * es un panel gráfico para la ver y modificar la lista circular
 * permite que el usuario inserte, elimine y busque nodos en la lista circular, a través una interfaz gráfica
 */
public class PanelListaCircular extends JPanel{
    private ListaCircular listaCircular;
    private JTextField campoDato;
    private JButton botonInsertar, botonEliminar, botonBuscar;

    /**
     * constructor de la clase PanelListaCircular
     * cnicializa la lista circular y configura la interfaz gráfica con java swing
     * @param listaCircular lista circular que se relaciona al panel
     */
    public PanelListaCircular(ListaCircular listaCircular){
        this.listaCircular = listaCircular;
        configurarInterfaz();
    }

    /**
     * método paintComponent para dibujar la lista circular en el panel y que se pueda visualizar
     * @param grafico Objeto Graphics para permitir dibujar la lista
     */
   
    protected void paintComponent(Graphics grafico){
        super.paintComponent(grafico);
        this.setBackground(new Color(255, 228, 225)); 
        if (listaCircular != null){
            
            dibujarLista(grafico);
        }
        
    }

    /**
     * dibujar los nodos de la lista circluar en el panel
     * @param grafico ,objeto que se usa para realizar lso dibujos
     */
    private void dibujarLista(Graphics grafico){
        NodoLista actual = listaCircular.getPrimerNodo();
        if (actual == null){ 
        return; 
        }
        
        int x = getWidth() / 2, y = 50, radio = 50;
        do{
            // para hacer el dibujo del nodo
            grafico.setColor(Color.CYAN);
            grafico.fillOval(x - radio / 2, y - radio / 2, radio, radio);
            grafico.setColor(Color.BLACK);
            grafico.drawOval(x - radio / 2, y - radio / 2, radio, radio);
            grafico.drawString(actual.getDato(), x - 10, y + 5);

            // para dbujar la flecha aputnando al siguiente nodo
            if (actual.getSiguiente() != listaCircular.getPrimerNodo()){
                grafico.drawLine(x, y + radio / 2, x + 100, y + radio / 2);
                grafico.drawLine(x + 90, y + radio / 2 - 10, x + 100, y + radio / 2);
                grafico.drawLine(x + 90, y + radio / 2 + 10, x + 100, y + radio / 2);
            }

            x += 120; // mover una posición hacia el nod siguiente 
            if (x > getWidth() - 100){
                x = getWidth() / 2;
                y += 100;
            }

            actual = actual.getSiguiente();
        } while (actual != listaCircular.getPrimerNodo());
    }

    /**
     * interfaz del panel  de la lista circular
     * hace elementos y los pone en el panel
     */
    private void configurarInterfaz(){
        
        setLayout(new BorderLayout());
        campoDato = new JTextField(10);
        
        botonInsertar = new JButton("Insertar dato");
        botonEliminar = new JButton("Eliminar dato");
        botonBuscar = new JButton("Buscar dato");

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Dato:"));
        
        controlPanel.add(campoDato);
        controlPanel.add(botonInsertar);
        controlPanel.add(botonEliminar);
        controlPanel.add(botonBuscar);

        add(controlPanel, BorderLayout.SOUTH);

        botonInsertar.addActionListener(e -> insertarDato());
        botonEliminar.addActionListener(e -> eliminarDato());
        botonBuscar.addActionListener(e -> buscarDato());
    }
    
    /**
     * método que inserta un dato en la lista circular
     * valida la entrada del usuario para asegurarse que sea válida
     */
    private void insertarDato(){
        try {
            String dato = campoDato.getText();
            listaCircular.insertarDato(dato);
            
            JOptionPane.showMessageDialog(this, " Se ha insertado el dato : " + dato);
            campoDato.setText("");
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ingresado un dato no válido");
        }
    }
    
    /**
     * método para eliminra un dato de la lista 
     * valida la entrada del usuaro para asegurarse que sea válida
     */
    private void eliminarDato(){
        try {
            String dato = campoDato.getText();
            listaCircular.eliminarDato(dato);
            
            JOptionPane.showMessageDialog(this, " Se ha eliminado el dato: " + dato);
            campoDato.setText("");
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ingresado un dato no válido");
        }
    }  
    
    /**
     * método para hacer búsqueda de un dato en la lista 
     * valida la entrada del usuario para asegurarse que sea válida
     */
    private void buscarDato(){
        try {
            String dato = campoDato.getText();
            boolean encontrado = listaCircular.buscarDato(dato);
            
            if (encontrado) {
                JOptionPane.showMessageDialog(this, "El dato está en la lista.");
            }else{
            JOptionPane.showMessageDialog(this, "El dato no está en la lista.");
            }
            campoDato.setText("");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al buscar el dato.");
        }
    }
    
  }