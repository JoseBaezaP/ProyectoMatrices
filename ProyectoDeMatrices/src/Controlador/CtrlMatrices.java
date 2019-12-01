package Controlador;
import Vista.frmVistaMatrices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ModeloMatriz;
import Modelo.OperacionesBasicasMatrices;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josebaeza
 */
public class CtrlMatrices implements ActionListener{
    
    frmVistaMatrices vistaMatrices;
    OperacionesBasicasMatrices operaciones = new OperacionesBasicasMatrices();
    
    /**
     *
     */
    public CtrlMatrices(){
        this.vistaMatrices = new frmVistaMatrices();
        inicializar();
        inicializarTablas();
        mostrarElementosDosMatrices();
    }

    /**
     *
     */
    public void inicializar(){
        this.vistaMatrices.rb_Suma.addActionListener(this);
        this.vistaMatrices.rb_Suma.setActionCommand("Suma");
        this.vistaMatrices.rb_InvGauss.addActionListener(this);
        this.vistaMatrices.rb_InvGauss.setActionCommand("InvGauss");
        this.vistaMatrices.rb_MultEsc.addActionListener(this);
        this.vistaMatrices.rb_MultEsc.setActionCommand("MultEsc");
        this.vistaMatrices.rb_Multiplicar.addActionListener(this);
        this.vistaMatrices.rb_Multiplicar.setActionCommand("Multiplicacion");
        this.vistaMatrices.rb_SistEc.addActionListener(this);
        this.vistaMatrices.rb_SistEc.setActionCommand("SistEc");
        this.vistaMatrices.rb_Determinante.addActionListener(this);
        this.vistaMatrices.rb_Determinante.setActionCommand("Determinante");
        this.vistaMatrices.rb_SistEcCramer.addActionListener(this);
        this.vistaMatrices.rb_SistEcCramer.setActionCommand("SistEcCramer");
        this.vistaMatrices.btn_Generar.addActionListener(this);
        this.vistaMatrices.btn_Generar.setActionCommand("Generar");
        this.vistaMatrices.btn_Operacion.addActionListener(this);
        this.vistaMatrices.btn_Operacion.setActionCommand("Operacion");
        this.vistaMatrices.setVisible(true);
        this.vistaMatrices.setLocationRelativeTo(null);
    }
    
    /**
     *
     */
    public void inicializarTablas(){   
        DefaultTableModel modeloA = new DefaultTableModel(); 
        DefaultTableModel modeloB = new DefaultTableModel();
        DefaultTableModel modeloC = new DefaultTableModel();
        modeloA.setColumnCount(0);
        modeloB.setColumnCount(0);
        modeloC.setColumnCount(0);
        modeloA.setRowCount(0);
        modeloB.setRowCount(0);
        modeloC.setRowCount(0);

        this.vistaMatrices.tbl_MatrizA.setModel(modeloA);
        this.vistaMatrices.tbl_MatrizB.setModel(modeloB);
        this.vistaMatrices.tbl_Resultado.setModel(modeloC);

        this.vistaMatrices.rb_Suma.setSelected(true);
    }
    
    /**
     *
     */
    
