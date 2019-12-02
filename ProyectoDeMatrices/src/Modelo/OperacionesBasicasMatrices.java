package Modelo;
import javax.swing.JOptionPane;
/**
 * Clase OperacionesBasicasMatrices clase que realiza las operaciones basicas con las matrices dadas.
 *
 * @author carlosavila
 * @author leonardohernandez
 * @author josebaeza
 * @author nicolasgala
 * @version 1.0
 */
public class OperacionesBasicasMatrices {
    
    /**
     * <p>Metodo que suma 2 matrices poscicion por poscicion y devuelve el resultado en una nueva matriz
     * @param matrizA matriz de double que se sumara con la matrizB
     * @param matrizB matriz de double que se sumara con la matrizA
     * @return suma matriz de double con el resultado de la suma entre la matrizA y matrizB
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
     * <p>Metodo que multiplica 2 matrices y devuelve el resultado en una nueva matriz
     * @param matrizA matriz de double que se multiplicara con la matrizB
     * @param matrizB matriz de double que se multiplicara con la matrizA
     * @return matrizResultado matriz de double con el resultado de la multiplicacion entre la matrizA y matrizB
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
     * <p>Metodo que multiplica una matriz por un numero escalar y devuelve el resultado en una nueva matriz
     * @param matriz matriz de double que se multiplicara por el numero escalar
     * @param escalar numero double que se multiplicara por cada elemento de la matriz
     * @return matrizResultado matriz de double con el resultado de la multiplicacion entre la matriz y el escalar
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
     * <p>Metodo que calcula el determinante de una matriz
     * @param matriz matriz de double de la cual se calculara el determinante
     * @return determinante numero double que almacena el valor de la determinante de la matriz
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
     * <p>Metodo para obtener una sub matriz necesaria para calcular la determinante de una matriz
     * @param matriz original de la cual se esta calculando la determinante
     * @param filas cantidad de filas de la matriz original
     * @param columnas cantidad de columnas de la matriz original
     * @param columna columna actual en la cual se esta obteniendo valores para calcular el determinante
     * @return submatriz matriz de double de  necesaria para calcular el determinante de la matriz original
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
     * <p>Metodo que calcuala la solucion de un sistema de ecuaciones por el metodo de Cramer
     * @param matrizA que representa las ecuaciones a solucionar
     * @return rCramer matriz de double con la soluciones del sistema de ecuaciones si se da el caso de que tenga
     */
    public double[][] metodoDeCramer(double [][] matrizA) {
        int tamanio = matrizA.length;
        double[][] matrizDeEcuaciones = new double[tamanio][tamanio];
        matrizDeEcuaciones = generarMatrizEcuaciones(matrizA);    
        double[][] rCramer = new double[1][tamanio];    
        double determinante = calcularDeterminante(matrizDeEcuaciones);

        if (determinante == 0) {
            JOptionPane.showMessageDialog(null,"No tiene solucion con la regla de Cramer");
            return rCramer;
        }
        double[] vectorDeSoluciones = new double[tamanio];
        vectorDeSoluciones = generarVectorSoluciones(matrizA);

        double detDelCoeficiente;

        double matrizCoeficiente[][] = new double[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            matrizCoeficiente = sustituye(matrizDeEcuaciones,vectorDeSoluciones,i);
            detDelCoeficiente = calcularDeterminante(matrizCoeficiente);
            rCramer[0][i]=(detDelCoeficiente/determinante);
        }
        return rCramer; 
    }

    /**
     *<p>Metodo que sustituye las columnas de la matriz original por la matriz de coeficientes
     * @param matrizDeEcuaciones matriz con los valores del sistema de ecuaciones
     * @param vectorDeSoluciones vector con las soluciones del sistema de ecuaciones 
     * @param pos poscicion de la columna a sustituit
     * @return matrizCoeficiente matriz con los valores de la columna sustituidos
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
     * <p>Metodo que genera una matriz de ecuaciones con los valores de la matriz original
     * @param matriz es la matriz de la cual se obtendran los valores para generar la matriz de ecuaciones
     * @return matrizDeEcuaciones matriz de ecuaciones generada 
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
     *<p>Metodo que genera un vector con las soluciones del sistema de ecuaciones
     * @param matriz es la matriz de la cual se obtendran los valores para generar el vector de soluciones
     * @return vectorDeSoluciones vector de soluciones generado con la matriz original
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
    
    
     public double[][] invert(double a[][])         {

            int n = a.length;
            double x[][] = new double[n][n];
            double b[][] = new double[n][n];
            int index[] = new int[n];
            for (int i=0; i<n; ++i)
                b[i][i] = 1;

     // Transform the matrix into an upper triangle

            gaussian(a, index);

     // Update the matrix b[i][j] with the ratios stored
            for (int i=0; i<n-1; ++i)
                for (int j=i+1; j<n; ++j)
                    for (int k=0; k<n; ++k)
                        b[index[j]][k]
                        	    -= a[index[j]][i]*b[index[i]][k];

     
     // Perform backward substitutions
            for (int i=0; i<n; ++i)             {
                x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
                for (int j=n-2; j>=0; --j)                 {
                    x[j][i] = b[index[j]][i];
                    for (int k=j+1; k<n; ++k)
                    {
                        x[j][i] -= a[index[j]][k]*x[k][i];
                    }

                    x[j][i] /= a[index[j]][j];
                }
            }
            return x;
        }

    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here index[] stores pivoting order.

        public void gaussian(double a[][], int index[])  {

            int n = index.length;
            double c[] = new double[n];

     // Initialize the index
            for (int i=0; i<n; ++i)
                index[i] = i;

     // Find the rescaling factors, one from each row
            for (int i=0; i<n; ++i) {
                double c1 = 0;
                for (int j=0; j<n; ++j) {
                    double c0 = Math.abs(a[i][j]);
                    if (c0 > c1) c1 = c0;
                }
                c[i] = c1;
            }

     // Search the pivoting element from each column
            int k = 0;
            for (int j=0; j<n-1; ++j) {
                double pi1 = 0;
                for (int i=j; i<n; ++i)  {

                    double pi0 = Math.abs(a[index[i]][j]);
                    pi0 /= c[index[i]];
                    if (pi0 > pi1) {
                        pi1 = pi0;
                        k = i;
                    }
                }

     
       // Interchange rows according to the pivoting order
                int itmp = index[j];
                index[j] = index[k];
                index[k] = itmp;
                for (int i=j+1; i<n; ++i) {
                    double pj = a[index[i]][j]/a[index[j]][j];

     // Record pivoting ratios below the diagonal
                    a[index[i]][j] = pj;

     // Modify other elements accordingly
                    for (int l=j+1; l<n; ++l)
                        a[index[i]][l] -= pj*a[index[j]][l];
                }
            }
        }
    
    
    
    
    
    
}
