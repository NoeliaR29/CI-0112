public class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario() {
        raiz = null;  
    }
    // necesita insercióm, busqueda, eliminación

    //metodo para insertar nodos en el árbol
    public void agregarNodo(Nodo nodo) {
        this.agregarNodoRec(this.raiz,nodo);
            }
    
    public Nodo agregarNodoRec(Nodo raiz, Nodo nodo) {
        if (nodo == null) {          
        return raiz;
        }
        if (raiz == null) {
            this.setRaiz(nodo);
            return nodo; 
        } else {
            if (nodo.getValor() <= raiz.getValor()) {
                
                if (raiz.getIzquierdo() == null) {
                    raiz.setIzquierdo(nodo);  
                } else {
                    raiz.setIzquierdo(agregarNodoRec(raiz.getIzquierdo(), nodo));
                }
            } else {
                if (raiz.getDerecho() == null) {
                    raiz.setDerecho(nodo); 
                } else {
                    raiz.setDerecho(agregarNodoRec(raiz.getDerecho(), nodo));
                }
            }
        }
        return raiz;
    }
    //método para buscar un nodo en el arbol
    public boolean encontrarNodo(int valor) {
        return buscarNodoRec(this.raiz, valor);
    }
    
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
    //método para eliminar nodos
    public void eliminarNodo(int valor) {
        raiz = eliminarNodoRec(raiz, valor);
        }
    //usa la recursividad para encontrar el nodo que quierer eliminar
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
    //método que distribuye cada tipo de eliminación para que el método recursivo no quede tan grande
    private Nodo eliminarPorTipoNodo(Nodo raiz){
        if (raiz.getIzquierdo() == null && raiz.getDerecho() == null) {
            return null;
            }else if(raiz.getIzquierdo() == null || raiz.getDerecho() == null){
            return nodoUnHijo(raiz);
                }else{
                    return nodoDosHijos(raiz);
                }
            }
    //metodo de eliminacion de un nodo que tiene solo un hijo
    private Nodo nodoUnHijo(Nodo nodo) {
        if (nodo.getIzquierdo() != null) {
            return nodo.getIzquierdo();  
        } else {
            return nodo.getDerecho();  
        }
    }
    //metodo de eliminación de un nodo con dos hijos
    private Nodo nodoDosHijos(Nodo raiz) {
        Nodo sucesor = encontrarMinimo(raiz.getDerecho());
        raiz.setValor(sucesor.getValor());
        raiz.setDerecho(eliminarNodoRec(raiz.getDerecho(), sucesor.getValor()));
        return raiz;
    }

    //metodo para ir al minimo del arbol, para el nodo con dos hijos
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
    //set y get
    public void setRaiz(Nodo raiz){
            this.raiz = raiz;
    }

    public Nodo getRaiz(){
        return raiz;
    }
}
