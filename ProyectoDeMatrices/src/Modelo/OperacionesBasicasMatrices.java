package Modelo;

import javax.swing.JOptionPane;

/**
 * Clase OperacionesBasicasMatrices clase que realiza las operaciones basicas
 * con las matrices dadas.
 *
 * @author carlosavila
 * @author leonardohernandez
 * @author josebaeza
 * @author nicolasgala
 * @version 1.0
 */
public class OperacionesBasicasMatrices {

    /**
     * <p>
     * Metodo que suma 2 matrices poscicion por poscicion y devuelve el
     * resultado en una nueva matriz
     *
     * @param matrizA matriz de double que se sumara con la matrizB
     * @param matrizB matriz de double que se sumara con la matrizA
     * @return suma matriz de double con el resultado de la suma entre la
     * matrizA y matrizB
     */
    public double[][] suma(double[][] matrizA, double[][] matrizB) {
        double[][] suma;
        int tamanio = matrizA.length;
        suma = new double[tamanio][tamanio];

        //Suma de las matrices posicion por poscicion
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return suma;
    }

    /**
     * <p>
     * Metodo que multiplica 2 matrices y devuelve el resultado en una nueva
     * matriz
     *
     * @param matrizA matriz de double que se multiplicara con la matrizB
     * @param matrizB matriz de double que se multiplicara con la matrizA
     * @return matrizResultado matriz de double con el resultado de la
     * multiplicacion entre la matrizA y matrizB
     */
    public double[][] multiplicacion(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int filasB = matrizB.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        double[][] matrizResultado;
        matrizResultado = new double[filasA][columnasB];

        //inicializa la matriz para la multiplicación 
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
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
     * <p>
     * Metodo que multiplica una matriz por un numero escalar y devuelve el
     * resultado en una nueva matriz
     *
     * @param matriz matriz de double que se multiplicara por el numero escalar
     * @param escalar numero double que se multiplicara por cada elemento de la
     * matriz
     * @return matrizResultado matriz de double con el resultado de la
     * multiplicacion entre la matriz y el escalar
     */
    public double[][] multiplicacionEscalar(double[][] matriz, double escalar) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] matrizResultado = matriz;

