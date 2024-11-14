public class Nodo {
    private Nodo izquierdo;   
    private Nodo derecho;
    private int valor;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    //setters  y getters

    public void setIzquierdo(Nodo izquierdo){
        this.izquierdo = izquierdo;
        }

    public void setDerecho(Nodo derecho){
    this.derecho = derecho;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public Nodo getIzquierdo(){
        return izquierdo;
    }

    public Nodo getDerecho(){
        return derecho;
    }

    public int getValor(){
        return valor;
    }
}
