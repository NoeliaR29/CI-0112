public class NodoListaDoblemente {
    private int dato;
    private NodoListaDoblemente nodoAnterior;
    private NodoListaDoblemente nodoSiguiente;

    //Constructor
    public NodoListaDoblemente(int dato){
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

    public void setNodoAnterior(NodoListaDoblemente nodoAnterior){
        this.nodoAnterior = nodoAnterior;
    }
    public NodoListaDoblemente getNodoAnterior(){
        return this.nodoAnterior;
    }

    public void setNodoSiguiente(NodoListaDoblemente nodoSiguiente){
        this.nodoSiguiente = nodoSiguiente;
    }
    public NodoListaDoblemente getNodoSiguiente(){
        return this.nodoSiguiente;
    }
}