        //Multiplica la matriz por el escalar
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultado[i][j] = escalar * matrizResultado[i][j];
            }
        }
        return matrizResultado;
    }

    //******************************************Calcular determinante*************************************************
    /**
     * <p>
     * Metodo que calcula el determinante de una matriz
     *
     * @param matriz matriz de double de la cual se calculara el determinante
     * @return determinante numero double que almacena el valor de la
     * determinante de la matriz
     */
    public double calcularDeterminante(double[][] matriz) {
        double determinante = 0;
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if ((filas == 1) && (columnas == 1)) {
            return matriz[0][0];
        }

        int signo = 1;
        for (int i = 0; i < columnas; i++) {
            double[][] submatriz = getSubmatriz(matriz, filas, columnas, i);
            determinante = determinante + signo * matriz[0][i] * calcularDeterminante(submatriz);
            signo *= -1;
        }
        return determinante;
    }

    /**
     *
     * <p>
     * Metodo para obtener una sub matriz necesaria para calcular la
     * determinante de una matriz
     *
     * @param matriz original de la cual se esta calculando la determinante
     * @param filas cantidad de filas de la matriz original
     * @param columnas cantidad de columnas de la matriz original
     * @param columna columna actual en la cual se esta obteniendo valores para
     * calcular el determinante
     * @return submatriz matriz de double de necesaria para calcular el
     * determinante de la matriz original
     */
    public static double[][] getSubmatriz(double[][] matriz, int filas, int columnas, int columna) {
        double[][] submatriz = new double[filas - 1][columnas - 1];
        int contador = 0;
        for (int j = 0; j < columnas; j++) {
            if (j == columna) {
                continue;
            }
            for (int i = 1; i < filas; i++) {
                submatriz[i - 1][contador] = matriz[i][j];
            }
            contador++;
        }
        return submatriz;
    }
    //**************************************************Metodo De Cramer*****************************************************

    /**
     * <p>
     * Metodo que calcuala la solucion de un sistema de ecuaciones por el metodo
     * de Cramer
     *
     * @param matrizA que representa las ecuaciones a solucionar
     * @return rCramer matriz de double con la soluciones del sistema de
     * ecuaciones si se da el caso de que tenga
     */
    public double[][] metodoDeCramer(double[][] matrizA) {
        int tamanio = matrizA.length;
        double[][] matrizDeEcuaciones = new double[tamanio][tamanio];
        matrizDeEcuaciones = generarMatrizEcuaciones(matrizA);
        double[][] rCramer = new double[1][tamanio];
        double determinante = calcularDeterminante(matrizDeEcuaciones);

        if (determinante == 0) {
            JOptionPane.showMessageDialog(null, "No tiene solucion con la regla de Cramer");
            return rCramer;
        }
        double[] vectorDeSoluciones = new double[tamanio];
        vectorDeSoluciones = generarVectorSoluciones(matrizA);

        double detDelCoeficiente;

        double matrizCoeficiente[][] = new double[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            matrizCoeficiente = sustituye(matrizDeEcuaciones, vectorDeSoluciones, i);
            detDelCoeficiente = calcularDeterminante(matrizCoeficiente);
            rCramer[0][i] = (detDelCoeficiente / determinante);
        }
        return rCramer;
    }

    /**
     * <p>
     * Metodo que sustituye las columnas de la matriz original por la matriz de
     * coeficientes
     *
     * @param matrizDeEcuaciones matriz con los valores del sistema de
     * ecuaciones
     * @param vectorDeSoluciones vector con las soluciones del sistema de
     * ecuaciones
     * @param pos poscicion de la columna a sustituit
     * @return matrizCoeficiente matriz con los valores de la columna
     * sustituidos
     */
    public double[][] sustituye(double matrizDeEcuaciones[][], double vectorDeSoluciones[], int pos) {
        double matrizCoeficiente[][] = new double[matrizDeEcuaciones.length][matrizDeEcuaciones.length];
        for (int i = 0; i < matrizDeEcuaciones.length; i++) {
            for (int j = 0; j < matrizDeEcuaciones.length; j++) {
                if (j == pos) {
                    matrizCoeficiente[i][j] = vectorDeSoluciones[i];
                } else {
                    matrizCoeficiente[i][j] = matrizDeEcuaciones[i][j];
                }
            }
        }
        return matrizCoeficiente;
    }

    /**
     *
     * <p>
     * Metodo que genera una matriz de ecuaciones con los valores de la matriz
     * original
     *
     * @param matriz es la matriz de la cual se obtendran los valores para
     * generar la matriz de ecuaciones
     * @return matrizDeEcuaciones matriz de ecuaciones generada
     */
    public static double[][] generarMatrizEcuaciones(double[][] matriz) {
        int tamanio = matriz.length;
        int columnas = matriz[0].length;
        double[][] matrizDeEcuaciones = new double[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < columnas - 1; j++) {
                matrizDeEcuaciones[i][j] = matriz[i][j];
            }
        }
        return matrizDeEcuaciones;
    }

    /**
     * <p>
     * Metodo que genera un vector con las soluciones del sistema de ecuaciones
     *
     * @param matriz es la matriz de la cual se obtendran los valores para
     * generar el vector de soluciones
     * @return vectorDeSoluciones vector de soluciones generado con la matriz
     * original
     */
    public static double[] generarVectorSoluciones(double[][] matriz) {
        int tamanio = matriz.length;
        double[] vectorDeSoluciones = new double[tamanio];

        for (int i = 0; i < tamanio; i++) {
            vectorDeSoluciones[i] = matriz[i][tamanio];
        }
        return vectorDeSoluciones;
    }

    /**
     * <p>
     * Metodo que calcula la matriz inversa de una matriz inicial dada
     *
     * @param matriz matriz de double que contiene los valores de los cuales se
     * calculara la inversa
     * @return matrizResultado matriz de double que contiene los valores de la
     * matriz invertida con respecto a la matriz original
     */
    public double[][] inversaGaussJordan(double matriz[][]) {
        int tamanio = matriz.length;
        double matrizResultado[][] = new double[tamanio][tamanio];
        double matrizAuxiliar[][] = new double[tamanio][tamanio];
        int[] indice = new int[tamanio];
        for (int i = 0; i < tamanio; ++i) {
            matrizAuxiliar[i][i] = 1;
        }

        pivotar(matriz, indice);

        for (int i = 0; i < tamanio - 1; ++i) {
            for (int j = i + 1; j < tamanio; ++j) {
                for (int k = 0; k < tamanio; ++k) {
                    matrizAuxiliar[indice[j]][k] -= matriz[indice[j]][i] * matrizAuxiliar[indice[i]][k];
                }
            }
        }

        for (int i = 0; i < tamanio; ++i) {
            matrizResultado[tamanio - 1][i] = matrizAuxiliar[indice[tamanio - 1]][i] / matriz[indice[tamanio - 1]][tamanio - 1];
            for (int j = tamanio - 2; j >= 0; --j) {
                matrizResultado[j][i] = matrizAuxiliar[indice[j]][i];
                for (int k = j + 1; k < tamanio; ++k) {
                    matrizResultado[j][i] -= matriz[indice[j]][k] * matrizResultado[k][i];
                }
                matrizResultado[j][i] /= matriz[indice[j]][j];
            }
        }
        return matrizResultado;
    }

    /**
     * <p>
     * Metodo que identifica e intercambia pivotes para poder invertir la matriz
     *
     * @param matriz matriz de double de la cual se quieren identificar e
     * intercambiar pivotes para calcular su inversa
     * @param indice vetor que guarda la cantidad de indices de la matriz
     */
    public void pivotar(double matriz[][], int[] indice) {

        int tamanio = indice.length;
        double factores[] = new double[tamanio];

        for (int i = 0; i < tamanio; ++i) {
            indice[i] = i;
        }

        for (int i = 0; i < tamanio; ++i) {
            double factor = 0;
            for (int j = 0; j < tamanio; ++j) {
                double posibleFactor = Math.abs(matriz[i][j]);
                if (posibleFactor > factor) {
                    factor = posibleFactor;
                }
            }
            factores[i] = factor;
        }

        int k = 0;
        for (int j = 0; j < tamanio - 1; ++j) {
            double pivote = 0;
            for (int i = j; i < tamanio; ++i) {

                double posiblePivote = Math.abs(matriz[indice[i]][j]);
                posiblePivote /= factores[indice[i]];
                if (posiblePivote > pivote) {
                    pivote = posiblePivote;
                    k = i;
                }
            }

            int intercambioPivote = indice[j];
            indice[j] = indice[k];
            indice[k] = intercambioPivote;
            for (int i = j + 1; i < tamanio; ++i) {
                double valor = matriz[indice[i]][j] / matriz[indice[j]][j];

                matriz[indice[i]][j] = valor;

                for (int l = j + 1; l < tamanio; ++l) {
                    matriz[indice[i]][l] -= valor * matriz[indice[j]][l];
                }
            }
        }
    }

    /**
     * <p>
     * Metodo que resuelve un sistema de ecuaciones usando una matriz
     *
     * @param matrizA matriz de double que contiene las ecuaciones a resolver
     * @return matrizResultado matriz de double con el resultado del sistema de
     * ecuacion dado el caso de que tenga solucion
     */
    public double[][] resolverSistemaEcuacion(double[][] matrizA) {
        double[][] matrizResultante = matrizA;
        for (int filaDePivote = 0; filaDePivote < matrizA.length; filaDePivote++) {
            double valorDePivote = matrizResultante[filaDePivote][filaDePivote];

            for (int i = 0; i < matrizA[0].length; i++) {
                matrizResultante[filaDePivote][i] = matrizResultante[filaDePivote][i] / valorDePivote;
            }

            int filaAProcesar = filaDePivote + 1;
            if (filaAProcesar == matrizA.length) {
                filaAProcesar = 0;
            }
            for (int fila = 0; fila < matrizA.length - 1; fila++) {
                double valorDelNuevoPivote = matrizResultante[filaAProcesar][filaDePivote];

                for (int c = filaDePivote; c < matrizA[0].length; c++) {
                    matrizResultante[filaAProcesar][c] = matrizResultante[filaAProcesar][c] - (valorDelNuevoPivote * matrizResultante[filaDePivote][c]);
                }
                if (filaAProcesar == matrizA.length - 1) {
                    filaAProcesar = 0;
                } else {
                    filaAProcesar++;
                }
            }
        }
        return matrizResultante;
    }

}
