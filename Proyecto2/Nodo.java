
public class Nodo{
    private String dato;
    private Nodo siguiente;
    
    public void Nodo(){
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
    
    public void setSiguiente (Nodo siguiente){
        this.siguiente = siguiente;
    } 
    
    public Nodo getSiguiente(){
        return siguiente;
    }
}