    public void generarMatrices(){
        try{
            ModeloMatriz modelo = new ModeloMatriz();
            int filasMatrizA = Integer.parseInt(this.vistaMatrices.txt_FilasMatrizA.getText());
            int columnasMatrizA = Integer.parseInt(this.vistaMatrices.txt_ColumnasMatrizA.getText());
            boolean operacionUnaMatriz = this.vistaMatrices.rb_SistEc.isSelected() || this.vistaMatrices.rb_InvGauss.isSelected() || this.vistaMatrices.rb_MultEsc.isSelected();
            
            if(operacionUnaMatriz){
                modelo.generarMatrizA(Integer.parseInt(this.vistaMatrices.txt_FilasMatrizA.getText()),
                                      Integer.parseInt(this.vistaMatrices.txt_ColumnasMatrizA.getText()));
                this.vistaMatrices.tbl_MatrizA.setModel(modelo.getMatrizA());
                this.vistaMatrices.tbl_Resultado.setModel(modelo.getMatrizResultante());
            }
            
            if(this.vistaMatrices.rb_Determinante.isSelected()){
                modelo.validarOperacion(filasMatrizA, columnasMatrizA, "Determinante");
                this.vistaMatrices.tbl_MatrizA.setModel(modelo.getMatrizA());
                this.vistaMatrices.tbl_Resultado.setModel(modelo.getMatrizResultante());
            }
            
            if(this.vistaMatrices.rb_SistEcCramer.isSelected()){
                modelo.validarOperacion(filasMatrizA, columnasMatrizA, "SistEcCramer");
                this.vistaMatrices.tbl_MatrizA.setModel(modelo.getMatrizA());
                this.vistaMatrices.tbl_Resultado.setModel(modelo.getMatrizResultante());
            }
            
            if(this.vistaMatrices.rb_Suma.isSelected() == true){
                int filasMatrizB = Integer.parseInt(this.vistaMatrices.txt_FilasMatrizB.getText());
                int columnasMatrizB = Integer.parseInt(this.vistaMatrices.txt_ColumnasMatrizB.getText());
                modelo.validarOperacionDosMatrices(filasMatrizA,columnasMatrizA, filasMatrizB, columnasMatrizB,"Suma");
                this.vistaMatrices.tbl_MatrizA.setModel(modelo.getMatrizA());
                this.vistaMatrices.tbl_MatrizB.setModel(modelo.getMatrizB());
                this.vistaMatrices.tbl_Resultado.setModel(modelo.getMatrizResultante());
            }
            
            if(this.vistaMatrices.rb_Multiplicar.isSelected() == true){
                int filasMatrizB = Integer.parseInt(this.vistaMatrices.txt_FilasMatrizB.getText());
                int columnasMatrizB = Integer.parseInt(this.vistaMatrices.txt_ColumnasMatrizB.getText());
                modelo.validarOperacionDosMatrices(filasMatrizA,columnasMatrizA, filasMatrizB, columnasMatrizB,"Multiplicacion");
                this.vistaMatrices.tbl_MatrizA.setModel(modelo.getMatrizA());
                this.vistaMatrices.tbl_MatrizB.setModel(modelo.getMatrizB());
                this.vistaMatrices.tbl_Resultado.setModel(modelo.getMatrizResultante());
            } 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar datos numericos en los campos de Fila(s) y Columna(s)");
        }
        
        
    }
    
    /**
     *
     */
    public void mostrarElementosDosMatrices(){   
        this.vistaMatrices.lb_Escalar.setVisible(false);
        this.vistaMatrices.txt_Escalar.setVisible(false);
        this.vistaMatrices.lb_Filas2.setVisible(true);
        this.vistaMatrices.lb_Columnas2.setVisible(true);
        this.vistaMatrices.txt_FilasMatrizB.setVisible(true);
        this.vistaMatrices.txt_ColumnasMatrizB.setVisible(true);
        this.vistaMatrices.lb_MatrizB.setVisible(true);
        this.vistaMatrices.tbl_MatrizB.setVisible(true);
        this.vistaMatrices.txt_Determinante.setVisible(false);
        this.vistaMatrices.lb_Determinante.setVisible(false);
        this.vistaMatrices.lb_Resultado.setVisible(true);
        this.vistaMatrices.tbl_Resultado.setVisible(true);
    }
    
    private void mostrarElementosUnaMatriz(){
        this.vistaMatrices.txt_Determinante.setVisible(false);
        this.vistaMatrices.lb_Determinante.setVisible(false);
        this.vistaMatrices.txt_Escalar.setVisible(false);
        this.vistaMatrices.lb_Escalar.setVisible(false);
        this.vistaMatrices.lb_Filas2.setVisible(false);
        this.vistaMatrices.lb_Columnas2.setVisible(false);
        this.vistaMatrices.txt_FilasMatrizB.setVisible(false);
        this.vistaMatrices.txt_ColumnasMatrizB.setVisible(false);
        this.vistaMatrices.lb_MatrizB.setVisible(false);
        this.vistaMatrices.tbl_MatrizB.setVisible(false);
        this.vistaMatrices.lb_Resultado.setVisible(true);
        this.vistaMatrices.tbl_Resultado.setVisible(true);
    }

    private double[][] recolectarDatosMatrizA(){
        int filas = this.vistaMatrices.tbl_MatrizA.getRowCount();
        int columnas = this.vistaMatrices.tbl_MatrizA.getColumnCount();
        double[][] datosMatrizA = new double[filas][columnas];
        try{
            for(int i = 0; i < filas; i++){
                for(int j = 0; j < columnas; j++){
                    datosMatrizA[i][j] = Integer.parseInt(this.vistaMatrices.tbl_MatrizA.getModel().getValueAt(i, j).toString());
                }
            }
        } catch(NullPointerException exception){
            JOptionPane.showMessageDialog(null,"No todas las celdas de la Matriz A estan llenas o una celda de la matriz esta seleccionada, por favor verifique sus datos"); 
        }
        return datosMatrizA;
    }
    
