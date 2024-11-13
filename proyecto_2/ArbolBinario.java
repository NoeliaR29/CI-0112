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
    
    public Nodo agregarNodo2(Nodo raiz ,Nodo nodo) {
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
                    raiz.setIzquierdo(agregarNodo2(raiz.getIzquierdo(), nodo));
                }
            } else {
            
                if (raiz.getDerecho() == null) {
                    raiz.setDerecho(nodo); 
                } else {
                    raiz.setDerecho(agregarNodo2(raiz.getDerecho(), nodo));
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
