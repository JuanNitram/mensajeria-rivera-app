package Presentation;

import controllers.Factory;
import dataTypes.DtCliente;
import dataTypes.DtEmpleado;
import dataTypes.DtEntrega;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class gestionEntregas extends javax.swing.JInternalFrame {
    
    private List<DtEntrega> entregas;
    private List<DtEmpleado> empleados;
    private List<DtCliente> clientes;
    
    public gestionEntregas() {
        initComponents();
        jLabel6.setIcon(new ImageIcon(new ImageIcon("resources/carta.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
        setResizable(false);
    }
    
    public void setEntregas(List<DtEntrega> ent){
        entregas = ent;
    }
    
    public void setEmpleados(List<DtEmpleado> emp){
        empleados = emp;
    }
    
    public void setClientes(List<DtCliente> clien){
        clientes = clien;
    }
    
    public void initializeComponents(){
        btnCancelar.setEnabled(false);
        btnNueva.setEnabled(true);
        btnGuardar.setEnabled(false);
        txtCantidad.setEnabled(false);
        cmbEmpleados.setEnabled(false);
        cmbClientes.setEnabled(false);
        calendarRecogida.setEnabled(false);
        calendarVencimiento.setEnabled(false);
        buildTable();
        buildCmbEmpleados();
        buildCmbClientes();
        limpiarCampos();
    }
    
    private void buildTable(){
        DefaultTableModel model = (DefaultTableModel) tablaEntregas.getModel();
        model.setRowCount(0); //Reinicializa el contador de filas
        Object rowData[] = new Object[5];
        for(int i=0; i<entregas.size();i++){
            rowData[0] = entregas.get(i).getNombreEmpleado();
            rowData[1] = entregas.get(i).getNombreCliente();
            rowData[2] = entregas.get(i).getCantidad();
            rowData[3] = entregas.get(i).getFechaRecogida().toString();
            rowData[4] = entregas.get(i).getFechaVenc().toString();
            model.addRow(rowData);
        }
        
        tablaEntregas.getColumnModel().getColumn(4).setMinWidth(0);
        tablaEntregas.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaEntregas.getColumnModel().getColumn(4).setWidth(0);
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
    
    private void limpiarCampos(){
        txtCantidad.setText("");
        calendarRecogida.setDate(new Date());
        calendarVencimiento.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        calendarRecogida = new com.toedter.calendar.JDateChooser();
        calendarVencimiento = new com.toedter.calendar.JDateChooser();
        btnNueva = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntregas = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Registro Entregas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Entrega"));

        jLabel1.setText("Empleado");

        jLabel2.setText("Cliente");

        jLabel3.setText("Cantidad");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Recogida");

        jLabel5.setText("Fecha Vencimiento");

        calendarRecogida.setDateFormatString("yyyy-MM-dd");

        calendarVencimiento.setDateFormatString("yyyy-MM-dd");
        calendarVencimiento.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarRecogida, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(calendarRecogida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(calendarVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 720, -1));

        btnNueva.setText("Nueva Entrega");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaEntregas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLEADO", "CLIENTE", "CANTIDAD", "FECHA RECOGIDA", "FECHA VENCIMIENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEntregas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 720, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        btnNueva.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        cmbEmpleados.setEnabled(true);
        cmbClientes.setEnabled(true);
        txtCantidad.setEnabled(true);
        calendarRecogida.setEnabled(true);
        calendarRecogida.getDateEditor().setEnabled(false);
        //calendarVencimiento.setEnabled(true);
        //calendarVencimiento.getDateEditor().setEnabled(false);
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
        btnNueva.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        cmbEmpleados.setEnabled(false);
        cmbEmpleados.setSelectedIndex(0);
        cmbClientes.setEnabled(false);
        cmbClientes.setSelectedIndex(0);
        txtCantidad.setEnabled(false);
        calendarRecogida.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String cant = txtCantidad.getText();
        boolean isNumeric = cant.chars().allMatch( Character::isDigit );
        
        if(cmbEmpleados.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado!", "Mensajeria Rivera",
                JOptionPane.WARNING_MESSAGE);
        else if(cmbClientes.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(null, "Debes seleccionar un cliente!", "Mensajeria Rivera",
                JOptionPane.WARNING_MESSAGE);
        else if(txtCantidad.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Debes ingresar la cantidad!", "Mensajeria Rivera",
                JOptionPane.WARNING_MESSAGE);
        else if(!isNumeric)
            JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad numerica!", "Mensajeria Rivera",
                JOptionPane.WARNING_MESSAGE);
        else if(((JTextField)calendarRecogida.getDateEditor().getUiComponent()).getText().trim().equals(""))
            JOptionPane.showMessageDialog(null, "Debes ingresar una fecha recogda!", "Mensajeria Rivera",
                JOptionPane.WARNING_MESSAGE);
        /*else if(((JTextField)calendarVencimiento.getDateEditor().getUiComponent()).getText().trim().equals(""))
            JOptionPane.showMessageDialog(null, "Debes ingresar una fecha vencimiento!", "Mensajeria Rivera",
                JOptionPane.WARNING_MESSAGE); */
        else{
            
            String strVenc  = ((JTextField)calendarVencimiento.getDateEditor().getUiComponent()).getText().trim();
         
            String strLev = ((JTextField)calendarRecogida.getDateEditor().getUiComponent()).getText().trim();
            
            String selectedEmpleado = cmbEmpleados.getSelectedItem().toString().trim();
            String[] partsEmpleado = selectedEmpleado.split("-");

            String selectedCliente = cmbClientes.getSelectedItem().toString().trim();
            String[] partsCliente = selectedCliente.split("-");            
            
            
            try{
            DtEntrega dtE = new DtEntrega(partsEmpleado[1].toUpperCase().trim(),partsCliente[1].toUpperCase().trim(),Integer.parseInt(partsEmpleado[0].trim()),Integer.parseInt(partsCliente[0].trim()),Integer.parseInt(cant.trim()),strVenc,strLev);
            Factory.getInstance().getIOperations().altaEntrega(dtE);
            entregas = Factory.getInstance().getIOperations().getEntregas();
            } catch(SQLException e){
                e.printStackTrace();
            }
            initializeComponents();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNueva;
    private com.toedter.calendar.JDateChooser calendarRecogida;
    private com.toedter.calendar.JDateChooser calendarVencimiento;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEntregas;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables

}
