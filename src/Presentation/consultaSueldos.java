package Presentation;

import controllers.Factory;
import dataTypes.DtEmpleado;
import dataTypes.DtSueldo;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class consultaSueldos extends javax.swing.JInternalFrame {

    private List<DtSueldo> sueldos;
    private List<DtEmpleado> empleados;

    public consultaSueldos() {
        initComponents();
    }

    public void initializeComponents() {
        cmbEmpleados.setEnabled(false);
        chbEmpleado.setSelected(false);
        calendarDesde.setEnabled(false);
        calendarHasta.setEnabled(false);
        chbRangoFecha.setSelected(false);
        txtSueldoDesde.setEnabled(false);
        txtSueldoHasta.setEnabled(false);
        chbRangoSueldo.setSelected(false);
        limpiarCampos();
        cleanTable();
        buildTable();
        buildCmbEmpleados();
    }

    public void setSueldos(List<DtSueldo> suel) {
        sueldos = suel;
    }

    public void setEmpleados(List<DtEmpleado> emp) {
        empleados = emp;
    }

    private void buildTable() {
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0); //Reinicializa el contador de filas
        Object rowData[] = new Object[6];
        for (int i = 0; i < sueldos.size(); i++) {
            rowData[0] = sueldos.get(i).getIdSueldo();
            rowData[1] = sueldos.get(i).getIdEmpleado();
            rowData[2] = sueldos.get(i).getNombreEmpleado();
            rowData[3] = sueldos.get(i).getMonto();
            rowData[4] = sueldos.get(i).getFechaApertura();
            rowData[5] = sueldos.get(i).getFechaCierre();
            model.addRow(rowData);
        }
        resultTable.getColumnModel().getColumn(1).setMinWidth(0);
        resultTable.getColumnModel().getColumn(1).setMaxWidth(0);
        resultTable.getColumnModel().getColumn(1).setWidth(0);
        
        resultTable.getColumnModel().getColumn(0).setMinWidth(0);
        resultTable.getColumnModel().getColumn(0).setMaxWidth(0);
        resultTable.getColumnModel().getColumn(0).setWidth(0);
    }

    private void limpiarCampos() {
        calendarDesde.setDate(new Date());
        calendarHasta.setDate(new Date());
        txtSueldoDesde.setText("");
        txtSueldoHasta.setText("");
    }

    private void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0);
    }

    private void buildCmbEmpleados() {
        String[] array = new String[empleados.size()];
        String[] array2 = new String[empleados.size() + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = empleados.get(i).getId() + " - " + empleados.get(i).getNombre();
            array2[i + 1] = array[i];
        }
        array2[0] = "Seleccione Empleado";
        JComboBox comboBox = new JComboBox(array2);
        cmbEmpleados.setModel(comboBox.getModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        chbRangoFecha = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        calendarDesde = new com.toedter.calendar.JDateChooser();
        calendarHasta = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        chbEmpleado = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        chbRangoSueldo = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtSueldoDesde = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSueldoHasta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Consulta Sueldos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personalizar Consulta"));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chbRangoFecha.setText("Rango Fecha de Pago");
        chbRangoFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbRangoFechaItemStateChanged(evt);
            }
        });

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        calendarDesde.setDateFormatString("yyyy-MM-dd");

        calendarHasta.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(calendarDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chbRangoFecha)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(calendarHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chbRangoFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(calendarDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(calendarHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chbEmpleado.setText("Empleado");
        chbEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbEmpleadoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Empleado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEmpleados, 0, 163, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chbEmpleado)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chbEmpleado)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chbRangoSueldo.setText("Rango Sueldos");
        chbRangoSueldo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbRangoSueldoItemStateChanged(evt);
            }
        });
        chbRangoSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbRangoSueldoActionPerformed(evt);
            }
        });

        jLabel4.setText("Sueldo Desde");

        jLabel5.setText("Sueldo Hasta");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtSueldoDesde))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(chbRangoSueldo)
                        .addGap(0, 130, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtSueldoHasta)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chbRangoSueldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSueldoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSueldoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFiltrar.setText("Filtrar Sueldos");
        btnFiltrar.setToolTipText("");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Campos");

        btnDetalle.setText("Ver Detalle Sueldo");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 300));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Sueldos"));

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_SUELDO", "ID_EMPLEADO", "EMPLEADO", "MONTO", "FECHA_APERTURA", "FECHA_CIERRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultTable);
        if (resultTable.getColumnModel().getColumnCount() > 0) {
            resultTable.getColumnModel().getColumn(0).setResizable(false);
            resultTable.getColumnModel().getColumn(1).setResizable(false);
            resultTable.getColumnModel().getColumn(2).setResizable(false);
            resultTable.getColumnModel().getColumn(3).setResizable(false);
            resultTable.getColumnModel().getColumn(4).setResizable(false);
            resultTable.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 720, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbRangoFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbRangoFechaItemStateChanged
        if (chbRangoFecha.isSelected()) {
            calendarDesde.setEnabled(true);
            calendarDesde.getDateEditor().setEnabled(false);
            calendarHasta.setEnabled(true);
            calendarHasta.getDateEditor().setEnabled(false);
        } else {
            calendarDesde.setEnabled(false);
            calendarHasta.setEnabled(false);
        }
    }//GEN-LAST:event_chbRangoFechaItemStateChanged

    private void chbEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbEmpleadoItemStateChanged
        if (chbEmpleado.isSelected()) {
            cmbEmpleados.setEnabled(true);
        } else {
            cmbEmpleados.setEnabled(false);
        }
    }//GEN-LAST:event_chbEmpleadoItemStateChanged

    private void chbRangoSueldoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbRangoSueldoItemStateChanged
        if (chbRangoSueldo.isSelected()) {
            txtSueldoDesde.setEnabled(true);
            txtSueldoHasta.setEnabled(true);
        } else {
            txtSueldoDesde.setEnabled(false);
            txtSueldoHasta.setEnabled(false);
        }
    }//GEN-LAST:event_chbRangoSueldoItemStateChanged

    private void chbRangoSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbRangoSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbRangoSueldoActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        if (resultTable.getSelectedRow() != -1) {

            int idEmpleado = Integer.parseInt(resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 1).toString());
            int idSueldo = Integer.parseInt(resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 0).toString());
            String monto = resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 3).toString().trim();
            String nomEmpleado = resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 2).toString().trim();
            String fechaApertura = resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 4).toString().trim();
            String fechaCierre = resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 5).toString().trim();
            String nomDocumento = idEmpleado + "_" + idSueldo + "_" + nomEmpleado + "_" + fechaApertura + "_" + fechaCierre + ".pdf";

            try {
                File midir = new File(".");
                String path = midir.getCanonicalPath();
                String pathDefinitivo = path + "\\sueldos\\" + nomDocumento;
                Factory.getInstance().getIOperations().generarFactura(idEmpleado, idSueldo, monto, nomEmpleado, fechaApertura, fechaCierre);
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + pathDefinitivo);
            } catch (SQLException ex) {
                Logger.getLogger(consultaSueldos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(consultaSueldos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un sueldo de la tabla!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        int idEmpleado = 0;
        int idCliente = 0;
        String sueldoDesde = "0";
        String sueldoHasta = "0";
        if (chbEmpleado.isSelected()) {
            if (cmbEmpleados.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado!", "Mensajeria Rivera",
                        JOptionPane.WARNING_MESSAGE);
                initializeComponents();
            } else {
                String[] partsEmpleado = cmbEmpleados.getSelectedItem().toString().trim().split("-");
                idEmpleado = Integer.parseInt(partsEmpleado[0].trim());
            }
        }
        
        if(chbRangoSueldo.isSelected()){
            sueldoDesde = txtSueldoDesde.getText().trim();
            sueldoHasta = txtSueldoHasta.getText().trim();
            if(sueldoDesde.equals("") || sueldoHasta.equals("")){
                JOptionPane.showMessageDialog(null, "Los rangos no pueden estar vacios!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
                initializeComponents();
            }
            else if(Float.parseFloat(sueldoDesde) > Float.parseFloat(sueldoHasta)){
                JOptionPane.showMessageDialog(null, "El sueldo desde no puede ser mayor que el sueldo hasta!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
                initializeComponents();                
                }
        }

        try {
            sueldos = Factory.getInstance().getIOperations().filtrarSueldos(chbEmpleado.isSelected(), chbRangoFecha.isSelected(), chbRangoSueldo.isSelected(), idEmpleado, ((JTextField) calendarDesde.getDateEditor().getUiComponent()).getText().trim(), ((JTextField) calendarHasta.getDateEditor().getUiComponent()).getText().trim(), Float.parseFloat(sueldoDesde), Float.parseFloat(sueldoHasta));
        } catch (SQLException ex) {
            Logger.getLogger(consultaEntregas.class.getName()).log(Level.SEVERE, null, ex);
        }

        cleanTable();
        buildTable();
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser calendarDesde;
    private com.toedter.calendar.JDateChooser calendarHasta;
    private javax.swing.JCheckBox chbEmpleado;
    private javax.swing.JCheckBox chbRangoFecha;
    private javax.swing.JCheckBox chbRangoSueldo;
    private javax.swing.JComboBox<String> cmbEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtSueldoDesde;
    private javax.swing.JTextField txtSueldoHasta;
    // End of variables declaration//GEN-END:variables
}
