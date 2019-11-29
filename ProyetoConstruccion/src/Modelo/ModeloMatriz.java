package Modelo;

import javax.swing.table.DefaultTableModel;

public class ModeloMatriz {
 
    DefaultTableModel tabla = new DefaultTableModel(); 

    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }
    
    public void generarTabla(int fil,int col){
        
    }
    
}
