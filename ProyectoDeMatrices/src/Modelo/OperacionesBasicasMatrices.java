package Modelo;

public class OperacionesBasicasMatrices {
    
    
    public double[][] suma(double[][] matrizA, double [][] matrizB){
        double [][]suma;
        int tamanio = matrizA.length;
        suma = new double[tamanio][tamanio];
        
        //Suma de las matrices posicion por poscicion
        for(int i=0;i<matrizA.length;i++) {
            for(int j=0;j<matrizA.length;j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];    
            }
        }
        return suma;
    }
    
    public double [][] multiplicacion(double [][] matrizA, double [][] matrizB){
        int filaA = matrizA.length;
        int filaB = matrizB.length;
        int columnaA = matrizA[0].length;
        int columnaB = matrizB[0].length;
        double [][] mult;
        mult = new double[filaA][columnaB];

        //inicializa la matriz para la multiplicación 
        for(int i=0;i<filaB;i++) {
            for(int j=0;j<columnaB;j++) { 
                mult[i][j] = 0;
            }
        }

        //Realiza la multiplicacion 
         for (int i = 0; i < filaA; i++) { // fila uno
            for (int j = 0; j < columnaB; j++) { // columna dos
                for (int k = 0; k < columnaA; k++) { // columna uno      
                    mult[i][j] += matrizA[i][k] * matrizB[k][j]; 
                }
            }
        }

        return mult;
         
    }
    
    public double [][] multEscalar(double [][] matriz, double escalar){

        int filas = matriz.length;
        int columnas = matriz[0].length;
        

        //Multiplica la matriz por el escalar
        for(int i=0;i<filas;i++) {
            for(int j=0;j<columnas;j++) {
                matriz[i][j] = escalar*matriz[i][j];    
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
