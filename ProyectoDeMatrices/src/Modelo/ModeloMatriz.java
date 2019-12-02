package Modelo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase ModeloMatriz clase para validar y enviar los resultados de las operaciones de matrices a la vista de la aplicacion.
 *
 * @author carlosavila
 * @author leonardohernandez
 * @author josebaeza
 * @author nicolasgala
 * @version 1.0
 */
public class ModeloMatriz {
    /**
    * Variable publica: MatrizA modelo para generar la matrizA de manera visual
    */
    public DefaultTableModel MatrizA = new DefaultTableModel();

    /**
    * Variable publica: MatrizB modelo para generar la matrizB de manera visual
    */
    public DefaultTableModel MatrizB = new DefaultTableModel();

    /**
    * Variable publica: MatrizResultante modelo para generar la matriz resultante de manera visual
    */
    public DefaultTableModel MatrizResultante = new DefaultTableModel();   
    /**
     *<p>metodo que devuelve el modelo de la MatrizA
     * @return MatrizA modelo de la matrizA con la que se haran operaciones
     */
    public DefaultTableModel getMatrizA() {
        return MatrizA;
    }
    
    /**
     *<p>metodo que devuelve el modelo de la MatrizB
     * @return MatrizB modelo de la matrizB con la que se haran operaciones
     */
    public DefaultTableModel getMatrizB() {
        return MatrizB;
    }
    
    /**
     *<p>metodo que devuelve el modelo de la MatrizResultante
     * @return MatrizResultante modelo de la MatrizResultante que almacena los resultados de las operaciones con la MatrizA y la MatrizB
     */
    public DefaultTableModel getMatrizResultante() {
        return MatrizResultante;
    }
    
    /**
     *<p>Metodo que establece el modelo de la MatrizA
     * @param MatrizA modelo de la matrizA con los valores a establecer
     */
    public void setMatrizA(DefaultTableModel MatrizA) {
        this.MatrizA = MatrizA;
    }
    
    /**
     *<p>Metodo que establece el modelo de la MatrizB
     * @param MatrizB modelo de la matrizB con los valores a establecer
     */
    public void setMatrizB(DefaultTableModel MatrizB) {
        this.MatrizB = MatrizB;
    }
    
    /**
     *<p>Metodo que establece el modelo de la MatrizResultante
     * @param MatrizResultante modelo de la MatrizResultante con los valores a establecer
     */
    public void setMatrizResultante(DefaultTableModel MatrizResultante) {
        this.MatrizResultante = MatrizResultante;
    }
    
    /**
     *<p>Metodo que valida que se cumplan las condiciones para que se pueda calcular la suma y la multiplicacion
     * @param filaMatrizA numero de filas de la matrizA
     * @param columnaMatrizA numero de columnas de la matrizA
     * @param filaMatrizB numero de filas de la matrizB
     * @param columnaMatrizB numero de columnas de la matrizB
     * @param operacion es la operacion que se esta intentando realizar
     */
    public void validarOperacionDosMatrices(int filaMatrizA, int columnaMatrizA, int filaMatrizB, int columnaMatrizB, String operacion) {
        boolean sePuede;
        switch (operacion){
            case "Suma":
                sePuede = (filaMatrizA == filaMatrizB) && (columnaMatrizA == columnaMatrizB);
                if(sePuede){
                    generarMatrizA(filaMatrizA, columnaMatrizA);
                    generarMatrizB(filaMatrizB, columnaMatrizB);
                    generarMatrizResultado(filaMatrizA, columnaMatrizA);
                } else {
                    JOptionPane.showMessageDialog(null, "Las matrices deben tener la misma dimension"); 
                }
                break;
            case "Multiplicacion":
                sePuede =(columnaMatrizA == filaMatrizB);
                if(sePuede){
                    generarMatrizA(filaMatrizA, columnaMatrizA);
                    generarMatrizB(filaMatrizB, columnaMatrizB);
                    generarMatrizResultado(filaMatrizA, columnaMatrizB);
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad de columnas de la Matriz A debe ser igual a la cantidad de filas de la Matriz B"); 
                }
                break;
            
        }           
    }
    
    /**
     *<p>Metodo que valida que se cumplan las condiciones para que se puedan reealizar las operaciones con una matriz
     * @param filas numero de filas de la matriz
     * @param columnas numero de columnas de la matriz
     * @param operacion es la operacion que se esta intentando realizar
     */
    public void validarOperacion(int filas, int columnas, String operacion){
          boolean sePuede = filas == columnas; 
        switch (operacion){
            case "Determinante":         
                if(sePuede){
                    generarMatrizA(filas, columnas);
                } else {
                    JOptionPane.showMessageDialog(null,"La matriz debe ser cuadradada"); 
                }
                break;
            case "MultEsc":
                    generarMatrizA(filas, columnas);
                     generarMatrizResultado(filas, columnas);
                break;
            case "SistEcCramer":
                if(!sePuede){
                    generarMatrizA(filas, columnas);
                    generarMatrizResultado(1, filas);
                    } else {
                    JOptionPane.showMessageDialog(null,"La matriz no puede ser cuadradada"); 
                }
                    break;
            case "SistEc":
                  if(!sePuede){
                    generarMatrizA(filas, columnas);
                    generarMatrizResultado(filas, columnas);
                    break;
                     } else {
                    JOptionPane.showMessageDialog(null,"La matriz no puede ser cuadradada"); 
                }
            case "InvGauss":         
                if(sePuede){
                    generarMatrizA(filas, columnas);
                    generarMatrizResultado(filas, columnas);
                } else {
                    JOptionPane.showMessageDialog(null,"La matriz debe ser cuadradada"); 
                }
                break;
        }
    }
    /**
     *<p>Metodo que genera la MatrizA de manera visual en una tabla
     * @param fila numero de filas de la matriz
     * @param columna numero de columnas de la matriz
     */
    public void generarMatrizA(int fila, int columna) {
        try {
            MatrizA.setColumnCount(columna);
            MatrizA.setRowCount(fila);  
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "El valor de Fila(s) y Columna(s) debe ser mayor a 1"); 
        }
        
    }
    
    /**
     *<p>Metodo que genera la MatrizB de manera visual en una tabla
     * @param fila numero de filas de la matriz
     * @param columna numero de columnas de la matriz
     */
    public void generarMatrizB(int fila, int columna) {
        try {
            MatrizB.setColumnCount(columna);
            MatrizB.setRowCount(fila);  
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "El valor de Fila(s) y Columna(s) debe ser mayor a -1"); 
        }
    }
    
    /**
     *<p>Metodo que genera la MatrizResultado de manera visual en una tabla
     * @param fila numero de filas de la matriz
     * @param columna numero de columnas de la matriz
     */
    public void generarMatrizResultado(int fila, int columna) {
        MatrizResultante.setColumnCount(columna);
        MatrizResultante.setRowCount(fila); 
    }
}
