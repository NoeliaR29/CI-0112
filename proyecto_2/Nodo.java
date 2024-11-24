public class Nodo {
    /**
     * Atributos de la clase nodo
    */
    private Nodo izquierdo;   
    private Nodo derecho;
    private int valor;
     
    /**
     * Constructor de la clase Nodo
     * 
     * @param valor valor que va a tener el nodo
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    /**
     * Establece el nodo hijo izquierdo
     * 
     * @param izquierdo nodo que será el hijo izquierdo
     */
    public void setIzquierdo(Nodo izquierdo){
        this.izquierdo = izquierdo;
    }

    /**
     * Establece el nodo hijo derecho
     * 
     * @param derecho nodo que será el hijo derecho
     */
    public void setDerecho(Nodo derecho){
        this.derecho = derecho;
    }
    
    /**
     * Establece el valor del nodo
     * 
     * @param valor valor que se le asigna a un nodo
     */
    public void setValor(int valor){
        this.valor = valor;
    }
    
    /**
     * Obtiene el nodo hijo izquierdo
     * 
     * @param izquierdo nodo que está como hijo izquierdo
     */
        public Nodo getIzquierdo(){
            return izquierdo;
        }

    /**
     * Obtiene el nodo hijo derecho
     * 
     * @param izquierdo nodo que está como hijo derecho
     */
        public Nodo getDerecho(){
            return derecho;
        }

    /**
     * Obtiene el valor del nodo
     * 
     * @param izquierdo valor almacenado en el nodo
     */
        public int getValor(){
            return valor;
        }
}