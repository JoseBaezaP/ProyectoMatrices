package Modelo;

public class OperacionesBasicasMatrices {
    
    
    public double[][] suma(double[][] matriz_uno, double [][] matriz_dos){
        double [][]suma;
        
        suma = new double[matriz_uno.length][matriz_uno.length];
        
        //Suma de las matrices posicion por poscicion
        for(int filasCounter=0;filasCounter<matriz_uno.length;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<matriz_uno.length;columnasCounter++) {
                suma[filasCounter][columnasCounter] = matriz_uno[filasCounter][columnasCounter] + matriz_dos[filasCounter][columnasCounter];    
            }
        }
        return suma;
    }
    
    public double [][] multiplicacion(double [][] matriz_uno, double [][] matriz_dos){
        int filaUno = matriz_uno.length;
        int filaDos = matriz_dos.length;
        int columnaUno = matriz_uno[0].length;
        int columnaDos = matriz_dos[0].length;
        double [][] mult;
        mult = new double[filaUno][columnaDos];

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
    
    public double [][] multEscalar(double [][] matriz, double escalar){

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
    
    
    //******************************************Calcular determinante*************************************************
    public double calcularDeterminante (double[][] matriz){
        double determinante = 0;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        if ((filas == 1) && (columnas == 1)){
            return matriz[0][0];
        }
        
        int signo = 1;
        for (int columna = 0; columna < columnas; columna++) {
            double[][] submatriz = getSubmatriz(matriz, filas, columnas, columna);
            determinante = determinante + signo*matriz[0][columna]*calcularDeterminante(submatriz);
            signo *= -1;
        }
        return determinante;
    }
    
    public static double[][] getSubmatriz(double[][] matriz, int filas, int columnas, int columna) {
        double [][] submatriz = new double[filas-1][columnas-1];
        int contador = 0;
        for (int j = 0;j < columnas;j++) {
            if (j == columna) continue;
            for (int i = 1; i < filas; i++){
                submatriz[i-1][contador]=matriz[i][j];
            }       
            contador++;
        }
        return submatriz;
    }
    //**************************************************************************************************************
}