    private double[][] recolectarDatosMatrizB(){
        int filas = this.vistaMatrices.tbl_MatrizB.getRowCount();
        int columnas = this.vistaMatrices.tbl_MatrizB.getColumnCount();
        double[][] datosMatrizB= new double[filas][columnas];
        try{
            for(int i = 0; i < filas; i++){
                for(int j = 0; j < columnas; j++){
                    datosMatrizB[i][j] = Integer.parseInt(this.vistaMatrices.tbl_MatrizB.getModel().getValueAt(i, j).toString());
                }
            }
        }catch(NullPointerException exception){
            JOptionPane.showMessageDialog(null,"No todas las celdas de la Matriz B estan llenas o una celda de la matriz esta seleccionada, por favor verifique sus datos"); 
        }
        return datosMatrizB;
    }
    
    private void mostrarMatrizResultado(double[][] matriz){
        int filas = this.vistaMatrices.tbl_Resultado.getRowCount();
        int columnas = this.vistaMatrices.tbl_Resultado.getColumnCount();
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                this.vistaMatrices.tbl_Resultado.getModel().setValueAt(matriz[i][j], i, j);
            }
        }                
    }
    
    private void seleccionarOperacion(){
        
        if(this.vistaMatrices.rb_Suma.isSelected() == true){
            double[][] matrizResultado = operaciones.suma(recolectarDatosMatrizA(), recolectarDatosMatrizB());
            mostrarMatrizResultado(matrizResultado);
        }
        
        if(this.vistaMatrices.rb_MultEsc.isSelected() == true){
            double[][] matrizResultado = operaciones.multiplicacionEscalar(recolectarDatosMatrizA(), Double.parseDouble(this.vistaMatrices.txt_Escalar.getText()));
            mostrarMatrizResultado(matrizResultado);
        }
        
        if(this.vistaMatrices.rb_Multiplicar.isSelected() == true){
            double[][] matrizResultado = operaciones.multiplicacion(recolectarDatosMatrizA(), recolectarDatosMatrizB());
            mostrarMatrizResultado(matrizResultado);
        }
        
        if(this.vistaMatrices.rb_SistEc.isSelected() == true){
            
        }
        
        if(this.vistaMatrices.rb_Determinante.isSelected() == true){
            double determinante = operaciones.calcularDeterminante(recolectarDatosMatrizA());
            this.vistaMatrices.txt_Determinante.setText(String.valueOf(determinante));
        }
        
        if(this.vistaMatrices.rb_SistEcCramer.isSelected() == true){
          /*  ArrayList<Double> vectordeSoluciones=new ArrayList<Double>();
            vectordeSoluciones=(ArrayList) operaciones.metodoDeCramer(recolectarDatosMatrizA()).clone();*/
            double[][] matrizResultado = operaciones.metodoDeCramer(recolectarDatosMatrizA());
            mostrarMatrizResultado(matrizResultado);
        }
        
        if(this.vistaMatrices.rb_InvGauss.isSelected() == true){
            System.out.println("here");
            double[][] matrizResultado = operaciones.invert(recolectarDatosMatrizA());
            mostrarMatrizResultado(matrizResultado);
            System.out.println("not here");
        }
    }
    
    /**
     *
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {  
        switch(event.getActionCommand()){
            case "Suma":
                mostrarElementosDosMatrices();
                break;
            case "MultEsc":
                mostrarElementosUnaMatriz();
                this.vistaMatrices.txt_Escalar.setVisible(true);
                this.vistaMatrices.lb_Escalar.setVisible(true);
                break;
            case "Multiplicacion":
                   mostrarElementosDosMatrices();
                break;
            case "SistEc":
                mostrarElementosUnaMatriz();
                break;
            case "Determinante":
                mostrarElementosUnaMatriz();
                this.vistaMatrices.txt_Determinante.setVisible(true);
                this.vistaMatrices.lb_Determinante.setVisible(true);
                this.vistaMatrices.lb_Resultado.setVisible(false);
                this.vistaMatrices.tbl_Resultado.setVisible(false);
                break;
            case "SistEcCramer":
                mostrarElementosUnaMatriz();
                break;
            case "InvGauss":
                mostrarElementosUnaMatriz();
                break;
            case "Generar":
                generarMatrices();
                break;
            case "Operacion":
                seleccionarOperacion();
                break;
        }
    }
}
