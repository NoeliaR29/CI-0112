/**
 * Clase que representa un nodo de una lista doblemente enlazada.
 * Cada nodo almacena un dato y referencias a los nodos anterior y siguiente.
 */
public class NodoListaDoblemente {
    private int dato;
    private NodoListaDoblemente nodoAnterior;
    private NodoListaDoblemente nodoSiguiente;

    /**
     * Constructor del nodo.
     * Inicializa el nodo con el dato especificado y referencias nulas para los nodos anterior y siguiente.
     * 
     * @param dato Valor que se desea almacenar en el nodo.
     */
    public NodoListaDoblemente(int dato){
        this.dato = dato;
        this.nodoAnterior = null;
        this.nodoSiguiente = null;
    }

    
    /**
     * Establece el valor almacenado en el nodo.
     * 
     * @param dato Nuevo valor que se desea almacenar.
     */
    public void setDato(int dato){
        this.dato = dato;
    }

    /**
     * Establece el valor almacenado en el nodo.
     * 
     * @param dato Nuevo valor que se desea almacenar.
     */
    public int getDato(){
        return this.dato;
    }

    /**
     * Establece la referencia al nodo anterior.
     * 
     * @param nodoAnterior Nodo que se establecerá como el anterior al actual.
     */
    public void setNodoAnterior(NodoListaDoblemente nodoAnterior){
        this.nodoAnterior = nodoAnterior;
    }

    /**
     * Obtiene la referencia al nodo anterior.
     * 
     * @return Nodo anterior al actual, o null si no hay nodo anterior.
     */
    public NodoListaDoblemente getNodoAnterior(){
        return this.nodoAnterior;
    }

    /**
     * Establece la referencia al nodo siguiente.
     * 
     * @param nodoSiguiente Nodo que se establecerá como el siguiente al actual.
     */
    public void setNodoSiguiente(NodoListaDoblemente nodoSiguiente){
        this.nodoSiguiente = nodoSiguiente;
    }

    /**
     * Obtiene la referencia al nodo siguiente.
     * 
     * @return Nodo siguiente al actual, o null si no hay nodo siguiente.
     */
    public NodoListaDoblemente getNodoSiguiente(){
        return this.nodoSiguiente;
    }
}
