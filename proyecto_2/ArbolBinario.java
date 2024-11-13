public class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario() {
        raiz = null;  
    }
    // necesita insercióm, busqueda, eliminación

    //metodo para insertar nodos
    public void agregarNodo(Nodo nodo) {
        this.agregarNodo2(this.raiz,nodo);
            }
    
    public Nodo agregarNodo2(Nodo nodo, Nodo raiz) {
        if (raiz == null) {
            this.setRaiz(nodo); 
        } else {
            if (nodo.getValor() <= raiz.getValor()) {
                
                if (raiz.getIzquierdo() == null) {
                    raiz.setIzquierdo(nodo); 
                } else {
                    agregarNodo2(nodo, raiz.getIzquierdo()); 
                }
            } else {
            
                if (raiz.getDerecho() == null) {
                    raiz.setDerecho(nodo); 
                } else {
                    agregarNodo2(nodo, raiz.getDerecho()); 
                }
            }
        }
        return raiz;
    }
   

    public void setRaiz(Nodo raiz){
            this.raiz = raiz;
    }

    public Nodo getRaiz(){
        return raiz;
    }
}
