import java.util.Random;
import java.util.Scanner;
public class Arrays
{
    Scanner ent = new Scanner(System.in);
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
        for(int i = 0 ; i < this.array.length; i++){
            int posicionM = i;
            int valorM = array[i];
            for (int j = i + 1; j < this.array.length; j++){
                if(valorM > array[j]){
                    posicionM = j;
                    valorM = array[j];
                }
            }
            
            if (posicionM != i){
                    int temp = array[i];
                    array [i]= array[posicionM];
                    array[posicionM]= temp;
                }
        }
        this.imprimir();
    }
    
    public void busquedaSecuencial(int parametro){
        for( int i = 0;i < this.array.length; i++){
            if (parametro == array[i]){
                System.out.println ("el parámetro ingresado está en la posición: "+ i);
            }
        }
    }
    
    public void pareseImpares (){
        int cantImpa = 0;
        int cantPa = 0;
        for( int i = 0;i < this.array.length; i++){
            if (array[i] % 2 == 0){
                cantPa++;
            }else{
                cantImpa++;
            }
        }
        System.out.println ("la cantidad de números pares es: "+ cantPa);
        System.out.println ("la cantidad de números impares es: "+ cantImpa);
        
    }
    
    public void resta(){
        int vMayor = array[0];
        int vMenor = array[0];
        for( int i = 0;i < this.array.length; i++){
            if (array[i] < vMenor){
                vMenor = array[i];
            }
            if (array[i]> vMayor){
                vMayor = array[i];
            }
        }
        System.out.println (vMayor);
        System.out.println (vMenor);
        int resta = vMayor - vMenor;
        System.out.println ("la resta de los números menores y mayores es: "+ resta);
    }
}