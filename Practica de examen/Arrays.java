import java.util.Random;
public class Arrays
{
    private static int [] array;
    private static Random random = new Random();
    public Arrays( int [] numeros ){
        this.array = numeros;
    }
    
    public void setArray( int [] array ){
        this.array = array;
    }
    
    public void imprimir(){
        for(int i = 0 ; i < this.array.length; i++){
            System.out.print(array[i]);
            if (i < array.length -1)System.out.print(",");
        }
        System.out.println();
    }
    
    public void cambiar(){
        Random numR = new Random();
         for(int i = 0 ; i < this.array.length; i++){
            this.array[i] = numR.nextInt(11);
        }
        this.imprimir();
    }
    
    public void ordenamiento(){
        int posicionM;
        int valorM = 0;
        for(int i = 0 ; i < this.array.length; i++){
            posicionM = i;
            valorM = array[i];
            for (int j = i + 1; j < this.array.length; j++){
                if(valorM > array[j]){
                    posicionM = j;
                    valorM = array[j];
                }
                
                if (posicionM != i){
                    int temp = array[j];
                    array [j]= array[posicionM];
                    array[posicionM]= temp;
                }
            }
        }
        System.out.println(" el valor menor ingresado en el array es: "+ valorM);
    }

}