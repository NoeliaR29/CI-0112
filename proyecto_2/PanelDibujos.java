import javax.swing.*;
import java.awt.*;

public class PanelDibujos extends JPanel {
    private ArbolBinario arbol;

    /**
     * Constructor de la clase 
     * @param arbol árbol binario que se dibujará en el panel
     */
    public PanelDibujos(ArbolBinario arbol) {
        this.arbol = arbol;
        this.setPreferredSize(new Dimension(800, 600)); 
    }

    /**
     * Método con paintComponent que se llama automáticamente cuando el panel necesita ser redibujado
     * Dibuja el árbol binario en el panel
     * @param grafico objeto Graphics utilizado para dibujar en el panel
     */
    protected void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        this.setBackground(new Color(193, 255, 193));
        this.setOpaque(true); 
        if (arbol.getRaiz() != null) {
            dibujarArbol(grafico, arbol.getRaiz(), getWidth() / 2, 40, 100); // Llama a la función para dibujar el árbol
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
     * Método para actualizar el árbol cada que cambia
     * 
     * @param nuevoArbol El nuevo árbol binario
     */
    public void actualizarArbol(ArbolBinario nuevoArbol) {
        this.arbol = nuevoArbol;
        repaint(); 
    }
}
