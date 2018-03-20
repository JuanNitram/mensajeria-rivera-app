
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import controllers.Factory;
import dataTypes.DtCliente;
import dataTypes.DtEmpleado;
import dataTypes.DtPagoClienteEntrega;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class gestionPagoCliente extends javax.swing.JInternalFrame {

    private List<DtEmpleado> empleados;
    private List<DtCliente> clientes;
    boolean eventoModificar;

    public gestionPagoCliente() {
        initComponents();
        lblImage.setIcon(new ImageIcon(new ImageIcon("resources/money.png").getImage().getScaledInstance(102, 102, Image.SCALE_DEFAULT)));
        setResizable(false);
    }

    public void setEmpleados(List<DtEmpleado> emp) {
        empleados = emp;
    }

    public void initializeComponents() {
        txtMonto.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCedula.setEnabled(false);
        cmbEmpleado.requestFocus();
        cmbCliente.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        eventoModificar = false;
        clearClientes();
        limpiarCampos();
        buildEmpleados();
        cleanTable();
    }

    private void clearClientes() {
        String[] array = new String[1];
        array[0] = "";
        JComboBox comboBox = new JComboBox(array);
        cmbCliente.setModel(comboBox.getModel());
    }

    public void buildComponents() throws SQLException {
        String selectedCmb = cmbEmpleado.getSelectedItem().toString().trim();
        String[] parts = selectedCmb.split("-");
        String empleadoId = parts[0].trim();
        DtEmpleado dtE = Factory.getInstance().getIOperations().getInfoEmpleado(Integer.parseInt(empleadoId));
        txtTelefono.setText(dtE.getTelefono());
        txtDireccion.setText(dtE.getDireccion());
        txtCedula.setText(dtE.getCi());
    }

    private void buildEmpleados() {
        String[] array = new String[empleados.size()];
        String[] array2 = new String[empleados.size() + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = empleados.get(i).getId() + " - " + empleados.get(i).getNombre();
            array2[i + 1] = array[i];
        }
        array2[0] = "Seleccione Empleado";
        JComboBox comboBox = new JComboBox(array2);
        cmbEmpleado.setModel(comboBox.getModel());
    }

    public void setClientes(List<DtCliente> clientes) {
        this.clientes = clientes;
    }

    private void buildClientes() {
        String[] array = new String[clientes.size()];
        String[] array2 = new String[clientes.size() + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = clientes.get(i).getId() + " - " + clientes.get(i).getNombre();
            array2[i + 1] = array[i];
        }
        array2[0] = "Seleccione Cliente";
        JComboBox comboBox = new JComboBox(array2);
        cmbCliente.setModel(comboBox.getModel());
    }

    private void limpiarCampos() {
        txtMonto.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCedula.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        cmbCliente = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Gestion Pago Unidad Empleado");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        jLabel2.setText("Telefono");

        jLabel3.setText("Direccion");

        jLabel4.setText("Cedula");

        jLabel5.setText("Cliente");

        jLabel6.setText("Monto/Unidad");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(txtCedula))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(22, 22, 22)
                        .addComponent(txtMonto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setText("Empleado");

        cmbEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpleadoItemStateChanged(evt);
            }
        });
        cmbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 730, 230));

        btnNuevo.setText("Nuevo Monto/Unidad");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_EMPLEADO", "ID_CLIENTE", "EMPLEADO", "CLIENTE", "MONTO/UNIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 730, 130));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buildTable() {
        String selectedCmb = cmbEmpleado.getSelectedItem().toString().trim();
        String[] parts = selectedCmb.split("-");
        String empleadoID = parts[0].trim();
        try {
            List<DtPagoClienteEntrega> data = Factory.getInstance().getIOperations().getPagoCliente(empleadoID);
            DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
            model.setRowCount(0); //Reinicializa el contador de filas
            Object rowData[] = new Object[5];
            for (int i = 0; i < data.size(); i++) {
                rowData[0] = data.get(i).getIdEmpleado();
                rowData[1] = data.get(i).getIdCliente();
                rowData[2] = data.get(i).getNombreEmpleado();
                rowData[3] = data.get(i).getNombreCliente();
                rowData[4] = data.get(i).getMonto();
                model.addRow(rowData);

                tablaDatos.getColumnModel().getColumn(1).setMinWidth(0);
                tablaDatos.getColumnModel().getColumn(1).setMaxWidth(0);
                tablaDatos.getColumnModel().getColumn(1).setWidth(0);

                tablaDatos.getColumnModel().getColumn(0).setMinWidth(0);
                tablaDatos.getColumnModel().getColumn(0).setMaxWidth(0);
                tablaDatos.getColumnModel().getColumn(0).setWidth(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestionPagoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
        model.setRowCount(0);
    }

    private void cmbEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpleadoItemStateChanged
        if (cmbEmpleado.getSelectedIndex() != 0) {
            try {
                buildComponents();
                cleanTable();
                buildTable();
            } catch (SQLException ex) {
                Logger.getLogger(gestionPagoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_cmbEmpleadoItemStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (cmbEmpleado.getSelectedIndex() != 0) {
            buildClientes();
            eventoModificar = false;
            cmbCliente.setEnabled(true);
            txtMonto.setEnabled(true);
            btnNuevo.setEnabled(false);
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnModificar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        eventoModificar = false;
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        limpiarCampos();
        clearClientes();
        cmbCliente.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        txtMonto.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!eventoModificar) { // Caso de uso nuevo monto por unidad para empleado
            System.out.println("Nuevo");
            if (cmbCliente.getSelectedIndex() != 0) {
                if (txtMonto.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "El campo monto no puede estar vacio!", "Mensajeria Rivera",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        String emp = cmbEmpleado.getSelectedItem().toString().trim();
                        String[] partsEmp = emp.split("-");
                        String idEmpleado = partsEmp[0].trim();
                        String nombreEmpleado = partsEmp[1].trim();

                        String cli = cmbCliente.getSelectedItem().toString().trim();
                        String[] partsCli = cli.split("-");
                        String idCliente = partsCli[0].trim();
                        String nombreCliente = partsCli[1];

                        String monto = txtMonto.getText().trim();

                        DtPagoClienteEntrega dtP = new DtPagoClienteEntrega(Integer.parseInt(idEmpleado), Integer.parseInt(idCliente), nombreEmpleado, nombreCliente, Float.parseFloat(monto));
                        Factory.getInstance().getIOperations().altaPagoClienteEntrega(dtP);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Se ha producido un error!", "Mensajeria Rivera",
                                JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un cliente!", "Mensajeria Rivera",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else { // Caso de uso modificar monto unidad
            String idEmpleado = tablaDatos.getModel().getValueAt(tablaDatos.getSelectedRow(), 1).toString().trim();
            String idCliente = tablaDatos.getModel().getValueAt(tablaDatos.getSelectedRow(), 0).toString().trim();
            String nuevoMonto = txtMonto.getText().trim();
            try {
                Factory.getInstance().getIOperations().actualizarPagoCliente(Integer.parseInt(idEmpleado), Integer.parseInt(idCliente), Float.parseFloat(nuevoMonto));
            } catch (SQLException ex) {
                Logger.getLogger(gestionPagoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        initializeComponents();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmpleadoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaDatos.getSelectedRow() != -1) {
            String monto = tablaDatos.getModel().getValueAt(tablaDatos.getSelectedRow(), 4).toString();
            String idEmpleado = tablaDatos.getModel().getValueAt(tablaDatos.getSelectedRow(), 1).toString().trim();
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnNuevo.setEnabled(false);
            txtMonto.setText(monto);
            txtMonto.setEnabled(true);
            buildClientes();
            cmbCliente.setSelectedIndex(Integer.parseInt(idEmpleado));
            eventoModificar = true;
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar el elemento a modificar!", "Mensajeria Rivera",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
