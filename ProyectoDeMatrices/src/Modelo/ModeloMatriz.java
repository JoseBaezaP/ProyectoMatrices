package Modelo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josebaeza
 */
public class ModeloMatriz {
    /**
     *
     */
    public DefaultTableModel MatrizA = new DefaultTableModel();

    /**
     *
     */
    public DefaultTableModel MatrizB = new DefaultTableModel();

    /**
     *
     */
    public DefaultTableModel MatrizResultante = new DefaultTableModel();   
    /**
     *
     * @return
     */
    public DefaultTableModel getMatrizA() {
        return MatrizA;
    }
    
    /**
     *
     * @return
     */
    public DefaultTableModel getMatrizB() {
        return MatrizB;
    }
    
    /**
     *
     * @return
     */
    public DefaultTableModel getMatrizResultante() {
        return MatrizResultante;
    }
    
    /**
     *
     * @param MatrizA
     */
    public void setMatrizA(DefaultTableModel MatrizA) {
        this.MatrizA = MatrizA;
    }
    
    /**
     *
     * @param MatrizB
     */
    public void setMatrizB(DefaultTableModel MatrizB) {
        this.MatrizB = MatrizB;
    }
    
    /**
     *
     * @param MatrizResultante
     */
    public void setMatrizResultante(DefaultTableModel MatrizResultante) {
        this.MatrizResultante = MatrizResultante;
    }
    
    /**
     *
     * @param filaMatrizA
     * @param columnaMatrizA
     * @param filaMatrizB
     * @param columnaMatrizB
     * @param operacion
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
     *
     * @param filas
     * @param columnas
     * @param operacion
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
     *
     * @param fila
     * @param columna
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
     *
     * @param fila
     * @param columna
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
     *
     * @param fila
     * @param columna
     */
    public void generarMatrizResultado(int fila, int columna) {
        MatrizResultante.setColumnCount(columna);
        MatrizResultante.setRowCount(fila); 
    }
}
