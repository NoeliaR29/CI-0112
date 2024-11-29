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
        
        // posicioens predefinidas para que se vea circular 
        int[][] posiciones = {
            {200, 100}, // nodo 1
            {300, 150}, // nodo 2
            {350, 250}, // nodo 3
            {300, 350}, // nodo 4
            {200, 400}, // nodo 5
            {100, 350}, // nodo 6
            {50, 250},  // nodo 7
            {100, 150}, // nodo 8
            {150, 50},  // nodo 9
            {250, 50}   // nodo 10
            };

        int radioNodo = 50; // tamaño del nodo
        int index = 0;
        int cantidadNodos = listaCircular.getCantidadNodos();

        NodoLista primero = actual; // referencia al primero nodo

        do{
            int xNodo = posiciones[index][0];
            int yNodo = posiciones[index][1];

            // para hacer dibujo del nodo
            grafico.setColor(Color.CYAN);
            grafico.fillOval(xNodo - radioNodo / 2, yNodo - radioNodo / 2, radioNodo, radioNodo);
            grafico.setColor(Color.BLACK);
            grafico.drawOval(xNodo - radioNodo / 2, yNodo - radioNodo / 2, radioNodo, radioNodo);
            grafico.drawString(actual.getDato(), xNodo - 10, yNodo + 5);

            // dibujo de la flecha apuntando al nodo que sigue
            NodoLista siguiente = actual.getSiguiente();
            
            if(siguiente != null && siguiente != primero){ // si es así, no se dibuja la fecha hacia el primeor aun
                
                int siguienteIndex = (index + 1) % posiciones.length;
                int xSiguiente = posiciones[siguienteIndex][0];
                int ySiguiente = posiciones[siguienteIndex][1];

                // dibujo de linea entre cada nodo
                grafico.drawLine(xNodo, yNodo, xSiguiente, ySiguiente);

                // punta de flecha
                grafico.fillOval(xSiguiente - 5, ySiguiente - 5, 10, 10); 
            }

            actual = actual.getSiguiente();
            index++;
        }while(actual != primero && index < cantidadNodos);

        // flecha de regreso al nodo que está de primero para que se vea "circular" 
        if (cantidadNodos > 1){
            int xUltimo = posiciones[index - 1][0];
            int yUltimo = posiciones[index - 1][1];
            int xPrimero = posiciones[0][0];
            int yPrimero = posiciones[0][1];

            grafico.drawLine(xUltimo, yUltimo, xPrimero, yPrimero);
            grafico.fillOval(xPrimero - 5, yPrimero - 5, 10, 10); // Punta de flecha al primer nodo
        }
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
            if (dato.equals("")){
                JOptionPane.showMessageDialog(this, "Por favor ingrese un dato válido");
                return;
            }

            listaCircular.insertarDato(dato);
            
            JOptionPane.showMessageDialog(this, " Se ha insertado el dato : " + dato);
            campoDato.setText("");

            repaint(); //para verse apenas se agrgue el dato
        }catch(Exception e) {

            JOptionPane.showMessageDialog(this, "Ha ingresado un dato no válido");
            campoDato.setText("");
        }
    }
    
    /**
     * método para eliminar un dato de la lista 
     * valida la entrada del usuaro para asegurarse que sea válida
     */
    private void eliminarDato(){
        try {
            String dato = campoDato.getText();
            if(dato.equals("")){
                JOptionPane.showMessageDialog(this, "Por favor ingrese un dato válido");
                return;
            }

            if(!listaCircular.buscarDato(dato)){ //para que no "elimine" uno que no está 
                JOptionPane.showMessageDialog(this, "El dato no se puede eliminar porque no está en la lista");
                campoDato.setText("");
                return;
            }

            listaCircular.eliminarDato(dato);
            
            JOptionPane.showMessageDialog(this, " Se ha eliminado el dato: " + dato);
            campoDato.setText("");

            repaint(); //para que se vea apenas se elimine
        
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
            campoDato.setText("");
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
            
            if(dato.equals("")){
                JOptionPane.showMessageDialog(this, "Por favor ingrese un dato válido");
                return;
            }
            
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