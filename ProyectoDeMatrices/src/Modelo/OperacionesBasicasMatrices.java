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
        int filasA = matrizA.length;
        int filasB = matrizB.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        double [][] matrizResultado;
        matrizResultado = new double[filasA][columnasB];

        //inicializa la matriz para la multiplicación 
        for(int i=0;i<filasB;i++) {
            for(int j=0;j<columnasB;j++) { 
                matrizResultado[i][j] = 0;
            }
        }

        //Realiza la multiplicacion 
         for (int i = 0; i < filasA; i++) { // tamanio uno
            for (int j = 0; j < columnasB; j++) { // i dos
                for (int k = 0; k < columnasA; k++) { // i uno      
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j]; 
                }
            }
        }
        return matrizResultado;
    }
    
    /**
     *
     * @param matriz
     * @param escalar
     * @return
     */
    public double [][] multiplicacionEscalar(double [][] matriz, double escalar){

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double [][] matrizResultado = matriz;

        //Multiplica la matriz por el escalar
        for(int i=0;i<filas;i++) {
            for(int j=0;j<columnas;j++) {
                matrizResultado[i][j] = escalar*matrizResultado[i][j];    
            }
        }
        return matrizResultado;
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
        for (int i = 0; i < columnas; i++) {
            double[][] submatriz = getSubmatriz(matriz, filas, columnas, i);
            determinante = determinante + signo*matriz[0][i]*calcularDeterminante(submatriz);
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
        int tamanio = matrizA.length;
        double[][] matrizDeEcuaciones = new double[tamanio][tamanio];
        matrizDeEcuaciones = generarMatrizEcuaciones(matrizA);    
        double[][] Rcramer = new double[1][tamanio];    
        double determinante = calcularDeterminante(matrizDeEcuaciones);

        if (determinante == 0) {
            JOptionPane.showMessageDialog(null,"No tiene solucion con la regla de Cramer");
            return Rcramer;
        }
        double[] vectorDeSoluciones = new double[tamanio];
        vectorDeSoluciones = generarVectorSoluciones(matrizA);

        double detDelCoeficiente;

        double matrizCoeficiente[][] = new double[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            matrizCoeficiente = sustituye(matrizDeEcuaciones,vectorDeSoluciones,i);
            detDelCoeficiente = calcularDeterminante(matrizCoeficiente);
            Rcramer[0][i]=(detDelCoeficiente/determinante);
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
            for(int j = 0; j < matrizDeEcuaciones.length; j++){
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
        int tamanio = matriz.length;
        int columnas = matriz[0].length;
        double[][] matrizDeEcuaciones = new double[tamanio][tamanio];
        for(int i=0;i < tamanio; i++){
            for(int j = 0; j < columnas-1; j++){
                matrizDeEcuaciones[i][j] = matriz[i][j];
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
        int tamanio = matriz.length;
        double[] vectorDeSoluciones = new double[tamanio];
        
        for(int i = 0; i < tamanio; i++){
            vectorDeSoluciones[i] = matriz[i][tamanio];
        }
        return vectorDeSoluciones;
    }
    
    //***********************************************Metodo Gauss-Jordan*************************************************

    public double[][] inversaGaussJordan(double matriz[][]){
        int tamanio = matriz.length;
        double matrizResultado[][] = new double[tamanio][tamanio];
        double matrizAuxiliar[][] = new double[tamanio][tamanio];
        int[] indice = new int[tamanio];
        for (int i = 0; i < tamanio; ++i){
            matrizAuxiliar[i][i] = 1;
        }


 // Transform the matrix into an upper triangle

        pivotar(matriz, indice);

 // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < tamanio-1; ++i){
            for (int j = i+1; j < tamanio; ++j){
                for (int k = 0; k < tamanio; ++k){
                    matrizAuxiliar[indice[j]][k] -= matriz[indice[j]][i]*matrizAuxiliar[indice[i]][k];
                }
            }
        }

 // Perform backward substitutions
        for (int i = 0; i < tamanio; ++i) {
            matrizResultado[tamanio-1][i] = matrizAuxiliar[indice[tamanio-1]][i]/matriz[indice[tamanio-1]][tamanio-1];
            for (int j = tamanio-2; j >= 0; --j) {
                matrizResultado[j][i] = matrizAuxiliar[indice[j]][i];
                for (int k = j+1; k < tamanio; ++k){
                    matrizResultado[j][i] -= matriz[indice[j]][k]*matrizResultado[k][i];
                }
                matrizResultado[j][i] /= matriz[indice[j]][j];
            }
        }
        return matrizResultado;
    }

    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here indice[] stores pivoting order.

    public void pivotar(double matriz[][], int[] indice)  {

        int tamanio = indice.length;
        double factores[] = new double[tamanio];

 // Initialize the indice
        for (int i=0; i<tamanio; ++i){
            indice[i] = i;
        }
            

 // Find the rescaling factors, one from each row
        for (int i=0; i<tamanio; ++i) {
            double factor = 0;
            for (int j=0; j<tamanio; ++j) {
                double posibleFactor = Math.abs(matriz[i][j]);
                if (posibleFactor > factor){
                    factor = posibleFactor;
                }
            }
            factores[i] = factor;
        }
    // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < tamanio-1; ++j) {
            double pivote = 0;
            for (int i = j; i < tamanio; ++i)  {

                double posiblePivote = Math.abs(matriz[indice[i]][j]);
                posiblePivote /= factores[indice[i]];
                if (posiblePivote > pivote) {
                    pivote = posiblePivote;
                    k = i;
                }
            }
   // Interchange rows according to the pivoting order
            int intercambioPivote = indice[j];
            indice[j] = indice[k];
            indice[k] = intercambioPivote;
            for (int i = j+1; i < tamanio; ++i) {
                double valor = matriz[indice[i]][j]/matriz[indice[j]][j];
 // Record pivoting ratios below the diagonal
                matriz[indice[i]][j] = valor;
 // Modify other elements accordingly
                for (int l = j+1; l < tamanio; ++l){
                    matriz[indice[i]][l] -= valor*matriz[indice[j]][l];
                }
            }
        }
    }
     //***********************************************Sistema de ecuaciones*************************************************
    
    public double[][] resolverSistemaEcuacion(double [][] matrizA) {
        double[][] matrizResultante=matrizA;
            for (int filaDePivote = 0; filaDePivote < matrizA.length; filaDePivote++)
            {
 
                double valorDePivote = matrizResultante[filaDePivote][filaDePivote];
 
                for (int i = 0; i < matrizA[0].length; i++)
                {
                   matrizResultante[filaDePivote][i] = matrizResultante[filaDePivote][i] / valorDePivote;
                }
 
                int filaAProcesar = filaDePivote + 1;
                if (filaAProcesar == matrizA.length) {filaAProcesar = 0;}
                for (int fila = 0; fila < matrizA.length - 1; fila++)
                {                
                    double valorDelNuevoPivote = matrizResultante[filaAProcesar][filaDePivote];
 
                    for (int c = filaDePivote; c < matrizA[0].length; c++)
                    {
                        matrizResultante[filaAProcesar][c] = matrizResultante[filaAProcesar][c] - (valorDelNuevoPivote * matrizResultante[filaDePivote][c]);
                    }
                    if (filaAProcesar == matrizA.length - 1) filaAProcesar = 0;
                    else filaAProcesar++; 
                }
            }
         
            return matrizResultante;
        }

}

