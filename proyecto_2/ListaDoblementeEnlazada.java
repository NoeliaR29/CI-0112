/**
 * Clase que implementa una lista doblemente enlazada.
 * Permite agregar nodos al inicio o al final, buscar nodos y eliminarlos.
 */
public class ListaDoblementeEnlazada {
    private NodoListaDoblemente cabeza; //Referencia al nodo cabeza de la lista
    private NodoListaDoblemente cola;   //Referencia al nodo cola de la lista

      /**
     * Constructor de la lista doblemente enlazada.
     * Inicializa la lista como vacía, con cabeza y cola nulas.
     */
    public ListaDoblementeEnlazada(){
        this.cabeza = null;
        this.cola = null;
    }

    /**
     * Devuelve el nodo cabeza de la lista.
     * @return El nodo cabeza de la lista.
     */
    public NodoListaDoblemente getCabeza(){
        return this.cabeza;
    }

    /**
     * Devuelve el nodo cola de la lista.
     * @return El nodo cola de la lista.
     */
    public NodoListaDoblemente getCola(){
        return this.cola;
    }

    /**
     * Agrega un nodo con el valor especificado al inicio de la lista.
     * Si la lista está vacía, el nodo se convierte en la cabeza y la cola.
     * @param dato Valor que se desea almacenar en el nodo.
     */
    public void agregarAlInicio(int dato){
        NodoListaDoblemente nuevoNodo = new NodoListaDoblemente(dato);
        if (cabeza == null){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else{
            nuevoNodo.setNodoSiguiente(cabeza);
            cabeza.setNodoAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
    }
    
    /**
     * Agrega un nodo con el valor especificado al final de la lista.
     * Si la lista está vacía, el nodo se convierte en la cabeza y la cola.
     * @param dato Valor que se desea almacenar en el nodo.
     */
    public void agregarAlFinal(int dato){
        NodoListaDoblemente nuevoNodo = new NodoListaDoblemente(dato);
        if (cabeza == null){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else{
            cola.setNodoSiguiente(nuevoNodo);
            nuevoNodo.setNodoAnterior(cola);
            cola = nuevoNodo;
        }
    }

    /**
     * Busca un nodo con el valor especificado en la lista.
     * @param dato Valor que se desea buscar.
     * @return true si el nodo con el valor especificado existe, false en caso contrario.
     */
    public boolean  buscar(int dato){
        NodoListaDoblemente nodoActual = cabeza; //Empieza en la cabesza
        while (nodoActual != null){
            if(nodoActual.getDato() == dato){
                return true;
            }
            nodoActual = nodoActual.getNodoSiguiente(); // Continua con el siguiente nodo
        }
        return false; // Retorna false en caso de no encontrar el dato.
    }

    /**
     * Elimina un nodo con el valor especificado de la lista.
     * Si el nodo no se encuentra, no se realiza ninguna acción.
     * @param dato Valor del nodo que se desea eliminar.
     * @return true si el nodo fue eliminado, false si no se encontró el nodo.
     */
    public boolean eliminar(int dato){
        if(cabeza == null){
            return false; //No se encuentra el nodo en la lista
        }
        NodoListaDoblemente nodoActual = cabeza;
        while (nodoActual != null && nodoActual.getDato() != dato){
           nodoActual = nodoActual.getNodoSiguiente();
        }
        if (nodoActual == null) {
            return false;
        }

        if(nodoActual == cabeza){ //
            cabeza = cabeza.getNodoSiguiente();
            if (cabeza != null) {
                cabeza.setNodoAnterior(null);
            }
        }else if (nodoActual == cola) {
            cola = cola.getNodoAnterior();
            if(cola != null){
                cola.setNodoSiguiente(null);
            }
        }else{//nodo en algun otro punto de la lista
            NodoListaDoblemente anterior = nodoActual.getNodoAnterior();
            NodoListaDoblemente siguiente = nodoActual.getNodoSiguiente();
            
            if(anterior != null){
                anterior.setNodoSiguiente(siguiente);
            }
            if(siguiente != null){
                siguiente.setNodoAnterior(anterior);
            }
        }
        return true;
    }
}
