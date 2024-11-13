
public class ListaCircular{
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    
    public void insertarDato(String dato){
        Nodo nuevoDato = new Nodo();
        System.out.print("dato a ingresar a la lista"); // cambiar el texto
        
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
    
    public void eliminarDato(String dato){
    
    }
    
    public void buscarDato(String dato){
    
    }
}
