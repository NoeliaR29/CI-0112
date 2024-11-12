public class Nodo {
    private Nodo izquierdo;   
    private Nodo derecho;
    private int contiene;

    public Nodo(int contiene) {
        this.contiene = contiene;
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

    public void setContiene(int contiene){
        this.contiene = contiene;
    }

    public Nodo getIzquierdo(){
        return izquierdo;
    }

    public Nodo getderecho(){
        return derecho;
    }

    public int getContiene(){
        return contiene;
    }
}
