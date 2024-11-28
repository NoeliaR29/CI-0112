public class ListaDoblementeEnlazada {
    private NodoListaDoblemente cabeza;
    private NodoListaDoblemente cola;

    public ListaDoblementeEnlazada(){
        this.cabeza = null;
        this.cola = null;
    }

    public NodoListaDoblemente getCabeza(){
        return this.cabeza;
    }
    public NodoListaDoblemente getCola(){
        return this.cola;
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
