package Controlador;
import Vista.frmVistaMatrices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ModeloMatriz;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlMatrices implements ActionListener{
    
    frmVistaMatrices operaciones;
    
    
    
    public void multiplicar(){
        
    }
     public CtrlMatrices(){
        this.operaciones = new frmVistaMatrices();
       inicializar();
       inicializarTablas();
       ocultarElementos();
    }
    public void inicializar(){
        this.operaciones.rb_Suma.addActionListener(this);
        this.operaciones.rb_Suma.setActionCommand("suma");
        this.operaciones.rb_InvGauss.addActionListener(this);
        this.operaciones.rb_InvGauss.setActionCommand("InvGauss");
        this.operaciones.rb_MultEsc.addActionListener(this);
        this.operaciones.rb_MultEsc.setActionCommand("MultEsc");
        this.operaciones.rb_Multiplicar.addActionListener(this);
        this.operaciones.rb_Multiplicar.setActionCommand("Multiplicar");
        this.operaciones.rb_SistEc.addActionListener(this);
        this.operaciones.rb_SistEc.setActionCommand("SistEc");
        this.operaciones.rb_Determinante.addActionListener(this);
        this.operaciones.rb_Determinante.setActionCommand("Determinante");
        this.operaciones.rb_SistEcCramer.addActionListener(this);
        this.operaciones.rb_SistEcCramer.setActionCommand("SistEcCramer");
        this.operaciones.btn_Generar.addActionListener(this);
        this.operaciones.btn_Generar.setActionCommand("Generar");
        this.operaciones.setVisible(true);
        this.operaciones.setLocationRelativeTo(null);
    }
    public void inicializarTablas(){   
    DefaultTableModel modeloA = new DefaultTableModel(); 
    DefaultTableModel modeloB = new DefaultTableModel();
    DefaultTableModel modeloC = new DefaultTableModel();
        modeloA.setColumnCount(2);
        modeloB.setColumnCount(2);
        modeloC.setColumnCount(2);
        modeloA.setRowCount(2);
        modeloB.setRowCount(2);
        modeloC.setRowCount(2);
        
         this.operaciones.tbl_Matriz1.setModel(modeloA);
         this.operaciones.tbl_Matriz2.setModel(modeloB);
         this.operaciones.tbl_Resultado.setModel(modeloC);
        
         this.operaciones.rb_Ninguno.setSelected(true);
    }
    public void ocultarElementos(){
        this.operaciones.txt_Escalar.setVisible(false);
        this.operaciones.lb_Escalar.setVisible(false);
    }
    public void generarMatrices(){
        try{
        ModeloMatriz modelo=new ModeloMatriz();
        if(this.operaciones.rb_Suma.isSelected() == true){
            modelo.Validacion(Integer.parseInt(this.operaciones.txt_FilasMatriz1.getText()),Integer.parseInt(this.operaciones.txt_ColumnasMatriz1.getText()),
                              Integer.parseInt(this.operaciones.txt_FilasMatriz2.getText()),Integer.parseInt(this.operaciones.txt_ColumnasMatriz2.getText()),"suma");
            this.operaciones.tbl_Matriz1.setModel(modelo.getMatriz1());
            this.operaciones.tbl_Matriz2.setModel(modelo.getMatriz2());
            this.operaciones.tbl_Resultado.setModel(modelo.getMatrizResultante());
            }
       if(this.operaciones.rb_MultEsc.isSelected() == true){
            modelo.generarMatriz1(Integer.parseInt(this.operaciones.txt_FilasMatriz1.getText()),
                                  Integer.parseInt(this.operaciones.txt_ColumnasMatriz1.getText()));
            this.operaciones.tbl_Matriz1.setModel(modelo.getMatriz1());
            this.operaciones.tbl_Resultado.setModel(modelo.getMatriz1());

            }
       if(this.operaciones.rb_Multiplicar.isSelected() == true){
          modelo.Validacion(Integer.parseInt(this.operaciones.txt_FilasMatriz1.getText()),Integer.parseInt(this.operaciones.txt_ColumnasMatriz1.getText()),
                              Integer.parseInt(this.operaciones.txt_FilasMatriz2.getText()),Integer.parseInt(this.operaciones.txt_ColumnasMatriz2.getText()),"multiplicacion");
            this.operaciones.tbl_Matriz1.setModel(modelo.getMatriz1());
            this.operaciones.tbl_Matriz2.setModel(modelo.getMatriz2());
            this.operaciones.tbl_Resultado.setModel(modelo.getMatrizResultante());

            }
       boolean operacionSingular = this.operaciones.rb_SistEc.isSelected() ||this.operaciones.rb_Determinante.isSelected() || this.operaciones.rb_SistEcCramer.isSelected() || this.operaciones.rb_InvGauss.isSelected();
            if(operacionSingular == true){           
                modelo.generarMatriz1(Integer.parseInt(this.operaciones.txt_FilasMatriz1.getText()),
                                  Integer.parseInt(this.operaciones.txt_ColumnasMatriz1.getText()));
            this.operaciones.tbl_Matriz1.setModel(modelo.getMatriz1());
            this.operaciones.tbl_Resultado.setModel(modelo.getMatriz1());
            }
         } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Debe ingresar datos numericos en los campos de Fila(s) y Columna(s)");
        }
    }
    public void elementosDosMatrices(){   
        this.operaciones.lb_Escalar.setVisible(false);
        this.operaciones.txt_Escalar.setVisible(false);
        this.operaciones.lb_Filas2.setVisible(true);
        this.operaciones.lb_Columnas2.setVisible(true);
        this.operaciones.txt_FilasMatriz2.setVisible(true);
        this.operaciones.txt_ColumnasMatriz2.setVisible(true);
        this.operaciones.lb_MatrizB.setVisible(true);
        this.operaciones.tbl_Matriz2.setVisible(true);
      
    }
     private void elementos(){
        this.operaciones.txt_Escalar.setVisible(false);
        this.operaciones.lb_Escalar.setVisible(false);
        this.operaciones.lb_Filas2.setVisible(false);
        this.operaciones.lb_Columnas2.setVisible(false);
        this.operaciones.txt_FilasMatriz2.setVisible(false);
        this.operaciones.txt_ColumnasMatriz2.setVisible(false);
        this.operaciones.lb_MatrizB.setVisible(false);
        this.operaciones.tbl_Matriz2.setVisible(false);
   
    }

    @Override
    public void actionPerformed(ActionEvent event) {  
      switch(event.getActionCommand()){
            case "suma":
                elementosDosMatrices();
                break;
            case "MultEsc":
                 elementos();
                this.operaciones.txt_Escalar.setVisible(true);
                this.operaciones.lb_Escalar.setVisible(true);
                break;
            case "Multiplicar":
                   elementosDosMatrices();
                break;
            case "SistEc":
                 elementos();
                break;
            case "Determinante":
                elementos();
                break;
            case "SistEcCramer":
                 elementos();
                break;
            case "InvGauss":
                elementos();
                break;
            case "Generar":
                generarMatrices();
                break;
      }
    }
}
