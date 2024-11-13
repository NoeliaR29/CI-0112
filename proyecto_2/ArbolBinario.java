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

   
    
    public void setRaiz(Nodo raiz){
            this.raiz = raiz;
    }

    public Nodo getRaiz(){
        return raiz;
    }
}
