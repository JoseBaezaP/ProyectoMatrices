package Modelo;

public class OperacionesBasicasMatrices {
    
    
    public int[][] suma(int[][] matriz_uno, int [][] matriz_dos){
        
        int [][]suma;
        

        suma = new int[matriz_uno.length][matriz_uno.length];
        
        //Suma de las matrices posicion por poscicion
        for(int filasCounter=0;filasCounter<matriz_uno.length;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<matriz_uno.length;columnasCounter++) {
                suma[filasCounter][columnasCounter] = matriz_uno[filasCounter][columnasCounter] + matriz_dos[filasCounter][columnasCounter];    
            }
        }
        return suma;
    }
    
    public int [][] multiplicacion(int [][] matriz_uno, int [][] matriz_dos){
        int filaUno = matriz_uno.length;
        int filaDos = matriz_dos.length;
        int columnaUno = matriz_uno[0].length;
        int columnaDos = matriz_dos[0].length;
        int [][] mult;
        mult = new int[filaUno][columnaDos];

       //Valida si se puede realizar la operacion
        if(columnaUno == filaDos){

        //inicializa la matriz para la multiplicación 
        for(int filasCounter=0;filasCounter<filaDos;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnaDos;columnasCounter++) { 
                mult[filasCounter][columnasCounter] = 0;
            }
        }

        //Realiza la multiplicacion 
         for (int filasCounter = 0; filasCounter < filaUno; filasCounter++) { // fila uno
            for (int columnasCounter = 0; columnasCounter < columnaDos; columnasCounter++) { // columna dos
                for (int k = 0; k < columnaUno; k++) { // columna uno      
                    mult[filasCounter][columnasCounter] += matriz_uno[filasCounter][k] * matriz_dos[k][columnasCounter]; 
                }
            }
        }

        return mult;
         
        }else{
        System.out.println("No se puede :v");
        return null;
        }
    }
    
    public int [][] multEscalar(int [][] matriz, int escalar){

        int filas = matriz.length;
        int columnas = matriz[0].length;
        

        //Multiplica la matriz por el escalar
        for(int filasCounter=0;filasCounter<filas;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnas;columnasCounter++) {
                matriz[filasCounter][columnasCounter] = escalar*matriz[filasCounter][columnasCounter];    
            }
        }

        return matriz;
    }
    
        

    
}
