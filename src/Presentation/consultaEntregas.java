/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import controllers.Factory;
import dataTypes.DtCliente;
import dataTypes.DtEmpleado;
import dataTypes.DtEntrega;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class consultaEntregas extends javax.swing.JInternalFrame {

    private List<DtEntrega> entregas;
    private List<DtEmpleado> empleados;
    private List<DtCliente> clientes;
    
    public consultaEntregas() {
        initComponents();
    }
    
    public void setEntregas(List<DtEntrega> ent){
        entregas = ent;
    }
    
    public void setEmpleados(List<DtEmpleado> emp){
        empleados = emp;
    }
    
    public void setClientes(List<DtCliente> cli){
        clientes = cli;
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

    private void buildCmbClientes(){
        String[] array = new String[clientes.size()];
        String[] array2 = new String[clientes.size() + 1];
        for(int i = 0; i < array.length; i++) {
            array[i] = clientes.get(i).getId()+" - "+clientes.get(i).getNombre();
            array2[i+1] = array[i];
        }    
        array2[0] = "Seleccione Cliente";
        JComboBox comboBox = new JComboBox(array2);
        cmbClientes.setModel(comboBox.getModel());
    }

    private void buildTable(){
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0); //Reinicializa el contador de filas
        Object rowData[] = new Object[5];
        for(int i=0; i<entregas.size();i++){
            rowData[0] = entregas.get(i).getNombreEmpleado();
            rowData[1] = entregas.get(i).getNombreCliente();
            rowData[2] = entregas.get(i).getCantidad();
            rowData[3] = entregas.get(i).getFechaRecogida();
            rowData[4] = entregas.get(i).getFechaVenc();
            model.addRow(rowData);
        }
        
        resultTable.getColumnModel().getColumn(4).setMinWidth(0);
        resultTable.getColumnModel().getColumn(4).setMaxWidth(0);
        resultTable.getColumnModel().getColumn(4).setWidth(0);
    }

    private void limpiarCampos(){
        calendarDesde.setDate(new Date());
        calendarHasta.setDate(new Date());
    }    
    
    private void cleanTable(){
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0);
    }
    
    public void initializeComponents(){
        cleanTable();
        buildTable();
        buildCmbEmpleados();
        buildCmbClientes();
        limpiarCampos();
        txtSuma.setEditable(false);
        chbEmpleado.setSelected(false);
        chbCliente.setSelected(false);
        chbRango.setSelected(false);
        calendarDesde.setEnabled(false);
        calendarHasta.setEnabled(false);
        cmbEmpleados.setEnabled(false);
        cmbClientes.setEnabled(false);
        btnFiltrar.setEnabled(true);
        btnLimpiar.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        chbRango = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        calendarDesde = new com.toedter.calendar.JDateChooser();
        calendarHasta = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        chbEmpleado = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        chbCliente = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSuma = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Consulta Entregas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personalizar Consulta"));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chbRango.setText("Rango de Fecha Recogida");
        chbRango.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbRangoItemStateChanged(evt);
            }
        });

        jLabel1.setText("Fecha Desde");

        jLabel2.setText("Fecha Hasta");

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
                        .addComponent(calendarDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chbRango)
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
                        .addComponent(chbRango)
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
                        .addComponent(cmbEmpleados, 0, 165, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(253, 104));

        chbCliente.setText("Cliente");
        chbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbClienteItemStateChanged(evt);
            }
        });

        jLabel4.setText("Cliente");

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
                        .addComponent(cmbClientes, 0, 178, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(chbCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chbCliente)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(253, 104));

        jLabel5.setText("Suma Total");

        txtSuma.setEnabled(false);

        btnFiltrar.setText("Filtrar Entregas");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Campos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtSuma, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 270));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLEADO", "CLIENTE", "CANTIDAD", "FECHA_RECOGIDA", "FECHA_VENCIMIENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 720, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        int idEmpleado = 0;
        int idCliente = 0;
            
        if(chbCliente.isSelected()){
            if(cmbClientes.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Debes seleccionar un cliente!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
                initializeComponents();
            }
            else{
                String[] partsCliente = cmbClientes.getSelectedItem().toString().trim().split("-");
                idCliente = Integer.parseInt(partsCliente[0].trim());
            }
        }
            
        if(chbEmpleado.isSelected()){
            if(cmbEmpleados.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
                initializeComponents();
            }
            else{
                String[] partsEmpleado = cmbEmpleados.getSelectedItem().toString().trim().split("-");
                idEmpleado = Integer.parseInt(partsEmpleado[0].trim());            
            }
        }
        
        try {
            entregas =  Factory.getInstance().getIOperations().filtrarEntregas(chbEmpleado.isSelected(),chbCliente.isSelected(),chbRango.isSelected(),idEmpleado,idCliente,
                        ((JTextField)calendarDesde.getDateEditor().getUiComponent()).getText().trim(),((JTextField)calendarHasta.getDateEditor().getUiComponent()).getText().trim());
        } catch (SQLException ex) {
            Logger.getLogger(consultaEntregas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int sumaEntregas = 0;
        for (int i = 0; i < entregas.size(); i++){
            sumaEntregas = sumaEntregas + entregas.get(i).getCantidad();
        }
        
        txtSuma.setText(Integer.toString(sumaEntregas));
        
        cleanTable();
        buildTable();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void chbRangoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbRangoItemStateChanged
        if(chbRango.isSelected()){
            calendarDesde.setEnabled(true);
            calendarDesde.getDateEditor().setEnabled(false);
            calendarHasta.setEnabled(true);
            calendarHasta.getDateEditor().setEnabled(false);
        }
        else{
            calendarDesde.setEnabled(false);
            calendarHasta.setEnabled(false);
        }
    }//GEN-LAST:event_chbRangoItemStateChanged

    private void chbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbClienteItemStateChanged
        if(chbCliente.isSelected())
            cmbClientes.setEnabled(true);
        else
            cmbClientes.setEnabled(false);
    }//GEN-LAST:event_chbClienteItemStateChanged

    private void chbEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbEmpleadoItemStateChanged
        if(chbEmpleado.isSelected())
            cmbEmpleados.setEnabled(true);
        else
            cmbEmpleados.setEnabled(false);
    }//GEN-LAST:event_chbEmpleadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser calendarDesde;
    private com.toedter.calendar.JDateChooser calendarHasta;
    private javax.swing.JCheckBox chbCliente;
    private javax.swing.JCheckBox chbEmpleado;
    private javax.swing.JCheckBox chbRango;
    private javax.swing.JComboBox<String> cmbClientes;
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
    private javax.swing.JTextField txtSuma;
    // End of variables declaration//GEN-END:variables
}
