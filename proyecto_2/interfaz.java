import java.awt.*;
import javax.swing.*;

/**
 * @class Interfaz
 * @brief Clase que extiende de JFrame para crear una interfaz gráfica que maneja múltiples estructuras de datos.
 * 
 * Esta clase configura una ventana principal que contiene representaciones visuales de un árbol binario,
 * una lista circular y una lista doblemente enlazada. Cada estructura de datos se visualiza en su propio panel
 * y la interfaz utiliza JSplitPanes para organizar los paneles de manera flexible.
 */
public class Interfaz extends JFrame {
    
    /**
     * Constructor para Interfaz.
     * Configura la ventana principal, establece el título y la operación de cierre, y centra la ventana en la pantalla.
     */
    public Interfaz() {
        setTitle("Árbol Binario, lista circular y doblemente enlazada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configInterfaz(); 
        pack(); 
        setLocationRelativeTo(null); 
    }
    
    /**
     * Método privado para configurar los componentes de la interfaz.
     * Crea y organiza JSplitPanes y añade los paneles para cada estructura de datos.
     */
    private void configInterfaz() {
        JSplitPane splitPanePrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPanePrincipal.setResizeWeight(0.5); 

        PanelArbolBinario panelArbol = new PanelArbolBinario(new ArbolBinario());
        PanelListaDoble panelListaDoble = new PanelListaDoble(new ListaDoblementeEnlazada());
        PanelListaCircular panelListaCircular = new PanelListaCircular(new ListaCircular());

        // Configuración del JSplitPane
        JSplitPane splitPaneIzquierdo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListaCircular, panelArbol);
        splitPaneIzquierdo.setDividerLocation(500); 

        splitPanePrincipal.setLeftComponent(splitPaneIzquierdo);
        splitPanePrincipal.setRightComponent(panelListaDoble);

        // Configuración de un panel sur para botones adicionales o información
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Añade un margen alrededor del panel del sur
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        getContentPane().add(splitPanePrincipal, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Método main para iniciar la aplicación.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }
}