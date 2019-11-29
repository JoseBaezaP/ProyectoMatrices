package Modelo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModeloMatriz {
 
    DefaultTableModel tabla = new DefaultTableModel(); 
    public DefaultTableModel Matriz1= new DefaultTableModel();
    public DefaultTableModel Matriz2= new DefaultTableModel();
    public DefaultTableModel MatrizResultante= new DefaultTableModel();
    
      public void Validacion(int filaMatriz1,int columnaMatriz1,int filaMatriz2,int columnaMatriz2,String operacion) {
                boolean sePuede;
             switch (operacion){
              case "suma":
                  sePuede = (filaMatriz1 == filaMatriz2) && (columnaMatriz1 == columnaMatriz2);
                  if(sePuede){
                    generarMatriz1(filaMatriz1,columnaMatriz1);
                    generarMatriz2(filaMatriz2,columnaMatriz2);
                    generarMatrizResultado(filaMatriz1,columnaMatriz1);
                     } else {
                   JOptionPane.showMessageDialog(null,"Las matrices deben tener la misma dimension"); 
                }
                  break;
              case "multiplicacion":
               sePuede =(columnaMatriz1 == filaMatriz2);
                if(sePuede){
                    generarMatriz1(filaMatriz1,columnaMatriz1);
                    generarMatriz2(filaMatriz2,columnaMatriz2);
                    generarMatrizResultado(filaMatriz1,columnaMatriz2);
                } else {
                   JOptionPane.showMessageDialog(null,"La cantidad de columnas de la Matriz A debe ser igual a la cantidad de filas de la Matriz B"); 
                }
                break;
          }
                
    }
    public void generarMatriz1(int fila, int columna){
        Matriz1.setColumnCount(columna);
        Matriz1.setRowCount(fila);
        
    }
    public void generarMatriz2(int fila, int columna){
        Matriz2.setColumnCount(columna); 
        Matriz2.setRowCount(fila);

    }
    public void generarMatrizResultado(int fila, int columna){        
        MatrizResultante.setColumnCount(columna);
        MatrizResultante.setRowCount(fila);
        
    }
    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getMatriz1() {
        return Matriz1;
    }

    public DefaultTableModel getMatriz2() {
        return Matriz2;
    }

    public DefaultTableModel getMatrizResultante() {
        return MatrizResultante;
    }
    
    public void generarTabla(int fil,int col){
        
    }

    public void setMatriz1(DefaultTableModel Matriz1) {
        this.Matriz1 = Matriz1;
    }

    public void setMatriz2(DefaultTableModel Matriz2) {
        this.Matriz2 = Matriz2;
    }

    public void setMatrizResultante(DefaultTableModel MatrizResultante) {
        this.MatrizResultante = MatrizResultante;
    }
    
}
