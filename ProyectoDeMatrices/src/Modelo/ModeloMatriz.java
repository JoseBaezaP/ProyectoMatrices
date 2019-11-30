package Modelo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModeloMatriz {
 
    public DefaultTableModel tabla = new DefaultTableModel(); 
    public DefaultTableModel MatrizA = new DefaultTableModel();
    public DefaultTableModel MatrizB = new DefaultTableModel();
    public DefaultTableModel MatrizResultante = new DefaultTableModel();
    
    public DefaultTableModel getTabla() {
        return tabla;
    }
    
    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }
    
    public DefaultTableModel getMatrizA() {
        return MatrizA;
    }
    
    public DefaultTableModel getMatrizB() {
        return MatrizB;
    }
    
    public DefaultTableModel getMatrizResultante() {
        return MatrizResultante;
    }
    
    public void setMatrizA(DefaultTableModel MatrizA) {
        this.MatrizA = MatrizA;
    }
    
    public void setMatrizB(DefaultTableModel MatrizB) {
        this.MatrizB = MatrizB;
    }
    
    public void setMatrizResultante(DefaultTableModel MatrizResultante) {
        this.MatrizResultante = MatrizResultante;
    }
    
    public void Validacion(int filaMatrizA, int columnaMatrizA, int filaMatrizB, int columnaMatrizB, String operacion) {
        boolean sePuede;
        switch (operacion){
            case "suma":
                sePuede = (filaMatrizA == filaMatrizB) && (columnaMatrizA == columnaMatrizB);
                if(sePuede){
                    generarMatrizA(filaMatrizA, columnaMatrizA);
                    generarMatrizB(filaMatrizB, columnaMatrizB);
                    generarMatrizResultado(filaMatrizA, columnaMatrizA);
                } else {
                    JOptionPane.showMessageDialog(null,"Las matrices deben tener la misma dimension"); 
                }
                break;
            case "multiplicacion":
                sePuede =(columnaMatrizA == filaMatrizB);
                if(sePuede){
                    generarMatrizA(filaMatrizA, columnaMatrizA);
                    generarMatrizB(filaMatrizB, columnaMatrizB);
                    generarMatrizResultado(filaMatrizA, columnaMatrizB);
                } else {
                    JOptionPane.showMessageDialog(null,"La cantidad de columnas de la Matriz A debe ser igual a la cantidad de filas de la Matriz B"); 
                }
                break;
            case "Determinante":
            sePuede = filaMatrizA == columnaMatrizA; 
            if(sePuede){
                generarMatrizA(filaMatrizA, columnaMatrizA);
                generarMatrizResultado(filaMatrizA, columnaMatrizA);
            } else {
                JOptionPane.showMessageDialog(null,"La matriz debe ser cuadradada"); 
            }
            break;
        }           
    }
    
    public void generarTabla(int fil,int col){
        
    }
    
    public void generarMatrizA(int fila, int columna) {
        MatrizA.setColumnCount(columna);
        MatrizA.setRowCount(fila);  
    }
    
    public void generarMatrizB(int fila, int columna) {
        MatrizB.setColumnCount(columna); 
        MatrizB.setRowCount(fila);
    }
    
    public void generarMatrizResultado(int fila, int columna) {        
        MatrizResultante.setColumnCount(columna);
        MatrizResultante.setRowCount(fila); 
    }

}
