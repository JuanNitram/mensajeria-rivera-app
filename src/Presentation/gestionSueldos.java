/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import controllers.Factory;
import dataTypes.DtEmpleado;
import dataTypes.DtSueldo;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Martin
 */
public class gestionSueldos extends javax.swing.JInternalFrame {

    private List<DtEmpleado> empleados;
    private List<DtSueldo> sueldos;
    
    public gestionSueldos() {
        initComponents();
    }
    public void setEmpleados(List<DtEmpleado> emp){
        empleados = emp;
    }
    
    public void setSueldos(List<DtSueldo> s){
        sueldos = s;
    }
    
    private void buildTable(){
        DefaultTableModel model = (DefaultTableModel) sueldosTable.getModel();
        model.setRowCount(0); //Reinicializa el contador de filas
        Object rowData[] = new Object[4];
        for(int i=0; i<sueldos.size();i++){
            rowData[0] = sueldos.get(i).getNombreEmpleado();
            rowData[1] = sueldos.get(i).getMonto();
            rowData[2] = sueldos.get(i).getFechaApertura().toString();
            rowData[3] = sueldos.get(i).getFechaCierre().toString();
            model.addRow(rowData);
        }
    }
    
    private void buildCmbEmpleados(){
        String[] array = new String[empleados.size()];
        String[] array2 = new String[empleados.size() + 1];
        for(int i = 0; i < array.length; i++) {
            array[i] = empleados.get(i).getId()+" - "+empleados.get(i).getNombre();
            array2[i+1] = array[i];
        }    
        array2[0] = "Seleccione Empleado";
        JComboBox comboBox = new JComboBox(array2);
        cmbEmpleados.setModel(comboBox.getModel());
    }
    
    private void buildComponents() throws SQLException{
        String selectedCmb = cmbEmpleados.getSelectedItem().toString().trim();
        String[] parts = selectedCmb.split("-");
        String empleadoId = parts[0].trim();
        DtEmpleado dtE = Factory.getInstance().getIOperations().getInfoEmpleado(Integer.parseInt(empleadoId));
        txtTelefono.setText(dtE.getTelefono());
        txtDireccion.setText(dtE.getDireccion());
    }
    
    private void limpiarCampos(){
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
    
    public void initializeComponents(){
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        calendarApertura.setEnabled(true);
        calendarApertura.getDateEditor().setEnabled(false);
        calendarCierre.setEnabled(true);
        calendarCierre.getDateEditor().setEnabled(false);
        btnCalcular.setEnabled(true);
        btnLimpiar.setEnabled(true);
        buildCmbEmpleados();
        cleanTable();
        buildTable();
    }
    
    private void cleanTable(){
        DefaultTableModel model = (DefaultTableModel) sueldosTable.getModel();
        model.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        calendarApertura = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        calendarCierre = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sueldosTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Calcular Sueldos"));

        btnCalcular.setText("Calcular Sueldos");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Apertura");

        calendarApertura.setDateFormatString("yyyy-MM-dd");

        jLabel6.setText("Fecha Cierre");

        calendarCierre.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(calendarApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(calendarCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(calendarApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(calendarCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sueldos Empleados"));

        sueldosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPELADO", "MONTO", "FECHA_APERTURA", "FECHA_CIERRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sueldosTable);

        jLabel7.setText("Empleado");

        cmbEmpleados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpleadosItemStateChanged(evt);
            }
        });

        jLabel1.setText("Telefono");

        jLabel2.setText("Direccion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbEmpleados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 730, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if( ((JTextField)calendarApertura.getDateEditor().getUiComponent()).getText().trim().equals(""))
        JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha apertura!", "Mensajeria Rivera",
            JOptionPane.WARNING_MESSAGE);
        else if(((JTextField)calendarCierre.getDateEditor().getUiComponent()).getText().trim().equals(""))
        JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha cierre!", "Mensajeria Rivera",
            JOptionPane.WARNING_MESSAGE);
        else{
            try{
                Factory.getInstance().getIOperations().calcularSueldos(((JTextField)calendarApertura.getDateEditor().getUiComponent()).getText().trim(),((JTextField)calendarCierre.getDateEditor().getUiComponent()).getText().trim());
                sueldos = Factory.getInstance().getIOperations().getSueldos();
                JOptionPane.showMessageDialog(null, "Los sueldos fueron calculados correctamente!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);                
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Se ha producido un error!", "Mensajeria Rivera",
                    JOptionPane.ERROR_MESSAGE);   
                ex.printStackTrace();
            }
            cleanTable();
            buildTable();
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        calendarApertura.setCalendar(null);
        calendarCierre.setCalendar(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cmbEmpleadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpleadosItemStateChanged
        if(cmbEmpleados.getSelectedIndex() != 0){
            try {
                buildComponents();
                String[] partsEmpleado = cmbEmpleados.getSelectedItem().toString().trim().split("-");
                String idEmpleado = partsEmpleado[0].trim();
                sueldos = Factory.getInstance().getIOperations().getSueldosEmpleado(Integer.parseInt(idEmpleado));
                cleanTable();
                buildTable();
            } catch (SQLException ex) {
                Logger.getLogger(gestionPagoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try{
                sueldos = Factory.getInstance().getIOperations().getSueldos();
                cleanTable();
                buildTable();
                limpiarCampos();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmbEmpleadosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser calendarApertura;
    private com.toedter.calendar.JDateChooser calendarCierre;
    private javax.swing.JComboBox<String> cmbEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sueldosTable;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
