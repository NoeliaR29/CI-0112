public class NodoListaDoblemente {
    private int dato;
    Nodo nodoAnterior;
    Nodo nodoSiguiente;

    //Constructor
    public NodoListaDoblemente(){
        this.dato = dato;
        this.nodoAnterior = null;
        this.nodoSiguiente = null;
    }

    //Setters y getters
    public void setDato(int dato){
        this.dato = dato;
    }
    public int getDato(){
        return this.dato;
    }

    public void setNodoAnterior(Nodo nodoAnterior){
        this.nodoAnterior = nodoAnterior;
    }
    public Nodo getNodoAnterior(){
        return this.nodoAnterior;
    }
    
    public void setNodoSiguiente(Nodo nodoSiguiente){
        this.nodoSiguiente = nodoSiguiente;
    }
    public Nodo getNodoSiguiente(){
        return this.nodoSiguiente;
    }
}
