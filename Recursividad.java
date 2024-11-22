public class Recursividad {
    
    public static int sumarDigitosRec(int numero){
        if (numero == 0){
            return numero;
        }else{
            
           return numero % 10 + sumarDigitosRec( numero / 10 );
        }
    }
    public static int potenciaRec(int x , int y){
        if(y == 0){
            return 1;
        }else{
            return x * potenciaRec(x, y-1);
        }   
    }

    public static String invertirCadena(String cadena){
        if(cadena.isEmpty()){
            return cadena;
    }else{
        return invertirCadena(cadena.substring(1)) + cadena.charAt(0);

    }
}

    public static void main (String[] args){ 
        System.out.println(sumarDigitosRec(123));
        System.out.println(potenciaRec(2,3));
        System.out.println(invertirCadena("casa"));
    }
}