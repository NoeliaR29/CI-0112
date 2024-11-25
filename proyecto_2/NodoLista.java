
public class NodoLista{
    /**
     * atributos de la clase NodoLista (nodo de la lista circualr)
    */
    private String dato;
    private NodoLista siguiente;

    /**
     * constructor de la clase NodoLista
     * 
     * @param dato el dato que va a guardar este nodo
     */
    public NodoLista(String dato){
        this.dato = dato; 
        this.siguiente = null;
    }
    // setters y getters


     /**
     * establece un nuevo valor para el dato del nodo
     * 
     * @param dato el dato que estará en el nodo
     */
    public void setDato (String dato){
        this.dato = dato;
    } 

     /**
     * obtiene el dato que hay en el nodo
     * 
     * @return el dato del nodo
     */
    public String getDato(){
        return dato;
    }

    /**
     * establece la referencia al siguiente nodo en la lista circular
     * 
     * @param siguiente el nodo que sigue en la lista
     */
    public void setSiguiente (NodoLista siguiente){
        this.siguiente = siguiente;
    } 
    
     /**
     * obtiene la referencia al siguiente nodo en la lista
     * 
     * @return siguiente nodo en la lista, o null si no hay ninguno
     */
    public NodoLista getSiguiente(){
        return siguiente;
    }
}
