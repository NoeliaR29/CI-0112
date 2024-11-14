public class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario() {
        raiz = null;  
    }
    // necesita insercióm, busqueda, eliminación

    //metodo para insertar nodos
    public void agregarNodo(Nodo nodo) {
        this.agregarNodoRec(this.raiz,nodo);
            }
    
    public Nodo agregarNodoRec(Nodo raiz ,Nodo nodo) {
        if (nodo ==null){
            System.out.println("El nodo que deseas insertar está vacio.");
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
    public void encontrarNodo(int valor){
        if (buscarNodoRec(this.raiz,valor)== true){
            System.out.println("el nodo se encuentra en el árbol.");
        }else{
            System.out.println("el nodo no se encuentra en el árbol.");
        }
    }
    
    private boolean buscarNodoRec(Nodo raiz, int valor){
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

    private Nodo nodoUnHijo(Nodo nodo) {
        if (nodo.getIzquierdo() != null) {
            return nodo.getIzquierdo();  
        } else {
            return nodo.getDerecho();  
        }
    }

    private Nodo nodoDosHijos(Nodo raiz) {
        Nodo sucesor = encontrarMinimo(raiz.getDerecho());
        raiz.setValor(sucesor.getValor());
        raiz.setDerecho(eliminarNodoRec(raiz.getDerecho(), sucesor.getValor()));
        return raiz;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    public void setRaiz(Nodo raiz){
            this.raiz = raiz;
    }

    public Nodo getRaiz(){
        return raiz;
    }
}
