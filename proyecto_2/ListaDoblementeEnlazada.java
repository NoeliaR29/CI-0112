public class ListaDoblementeEnlazada {
    private NodoListaDoblemente cabeza;
    private NodoListaDoblemente cola;

    public ListaDoblementeEnlazada(){
        this.cabeza = null;
        this.cola = null;
    }

    //Metodo para agragar nodo al inicio
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
    //Metodo para aregar nodo al final
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

    //Metodo para buscar un nodo en la lista
    public NodoListaDoblemente buscar(int dato){
        NodoListaDoblemente nodoActual = cabeza; //Empieza en la cabesza
        while (nodoActual != null){
            if(nodoActual.getDato() == dato){
                return nodoActual;
            }
            nodoActual.getNodoSiguiente(); // Continua con el siguiente nodo
        }
        return null; // Retorna null en caso de no encontrar el dato.
    }

    public void eliminar(int dato){
        NodoListaDoblemente nodoEliminar = buscar(dato);

        if(nodoEliminar == null){
            return; //No se encuentra el nodoD
        }
        
    }
}
