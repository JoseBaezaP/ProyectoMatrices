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
