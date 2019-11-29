import java.util.Scanner;
public class operacionMatrix{
    /*Aqui se escoge la operacion que se desea realizar suma, multiplicacion, 
      multiplicacion por escalar, transpuesta e inversa poe gauss-jordan*/
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Que operacion quieres realizar");
        System.out.println("Suma: 1");
        System.out.println("Multiplicacion: 2");
        System.out.println("Multiplicacion por escalar: 3");
        System.out.println("Transpuesta: 4");
        System.out.println("Inversa: 5");
        int operacionDeMatriz = entrada.nextInt();
        switch (operacionDeMatriz){
            case 1:
                suma();
            break;

            case 2:
                multiplicacion();
            break;

            case 3:
                multEscalar();
            break;

            case 4:
                transpuesta();
            break;

            case 5:
                invertir();

            break;
        }

      
    }



    // Función para realizar la suma de dos matrices
    public static void suma(){
        //declaracion de las variables
        int dimension; 
        Scanner entrada = new Scanner(System.in);
        
        int [][]matrizUno;
        int [][]matrizDos;
        int [][]suma;
        System.out.println("ingrese la dimension");
        dimension = entrada.nextInt();

        matrizUno = new int[dimension][dimension];
        matrizDos = new int[dimension][dimension];
        suma = new int[dimension][dimension];

        //Lectura de las matrices
        System.out.println("Matriz 1");
        
        for(int filasCounter=0;filasCounter<dimension;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<dimension;columnasCounter++) {
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizUno[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }

        System.out.println("Matriz 2");
        for(int filasCounter=0;filasCounter<dimension;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<dimension;columnasCounter++) {
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizDos[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }
        
        //Suma de las matrices posicion por poscicion
        for(int filasCounter=0;filasCounter<dimension;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<dimension;columnasCounter++) {
                suma[filasCounter][columnasCounter] = matrizUno[filasCounter][columnasCounter] + matrizDos[filasCounter][columnasCounter];    
            }
        }


        //Impresión de la matriz resultante de la suma
        for(int filasCounter=0;filasCounter<dimension;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<dimension;columnasCounter++) {
                System.out.print("[" + suma[filasCounter][columnasCounter] + "]" + "    ");
            }
                System.out.println("");
        }

    }

    //Función que realiza la multiplicacion de 2 matrices
    public static void multiplicacion(){
        Scanner entrada = new Scanner(System.in);
        //declaracion de las matrices a utilizar
        int [][]matrizUno;
        int [][]matrizDos;
        int [][]multMatrix;
      
        //obtension de las dimensiones de las matrices, (La columna de la primer matriz debe ser igual a la fila de la segunda matriz)
        System.out.println("fila primer matriz");
        int filaUno = entrada.nextInt();
        System.out.println("columnas primer matriz");
        int columnaUno = entrada.nextInt();

        System.out.println("fila segunda matriz");
        int filaDos = entrada.nextInt();
        System.out.println("columna segunda matriz");
        int columnaDos = entrada.nextInt();

        matrizUno = new int[filaUno][columnaDos];
        matrizDos = new int[filaDos][columnaDos];
        multMatrix = new int[filaUno][columnaDos];

       //Valida si se puede realizar la operacion
        if(columnaUno == filaDos){

        //Lectura de las matrices
         System.out.println("Matriz 1");
        for(int filasCounter=0;filasCounter<filaUno;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnaUno;columnasCounter++) {
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizUno[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }

        System.out.println("Matriz 2");
        for(int filasCounter=0;filasCounter<filaDos;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnaDos;columnasCounter++) {
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizDos[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }

        //inicializa la matriz para la multiplicación 
        for(int filasCounter=0;filasCounter<filaDos;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnaDos;columnasCounter++) { 
                multMatrix[filasCounter][columnasCounter] = 0;
            }
        }

        //Realiza la multiplicacion 
         for (int filasCounter = 0; filasCounter < filaUno; filasCounter++) { // fila uno
            for (int columnasCounter = 0; columnasCounter < columnaDos; columnasCounter++) { // columna dos
                for (int k = 0; k < columnaUno; k++) { // columna uno      
                    multMatrix[filasCounter][columnasCounter] += matrizUno[filasCounter][k] * matrizDos[k][columnasCounter]; 
                }
            }
        }


         //Impresión de la matriz resultante de la multiplicacion
        for(int filasCounter=0;filasCounter<filaUno;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnaDos;columnasCounter++) {
                System.out.print("[" + multMatrix[filasCounter][columnasCounter] + "]" + " ");
            }
                System.out.println("");
        }
        }else{
              System.out.println("No se puede :v");
        }
    }

    //Función para multiplicar una matriz por un numero escalar
    public static void multEscalar(){
        //declaracion de las variables a utilizar
        int filas;
        int columnas;
        Scanner entrada = new Scanner(System.in);
        //obtension de la dimension de la matriz
        System.out.println("ingrese el numero de filas");
        filas = entrada.nextInt();
        System.out.println("ingrese el numero de columnas");
        columnas = entrada.nextInt();

        int [][]matrizUno;
        matrizUno = new int[filas][columnas];
        
        int escalar;
        //lectura de matriz
        System.out.println("Matriz:");
        
        for(int filasCounter=0;filasCounter<filas;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnas;columnasCounter++) {
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizUno[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }

        System.out.println("Ingrese el esacalar a multiplicar la matriz");
        escalar = entrada.nextInt();
        
        //Multiplica la matriz por el escalar
        for(int filasCounter=0;filasCounter<filas;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnas;columnasCounter++) {
                matrizUno[filasCounter][columnasCounter] = escalar*matrizUno[filasCounter][columnasCounter];    
            }
        }


         //Impresion de la matriz resultante al mutiplicarla por un escalar
        for(int filasCounter=0;filasCounter<filas;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnas;columnasCounter++) {
                System.out.print("[" + matrizUno[filasCounter][columnasCounter] + "]" + " ");
            }
                System.out.println("");
        }
    }


    //Funcion para obtener la transpuesta de una matriz
    public static void transpuesta(){
        //declaracion de las variables a utilizar
        int filas;
        int columnas;
        Scanner entrada = new Scanner(System.in);
        //obtensión de la dimension de la matriz
        System.out.println("ingrese el numero de filas");
        filas = entrada.nextInt();
        System.out.println("ingrese el numero de columnas");
        columnas = entrada.nextInt();

        int [][]matrizUno;
        int [][]matrizTranspuesta;
        matrizUno = new int[filas][columnas];
        matrizTranspuesta = new int[matrizUno[0].length][matrizUno.length];
        
        //lectura de matriz
        System.out.println("Matriz:");
        
        for(int filasCounter=0;filasCounter<filas;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<columnas;columnasCounter++) {
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizUno[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }

        //Realiza la operacion para transponer una matriz intercambiando filas por columnas
          for(int filasCounter = 0; filasCounter < matrizUno.length; filasCounter++){  
            for (int columnasCounter = 0; columnasCounter < matrizUno[0].length; columnasCounter++){
                matrizTranspuesta [columnasCounter][filasCounter] = matrizUno[filasCounter][columnasCounter];
            }
          }

        //Impresion de la matriz transpuesta resultante
         for(int filasCounter=0;filasCounter<columnas;filasCounter++) {
            for(int columnasCounter=0;columnasCounter<filas;columnasCounter++) {
                System.out.print("[" + matrizTranspuesta[filasCounter][columnasCounter] + "]" + " ");
            }
                System.out.println("");
        }
    }


  
     /*metodo que inicializa las variables que usaremos para invertir e invierte
       la matriz con ayuda del metodo gaussJordan*/
     public static void invertir()         {
        //declaracion de la variables a utilizar
        int dimension;
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la dimension");
        dimension = entrada.nextInt();
        double [][]matrizA = new double[dimension][dimension];
        double matrizInverza[][] = new double[dimension][dimension];
        double matrizB[][] = new double[dimension][dimension];
        
        //Lectura de datos de la matriz
        System.out.println("Matriz:");   
        for(int filasCounter=0;filasCounter<dimension;filasCounter++){
            for(int columnasCounter=0;columnasCounter<dimension;columnasCounter++){
                System.out.println("Dato de la fila: ["+ (filasCounter+1) + "] coulmna: ["+ (columnasCounter+1) +"] = ");
                matrizA[filasCounter][columnasCounter] = entrada.nextInt();
            }
        }
        // indice[] almacena el orden de los pivotes.
        int indice[] = new int[dimension];
            
        for (int i=0; i<dimension; ++i){
            matrizB[i][i] = 1;
        }

        // Transforma la matriz en un triángulo superior
        gaussJordan(matrizA, indice);

        // Actualiza la matrizB[i][j] con las proporciones almacenadas
        for (int i=0; i<dimension-1; ++i){
            for (int j=i+1; j<dimension; ++j){
                for (int k=0; k<dimension; ++k){
                    matrizB[indice[j]][k]-= matrizA[indice[j]][i]*matrizB[indice[i]][k];
                }
            }
        }
     
        // Realiza sustituciones hacia atrás para poder invertir invertir la matriz
        for (int i=0; i<dimension; ++i){
            matrizInverza[dimension-1][i] = matrizB[indice[dimension-1]][i]/matrizA[indice[dimension-1]][dimension-1];
            for (int j=dimension-2; j>=0; --j){
                matrizInverza[j][i] = matrizB[indice[j]][i];
                for (int k=j+1; k<dimension; ++k){
                    matrizInverza[j][i] -= matrizA[indice[j]][k]*matrizInverza[k][i];
                }
                matrizInverza[j][i] /= matrizA[indice[j]][j];
            }
        }
           
        //impresion de la matriz inversa resultante
        for (int i =0;i< dimension ;i++ ) {
            for (int j =0;j<dimension ;j++ ) {
                System.out.print("[" + matrizInverza[i][j] + "]" + " ");  
            }
            System.out.println("");
        }
    }

      

        // Método para llevar a cabo la eliminación gaussiana de pivote parcial.
        // indice[] almacena el orden de los pivotes.

    public static void gaussJordan(double matrizA[][], int indice[])  {
        //declaracion de variables
        int dimensionIndice = indice.length;
        double factoresRescalado[] = new double[dimensionIndice];
        // se inicializa el indice
        for (int i=0; i<dimensionIndice; ++i){
            indice[i] = i;
        }
        // Encuentra los factores de reescalado, uno por cada fila
        for (int i=0; i<dimensionIndice; ++i){
            double factorC1 = 0;
            for (int j=0; j<dimensionIndice; ++j){
                double factorC0 = Math.abs(matrizA[i][j]);
                if (factorC0 > factorC1){
                    factorC1 = factorC0;
                }
            }   
            factoresRescalado[i] = factorC1;
        }

        // Busca el elemento que es pivote de cada columna
        int k = 0;
        for (int j=0; j<dimensionIndice-1; ++j){
            double pivote1 = 0;
            for (int i=j; i<dimensionIndice; ++i){
                double pivote0 = Math.abs(matrizA[indice[i]][j]);
                pivote0 /= factoresRescalado[indice[i]];
                if (pivote0 > pivote1){
                    pivote1 = pivote0;
                    k = i;
                }   
            }
            // Intercambiar filas de acuerdo con el orden de los pivotes
            int indiceTemporal = indice[j];
            indice[j] = indice[k];
            indice[k] = indiceTemporal;
            
            for (int i=j+1; i<dimensionIndice; ++i){
                double pivotesDiagonal = matrizA[indice[i]][j]/matrizA[indice[j]][j];
                // Registra las relaciones de los pivotes debajo de la diagonal
                matrizA[indice[i]][j] = pivotesDiagonal;
                // Modificar otros elementos en consecuencia de lo anterior
                for (int l=j+1; l<dimensionIndice; ++l){
                    matrizA[indice[i]][l] -= pivotesDiagonal*matrizA[indice[j]][l];
                }   
            }
        }
    }
}



    
    



    

