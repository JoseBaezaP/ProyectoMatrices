package Modelo;
import javax.swing.JOptionPane;

/**
 *
 * @author josebaeza
 */
public class OperacionesBasicasMatrices {
    
    /**
     *
     * @param matrizA
     * @param matrizB
     * @return
     */
    public double[][] suma(double[][] matrizA, double [][] matrizB){
        double [][]suma;
        int tamanio = matrizA.length;
        suma = new double[tamanio][tamanio];
        
        //Suma de las matrices posicion por poscicion
        for(int i=0;i<tamanio;i++) {
            for(int j=0;j<tamanio;j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];    
            }
        }
        return suma;
    }
    
    /**
     *
     * @param matrizA
     * @param matrizB
     * @return
     */
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
    
    /**
     *
     * @param matriz
     * @param escalar
     * @return
     */
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

    /**
     *
     * @param matriz
     * @return
     */
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
    
    /**
     *
     * @param matriz
     * @param filas
     * @param columnas
     * @param columna
     * @return
     */
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

    /**
     *
     * @param matrizA
     * @return
     */
    public double[][] metodoDeCramer(double [][] matrizA) {
        double[][] matrizDeEcuaciones= new double[matrizA.length][matrizA.length];
        matrizDeEcuaciones=generarMatrizEcuaciones(matrizA);    
        double[][] Rcramer= new double[1][matrizA.length];    
        double det = calcularDeterminante(matrizDeEcuaciones);

            if (det == 0) {
                    JOptionPane.showMessageDialog(null,"No tiene solucion con" +
                            " la regla de Cramer");
                 return Rcramer;
            }
              double[] vectorDeSoluciones=new double[matrizA.length];
            vectorDeSoluciones=generarVectorSoluciones(matrizA);

            double detDelCoeficiente;

            double matrizCoeficiente[][] = new double[matrizA.length][matrizA.length];
            for (int i = 0; i < matrizA.length; i++) {
                    matrizCoeficiente = sustituye(matrizDeEcuaciones,vectorDeSoluciones,i);
                    detDelCoeficiente = calcularDeterminante(matrizCoeficiente);
                    Rcramer[0][i]=(detDelCoeficiente/det);
            }
            return Rcramer;
            
          
    }

    /**
     *
     * @param matrizDeEcuaciones
     * @param vectorDeSoluciones
     * @param pos
     * @return
     */
    public double [][] sustituye(double matrizDeEcuaciones[][], double vectorDeSoluciones[], int pos) {
            double matrizCoeficiente[][] = new double[matrizDeEcuaciones.length][matrizDeEcuaciones.length];
            for (int i = 0; i < matrizDeEcuaciones.length; i++) {
                    for(int j=0; j<matrizDeEcuaciones.length; j++){
                            if(j == pos){
                                    matrizCoeficiente[i][j] = vectorDeSoluciones[i];
                            }
                            else{
                                    matrizCoeficiente[i][j] = matrizDeEcuaciones[i][j];
                            }
                    }
            }
            return matrizCoeficiente;
    }

    /**
     *
     * @param matriz
     * @return
     */
    public static double[][] generarMatrizEcuaciones(double[][] matriz){
        int fila=matriz.length;
        int columna=matriz[0].length;
        double[][] matrizDeEcuaciones= new double[matriz.length][matriz.length];
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna-1;j++){
                matrizDeEcuaciones[i][j]=matriz[i][j];
            }
        }
        
        return matrizDeEcuaciones;
    }

    /**
     *
     * @param matriz
     * @return
     */
    public static double[] generarVectorSoluciones(double[][] matriz){
        int fila=matriz.length;
        int columna=matriz.length;
        double[] vectorDeSoluciones= new double[matriz.length];
        for(int i=0;i<fila;i++){
            vectorDeSoluciones[i]=matriz[i][columna];
        }
        
        return vectorDeSoluciones;
    }
}
