public class ArbolBinario {
    private Nodo raiz;
     /** 
     * Constructor del árbol
     * Se le da el valor null al árbol
     */
    public ArbolBinario() {
        raiz = null;  
    }
    /**
     * Agrega un nodo al árbol binario llamando al método recursivo
     * @param nodo es el que el usuario desea agregar al árbol
     */
    public void agregarNodo(Nodo nodo) {
        this.raiz = this.agregarNodoRec(this.raiz,nodo);
            }
    
     /**
     * Método recursivo que agrega un nodo al árbol segun su valor
     * 
     * @param raiz  raiz del subarbol en el que se debe insertar el nuevo nodo
     * @param nodo nodo que se desea agregar
     * @return retorna el valor de la raiz
     */
    public Nodo agregarNodoRec(Nodo raiz, Nodo nodo) {
        if (raiz == null) {
            this.setRaiz(nodo);
            return nodo; 
        }
        if (nodo.getValor() == raiz.getValor()) {
            throw new IllegalArgumentException("El valor " + nodo.getValor() + " ya está en el árbol.");
        }else {
            if (nodo.getValor() < raiz.getValor()) {
                    raiz.setIzquierdo(agregarNodoRec(raiz.getIzquierdo(), nodo));
                }
             else {
                    raiz.setDerecho(agregarNodoRec(raiz.getDerecho(), nodo));
                }
            }
            return raiz;
        }
    
    /**
     * Busca un nodo con el valor especificado en el árbol
     * @param valor valor que se desea buscar
     * @return true si el valor existe en el árbol, false en caso contrario
     */
    public boolean encontrarNodo(int valor) {
        return buscarNodoRec(this.raiz, valor);
    }
    
     /**
     * Método recursivo para buscar un nodo en el árbol
     * @param raiz raíz del subárbol donde se realizará la búsqueda
     * @param valor valor que se desea buscar
     * @return true si el nodo se encuentra, sino, false
     */
    public boolean buscarNodoRec(Nodo raiz, int valor){
        if(raiz == null){
            return false;
        }
            if(raiz.getValor() == valor){
                return true;
            }
                if(raiz.getValor() < valor){
                    return buscarNodoRec(raiz.getDerecho(), valor);
                }else{
                    return buscarNodoRec(raiz.getIzquierdo(), valor);
                }
    }

    /**
     * Elimina un nodo específico del arbol
     * 
     * @param valor valor del nodo que se desea eliminar
     */
    public void eliminarNodo(int valor) {
        raiz = eliminarNodoRec(raiz, valor);
        }

    /**
     * Método recursivo que elimina el nodo que el usuario desea
     * 
     * @param raiz nodo raíz del subárbol donde se buscará el nodo a eliminar
     * @param valor valor del nodo que se desea eliminar.
     * @return devuelve el nodo raíz del subárbol después de la eliminación
     */
    private Nodo eliminarNodoRec(Nodo raiz, int valor){
        if (raiz == null) {
            return raiz;
        }
        if(raiz.getValor()< valor){
            raiz.setDerecho(eliminarNodoRec(raiz.getDerecho(), valor));
            }else if(raiz.getValor()> valor){
                raiz.setIzquierdo(eliminarNodoRec(raiz.getIzquierdo(), valor));
                }else{
                    raiz = eliminarPorTipoNodo(raiz);
                }
        return raiz;
    }

    /**
     * Elimina un nodo según su tipo: si tiene 0, 1 o 2 hijos
     * 
     * @param raiz nodo que se desea eliminar
     * @return devuelve el nodo raíz del subárbol modificado
     */
    private Nodo eliminarPorTipoNodo(Nodo raiz) {
        if (raiz.getIzquierdo() == null && raiz.getDerecho() == null) {
            return null; 
        }
        if (raiz.getIzquierdo() == null) {
            return raiz.getDerecho(); 
        }
        if (raiz.getDerecho() == null) {
            return raiz.getIzquierdo(); 
        }
        Nodo sucesor = encontrarMinimo(raiz.getDerecho());
        raiz.setValor(sucesor.getValor()); 
        raiz.setDerecho(eliminarNodoRec(raiz.getDerecho(), sucesor.getValor())); 
        return raiz;
    }

    /**
     * Encuentra el nodo con el valor mínimo en la parte del árbol analizada en el momento por el método recursivo
     * 
     * @param nodo nodo raíz del subárbol donde se buscará el nodo con el valor mínimo
     * @return El nodo con el valor mínimo en esa parte
     */
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
    
    /**
     * Asigna un nuevo nodo raíz al árbol
     * 
     * @param raiz El nodo raíz que se desea establecer
     */
    public void setRaiz(Nodo raiz){
            this.raiz = raiz;
    }

    /**
     * retorna el valor que posee la variable raiz
     * 
     * @param raiz valor del nodo
     */
    public Nodo getRaiz(){
        return raiz;
    }
}
