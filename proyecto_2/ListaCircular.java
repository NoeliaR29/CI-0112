public class ListaCircular{
    private NodoLista primerNodo;
    private NodoLista ultimoNodo;

    /**
    * constructor de la clase ListaCircular.
    * inicializa la lista vacía
    */
    public ListaCircular(){
        this.primerNodo = null;
        this.ultimoNodo = null; 
    }
    
    // setters y getters


     /**
     * establece un nuevo valor para el dato del primer nodo
     * 
     * @param primerNodo que será el primero nodo de la lista
     */
    public void setPrimerNodo(NodoLista primerNodo){
        this.primerNodo = primerNodo;
    }

     /**
     * obtiene el nodo que es actualmente el primer nodo de la lista circular
     * 
     * @return el primer nodo en la lista circular
     */
    public NodoLista getPrimerNodo(){
        return primerNodo;
    }
    
    /**
     * establece un valor para el último nodo de la lista 
     * 
     * @param ultimoNodo node que será el último nodo de la lista
     */
    public void setUltimoNodo(NodoLista ultimoNodo){
        this.ultimoNodo = ultimoNodo;
    }

    /**
     * obtiene el nodo que es actualmente el último nodo en la lista circular
     * 
     * @return el último nodo de la lista circular
     */
    public NodoLista getUltimoNodo(){
        return ultimoNodo;
    }

    /**
     * método para insertar un dato en la lista circular
     * 
     * @param dato es el dato ingresado por el usuario que se desea insertar en la lista
     */
    public void insertarDato(String dato){
        NodoLista nuevoDato = new NodoLista(dato);
        System.out.print("Digite el dato que desea ingresar a la lista"); 
        
        if (primerNodo == null){ // si la lista no tiene nada
            primerNodo = nuevoDato; //tanto el primero como ultimo dato, es el mismo (el nuevo)
            ultimoNodo = nuevoDato;
            ultimoNodo.setSiguiente(primerNodo);  // el ultimo apunta al primero
            
        }else{
            ultimoNodo.setSiguiente(nuevoDato);
            nuevoDato.setSiguiente(primerNodo); //el nuevo apunta al sigueinte, que seria el primero
            ultimoNodo = nuevoDato; //actualizar el ultimo elemento
        }
    
    }
    
     
     /**
     * métod para eliminar un dato de la lista circular
     * 
     * @param dato es el dato que el usuario quiera eliminar de la lista
     */
    public void eliminarDato(String dato){
        if (primerNodo == null){ // si la lista no tiene nada no se elimina nada
            System.out.print("la lista no tiene elementos");
            return;
        }
        
        NodoLista elementoActual = primerNodo; // variable elemento actual para usar ese para recorrer la lista 
        NodoLista anterior = ultimoNodo; // variable anterior; el anterior al primero, es el último  
        
        //ciclo que recorra la lista 
        /* se toman en cuenta tres posibilidades: 
           que se elimine el primero
           que se elimine el último
           que se elimine algo que esté en "el medio"
           Esto se hace así para tener una mejor separación y orden*/
           
        do{ //uso de do while para que se ejecute todo hasta el final
            if(elementoActual.getDato().equals(dato)){ //se compara el dato del usuario con el actual
                if (elementoActual == primerNodo){ // si el que se va a borrar es el primer nodo
                    if (primerNodo == ultimoNodo){
                        
                        // tomar en cuenta si solo hay un elemento en todo la lista, se vacía toda
                        primerNodo = null;
                        ultimoNodo = null; 
                    }else{ 
                        primerNodo = primerNodo.getSiguiente(); // el siguiente se convierte en el primero
                        ultimoNodo.setSiguiente(primerNodo); // actualiza a quien apunta el último
                    }    
                
                }else if (elementoActual == ultimoNodo){ //si el que se va a borrar es el último en la lista
                    anterior.setSiguiente(primerNodo); /* el que estaba antes del ultimo, ahora apunta al pirmero 
                    (porque es el nuevo último)*/
                    ultimoNodo = anterior; // actualiza el último nodo

                
                }else{ // si el elemento a borrar está en el medio
                    anterior.setSiguiente(elementoActual.getSiguiente()); // se brinca el nodo que se va  borrar
                    
                }
                
                System.out.print("El elemento:"+ dato + "se ha borrado"); 
                return; 
            }
            
            anterior = elementoActual; // al seguir el nodo actual pasa a ser el anterior
            elementoActual = elementoActual.getSiguiente(); // devuelve el nodo que apunta el actual
        
        }while (elementoActual != primerNodo); 
        // se recorre la lista hasta que se llegue de nuevo al primero
        
        // si no se encuentra el dato ingresado, se le muestra mensaje a usuario
        System.out.println("El elemento ingresado(" + dato + ")no está en la lista");
    }
        

     /**
     * método para buscar un dato en la lista 
     * 
     * @param dato el dato que se quire buscar en la lista
     * @return true si el dato se encuentra en la lista y false si no
     */
    public boolean buscarDato(String dato){
        if(primerNodo == null){ //considerar si la lista está vacía
            System.out.print("Aún no hay elementos en la lista");
            return false;
        }
        
        NodoLista elementoActual = primerNodo; // variable elementoActual que apunte al primer nodo para ir recorriendo la lista
        
        do{
            if (elementoActual.getDato().equals(dato)){ // cuadno el elementoActual, que es el que recorre la lista, sea igual al dato del usuario se muestramensaje indicando que está en la lista
                System.out.println("El elemento" + dato + "se encuentra en la lista");
                return true ;
            }
            elementoActual = elementoActual.getSiguiente();// se pasa al nodo que sigue
        }while(elementoActual != primerNodo); // se sigue hasta recorrer toda la lista y llega al inicio (al primer nodo);
        
        //si se recorre todala lista y no se encuentra el dato se muestra un mensaje al usuario
        System.out.println( dato + "no se encuentra en la lista");
        return false;            
    }
    
    /**
     * Método para obtener la cantidad de nodos en la lista circular para mejorar la interfza
     * 
     * @return cantidad de nodos en la lista
     */
    public int getCantidadNodos(){
        if(primerNodo == null){ // tomar en cuenta la lista sin ningun elemneto 
            return 0;
        }

        int contador = 0;
        NodoLista actual = primerNodo;

        do{
            contador++;
            actual = actual.getSiguiente();
        }while(actual != primerNodo);

        return contador;
    }
}