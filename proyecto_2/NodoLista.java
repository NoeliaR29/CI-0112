
public class NodoLista{
    private String dato;
    private NodoLista siguiente;
    
    public NodoLista(String dato){
        this.dato= dato; // ver si cambiar por = dato
        this.siguiente = null;
    }
    // setters y getters
    
    public void setDato (String dato){
        this.dato = dato;
    } 
    
    public String getDato(){
        return dato;
    }
    
    public void setSiguiente (NodoLista siguiente){
        this.siguiente = siguiente;
    } 
    
    public NodoLista getSiguiente(){
        return siguiente;
    }
}
