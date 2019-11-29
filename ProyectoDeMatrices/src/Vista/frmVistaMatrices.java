package Vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANJ
 */
public class frmVistaMatrices extends javax.swing.JFrame {
    
    /** Creates new form frmVistaMatrices */
    public frmVistaMatrices() {
        initComponents();
        inicializarTablas();
        ocultarElementos();
    }
    
    private void inicializarTablas(){
        modeloA.setColumnCount(2);
        modeloB.setColumnCount(2);
        modeloC.setColumnCount(2);
        
        modeloA.setRowCount(2);
        modeloB.setRowCount(2);
        modeloC.setRowCount(2);
        
        tbl_MatrizA.setModel(modeloA);
        tbl_MatrizB.setModel(modeloB);
        tbl_Resultado.setModel(modeloC);
        
        rb_Ninguno.setSelected(true);
    }
    
    private void ocultarElementos(){
        txt_Escalar.setVisible(false);
        lb_Escalar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rb_Suma = new javax.swing.JRadioButton();
        rb_MultEsc = new javax.swing.JRadioButton();
        rb_Multiplicar = new javax.swing.JRadioButton();
        rb_InvGauss = new javax.swing.JRadioButton();
        rb_SistEc = new javax.swing.JRadioButton();
        rb_Determinante = new javax.swing.JRadioButton();
        rb_SistEcCramer = new javax.swing.JRadioButton();
        lb_MatrizA = new javax.swing.JLabel();
        lb_MatrizB = new javax.swing.JLabel();
        lb_Filas = new javax.swing.JLabel();
        lb_Columnas = new javax.swing.JLabel();
        lb_Filas2 = new javax.swing.JLabel();
        lb_Columnas2 = new javax.swing.JLabel();
        txt_Filas = new javax.swing.JTextField();
        txt_Columnas = new javax.swing.JTextField();
        txt_Filas2 = new javax.swing.JTextField();
        txt_Columnas2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_MatrizA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Resultado = new javax.swing.JTable();
        rb_Ninguno = new javax.swing.JRadioButton();
        lb_Titulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_MatrizB = new javax.swing.JTable();
        lb_Resultado = new javax.swing.JLabel();
        btn_Generar = new javax.swing.JButton();
        txt_Escalar = new javax.swing.JTextField();
        lb_Escalar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rb_Suma);
        rb_Suma.setText("Sumar");
        rb_Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_SumaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_MultEsc);
        rb_MultEsc.setText("Multiplicar por escalar");
        rb_MultEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_MultEscActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_Multiplicar);
        rb_Multiplicar.setText("Multiplicar");
        rb_Multiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_MultiplicarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_InvGauss);
        rb_InvGauss.setText("Inv.Gauss-Jordan");
        rb_InvGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_InvGaussActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_SistEc);
        rb_SistEc.setText("Sistema de Ecuaciones");
        rb_SistEc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_SistEcActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_Determinante);
        rb_Determinante.setText("Determinante");
        rb_Determinante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_DeterminanteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_SistEcCramer);
        rb_SistEcCramer.setText("Sist. de Ec. por Cramer");
        rb_SistEcCramer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_SistEcCramerActionPerformed(evt);
            }
        });

        lb_MatrizA.setText("Matriz A");

        lb_MatrizB.setText("Matriz B");

        lb_Filas.setText("Filas");

        lb_Columnas.setText("Columnas");

        lb_Filas2.setText("Filas");

        lb_Columnas2.setText("Columnas");

        tbl_MatrizA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_MatrizA);

        tbl_Resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_Resultado);

        buttonGroup1.add(rb_Ninguno);
        rb_Ninguno.setText("Ninguno");

        lb_Titulo.setText("Calculadora de Matrices");

        tbl_MatrizB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_MatrizB);

        lb_Resultado.setText("Resultado");

        btn_Generar.setText("Generar Matriz (ces)");
        btn_Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerarActionPerformed(evt);
            }
        });

        lb_Escalar.setText("Escalar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_Suma)
                    .addComponent(rb_Ninguno)
                    .addComponent(rb_SistEc)
                    .addComponent(rb_MultEsc)
                    .addComponent(rb_Multiplicar)
                    .addComponent(rb_Determinante)
                    .addComponent(rb_SistEcCramer)
                    .addComponent(rb_InvGauss)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_Columnas)
                                            .addComponent(lb_Filas))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Filas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_Columnas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lb_MatrizA)
                                        .addGap(98, 98, 98)
                                        .addComponent(lb_Escalar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Escalar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lb_Titulo))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Resultado)
                                    .addComponent(lb_MatrizB)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_Columnas2)
                                            .addComponent(lb_Filas2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Filas2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_Columnas2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btn_Generar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_Resultado)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rb_Ninguno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_Suma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_MultEsc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_Multiplicar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_SistEc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_Determinante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_SistEcCramer))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_InvGauss)
                .addGap(3, 3, 3)
                .addComponent(btn_Generar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MatrizA)
                    .addComponent(lb_MatrizB)
                    .addComponent(txt_Escalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Escalar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Filas)
                    .addComponent(txt_Filas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Filas2)
                    .addComponent(txt_Filas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Columnas)
                    .addComponent(txt_Columnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Columnas2)
                    .addComponent(txt_Columnas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerarActionPerformed
        // TODO add your handling code here:
        try{
            int FilasA = Integer.parseInt(txt_Filas.getText());
            int ColumnasA = Integer.parseInt(txt_Columnas.getText());
            
            if(rb_Suma.isSelected() == true){
                int FilasB = Integer.parseInt(txt_Filas2.getText());
                int ColumnasB = Integer.parseInt(txt_Columnas2.getText());
                boolean sePuede = (FilasA == FilasB) && (ColumnasA == ColumnasB);
                if(sePuede){
                    generarTablaA(FilasA, ColumnasA);
                    generarTablaB(FilasB, ColumnasB);
                    generarTablaResultado(FilasA, ColumnasA);
                } else {
                   JOptionPane.showMessageDialog(null,"Las matrices deben tener la misma dimension"); 
                }
            }

            if(rb_MultEsc.isSelected() == true){
                elementos();
                txt_Escalar.setVisible(true);
                lb_Escalar.setVisible(true);
                generarTablaA(FilasA, ColumnasA);
                generarTablaResultado(FilasA, ColumnasA);
            }

            if(rb_Multiplicar.isSelected() == true){
                int FilasB = Integer.parseInt(txt_Filas2.getText());
                int ColumnasB = Integer.parseInt(txt_Columnas2.getText());
                elementosDosMatrices();
                boolean sePuede =(ColumnasA == FilasB);
                if(sePuede){
                    generarTablaA(FilasA, ColumnasA);
                    generarTablaB(FilasB, ColumnasB);
                    generarTablaResultado(FilasA, ColumnasB);
                } else {
                   JOptionPane.showMessageDialog(null,"La cantidad de columnas de la Matriz A debe ser igual a la cantidad de filas de la Matriz B"); 
                }

            }
            boolean operacionSingular = rb_SistEc.isSelected() || rb_Determinante.isSelected() || rb_SistEcCramer.isSelected() || rb_InvGauss.isSelected();
            if(operacionSingular == true){
                elementos();
                generarTablaA(FilasA, ColumnasA);
                generarTablaResultado(FilasA, ColumnasA);
            }

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Debe ingresar datos numericos en los campos de Fila(s) y Columna(s)");
        }
    }//GEN-LAST:event_btn_GenerarActionPerformed

    private void rb_SumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_SumaActionPerformed
        // TODO add your handling code here:
        elementosDosMatrices();
    }//GEN-LAST:event_rb_SumaActionPerformed

    private void rb_MultEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_MultEscActionPerformed
        // TODO add your handling code here:
        elementos();
        txt_Escalar.setVisible(true);
        lb_Escalar.setVisible(true);
    }//GEN-LAST:event_rb_MultEscActionPerformed

    private void rb_MultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_MultiplicarActionPerformed
        // TODO add your handling code here:
        elementosDosMatrices();
    }//GEN-LAST:event_rb_MultiplicarActionPerformed

    private void rb_SistEcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_SistEcActionPerformed
        // TODO add your handling code here:
        elementos();
    }//GEN-LAST:event_rb_SistEcActionPerformed

    private void rb_DeterminanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_DeterminanteActionPerformed
        // TODO add your handling code here:
        elementos();
    }//GEN-LAST:event_rb_DeterminanteActionPerformed

    private void rb_SistEcCramerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_SistEcCramerActionPerformed
        // TODO add your handling code here:
        elementos();
    }//GEN-LAST:event_rb_SistEcCramerActionPerformed

    private void rb_InvGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_InvGaussActionPerformed
        // TODO add your handling code here:
        elementos();
    }//GEN-LAST:event_rb_InvGaussActionPerformed

    DefaultTableModel modeloA = new DefaultTableModel(); 
    DefaultTableModel modeloB = new DefaultTableModel();
    DefaultTableModel modeloC = new DefaultTableModel();
    
    private void elementos(){
        txt_Escalar.setVisible(false);
        lb_Escalar.setVisible(false);
        lb_Filas2.setVisible(false);
        lb_Columnas2.setVisible(false);
        txt_Filas2.setVisible(false);
        txt_Columnas2.setVisible(false);
        lb_MatrizB.setVisible(false);
        tbl_MatrizB.setVisible(false);
    }
    
    private void elementosDosMatrices(){
        txt_Escalar.setVisible(false);
        lb_Escalar.setVisible(false);
        lb_Filas2.setVisible(true);
        lb_Columnas2.setVisible(true);
        txt_Filas2.setVisible(true);
        txt_Columnas2.setVisible(true);
        lb_MatrizB.setVisible(true);
        tbl_MatrizB.setVisible(true);
    }
    
    private void generarTablaA(int filas,int columnas){
        modeloA.setRowCount(filas);
        modeloA.setColumnCount(columnas);
        tbl_MatrizA.setModel(modeloA);
    }
    private void generarTablaB(int filas,int columnas){
        modeloB.setRowCount(filas);
        modeloB.setColumnCount(columnas);
        tbl_MatrizB.setModel(modeloB);
    }
    private void generarTablaResultado(int filas,int columnas){
        modeloC.setColumnCount(columnas);
        modeloC.setRowCount(filas);
        tbl_Resultado.setModel(modeloC);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVistaMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVistaMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVistaMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVistaMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmVistaMatrices vista = new frmVistaMatrices();
                vista.setLocationRelativeTo(null);
                vista.setResizable(false);
                vista.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Generar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_Columnas;
    private javax.swing.JLabel lb_Columnas2;
    private javax.swing.JLabel lb_Escalar;
    private javax.swing.JLabel lb_Filas;
    private javax.swing.JLabel lb_Filas2;
    private javax.swing.JLabel lb_MatrizA;
    private javax.swing.JLabel lb_MatrizB;
    private javax.swing.JLabel lb_Resultado;
    private javax.swing.JLabel lb_Titulo;
    private javax.swing.JRadioButton rb_Determinante;
    private javax.swing.JRadioButton rb_InvGauss;
    private javax.swing.JRadioButton rb_MultEsc;
    private javax.swing.JRadioButton rb_Multiplicar;
    private javax.swing.JRadioButton rb_Ninguno;
    private javax.swing.JRadioButton rb_SistEc;
    private javax.swing.JRadioButton rb_SistEcCramer;
    private javax.swing.JRadioButton rb_Suma;
    private javax.swing.JTable tbl_MatrizA;
    private javax.swing.JTable tbl_MatrizB;
    private javax.swing.JTable tbl_Resultado;
    private javax.swing.JTextField txt_Columnas;
    private javax.swing.JTextField txt_Columnas2;
    private javax.swing.JTextField txt_Escalar;
    private javax.swing.JTextField txt_Filas;
    private javax.swing.JTextField txt_Filas2;
    // End of variables declaration//GEN-END:variables

}
