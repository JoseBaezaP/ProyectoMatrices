package Vista;
/**
 * Clase frmVistaMatrices vista de la aplicacion.
 *
 * @author carlosavila
 * @author leonardohernandez
 * @author josebaeza
 * @author nicolasgala
 * @version 1.0
 */
public class frmVistaMatrices extends javax.swing.JFrame {
     /**
     * 
     * Constructor para la vista de las matrices
     * 
     */
    public frmVistaMatrices() {
        initComponents();
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
        txt_FilasMatrizA = new javax.swing.JTextField();
        txt_ColumnasMatrizA = new javax.swing.JTextField();
        txt_FilasMatrizB = new javax.swing.JTextField();
        txt_ColumnasMatrizB = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_MatrizA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Resultado = new javax.swing.JTable();
        lb_Titulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_MatrizB = new javax.swing.JTable();
        lb_Resultado = new javax.swing.JLabel();
        btn_Generar = new javax.swing.JButton();
        txt_Escalar = new javax.swing.JTextField();
        lb_Escalar = new javax.swing.JLabel();
        lb_Determinante = new javax.swing.JLabel();
        txt_Determinante = new javax.swing.JTextField();
        btn_Operacion = new javax.swing.JButton();

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

        txt_FilasMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FilasMatrizAActionPerformed(evt);
            }
        });

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

        lb_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
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

        lb_Determinante.setText("Determinante");

        btn_Operacion.setText("Operacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rb_InvGauss)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lb_Columnas)
                                                .addComponent(lb_Filas))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_FilasMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_ColumnasMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn_Generar)
                                                .addComponent(lb_MatrizA))
                                            .addGap(4, 4, 4)
                                            .addComponent(btn_Operacion)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lb_Escalar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_Escalar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lb_Titulo)
                            .addGap(66, 66, 66)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_Suma)
                            .addComponent(rb_SistEc)
                            .addComponent(rb_MultEsc)
                            .addComponent(rb_Multiplicar)
                            .addComponent(rb_Determinante)
                            .addComponent(rb_SistEcCramer))
                        .addGap(258, 258, 258)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_MatrizB)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Columnas2)
                                    .addComponent(lb_Filas2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_FilasMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ColumnasMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Resultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_Determinante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Determinante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lb_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Resultado)
                            .addComponent(lb_Determinante)
                            .addComponent(txt_Determinante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(rb_SistEcCramer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_InvGauss)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Generar)
                            .addComponent(btn_Operacion)
                            .addComponent(lb_Escalar)
                            .addComponent(txt_Escalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MatrizA)
                    .addComponent(lb_MatrizB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Filas)
                    .addComponent(txt_FilasMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Filas2)
                    .addComponent(txt_FilasMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Columnas)
                    .addComponent(txt_ColumnasMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Columnas2)
                    .addComponent(txt_ColumnasMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerarActionPerformed
      
    }//GEN-LAST:event_btn_GenerarActionPerformed

    private void rb_SumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_SumaActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_rb_SumaActionPerformed

    private void rb_MultEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_MultEscActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_rb_MultEscActionPerformed

    private void rb_MultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_MultiplicarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_rb_MultiplicarActionPerformed

    private void rb_SistEcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_SistEcActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rb_SistEcActionPerformed

    private void rb_DeterminanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_DeterminanteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rb_DeterminanteActionPerformed

    private void rb_SistEcCramerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_SistEcCramerActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rb_SistEcCramerActionPerformed

    private void rb_InvGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_InvGaussActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_rb_InvGaussActionPerformed

    private void txt_FilasMatrizAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FilasMatrizAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FilasMatrizAActionPerformed

    /**
     *
     * meto main de la vista que inicializa la vista de la aplicacion y sus elementos
     * 
     * @param args
     */
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
    public javax.swing.JButton btn_Generar;
    public javax.swing.JButton btn_Operacion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_Columnas;
    public javax.swing.JLabel lb_Columnas2;
    public javax.swing.JLabel lb_Determinante;
    public javax.swing.JLabel lb_Escalar;
    private javax.swing.JLabel lb_Filas;
    public javax.swing.JLabel lb_Filas2;
    private javax.swing.JLabel lb_MatrizA;
    public javax.swing.JLabel lb_MatrizB;
    public javax.swing.JLabel lb_Resultado;
    private javax.swing.JLabel lb_Titulo;
    public javax.swing.JRadioButton rb_Determinante;
    public javax.swing.JRadioButton rb_InvGauss;
    public javax.swing.JRadioButton rb_MultEsc;
    public javax.swing.JRadioButton rb_Multiplicar;
    public javax.swing.JRadioButton rb_SistEc;
    public javax.swing.JRadioButton rb_SistEcCramer;
    public javax.swing.JRadioButton rb_Suma;
    public javax.swing.JTable tbl_MatrizA;
    public javax.swing.JTable tbl_MatrizB;
    public javax.swing.JTable tbl_Resultado;
    public javax.swing.JTextField txt_ColumnasMatrizA;
    public javax.swing.JTextField txt_ColumnasMatrizB;
    public javax.swing.JTextField txt_Determinante;
    public javax.swing.JTextField txt_Escalar;
    public javax.swing.JTextField txt_FilasMatrizA;
    public javax.swing.JTextField txt_FilasMatrizB;
    // End of variables declaration//GEN-END:variables

}
