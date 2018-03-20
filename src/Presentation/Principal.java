/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import controllers.MysqlConnect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import controllers.Factory;

/**
 *
 * @author JuanMartín
 */
public class Principal extends javax.swing.JFrame {

    private gestionEmpleados frmGestionEmpleado;
    private gestionClientes frmGestionClientes;
    private gestionPagoCliente frmGestionPagoCliente;
    private gestionEntregas frmGestionEntregas;
    private gestionSueldos frmGestionSueldos;
    private consultaEntregas frmConsultaEntregas;
    private consultaSueldos frmConsultaSueldos;

    public Principal() {
        initComponents();

        MysqlConnect.initialize();
        setResizable(false);
        setMinimumSize(new Dimension(1280, 720));
        setTitle("Mensajeria Rivera");

        /* --------- INICIALIZACION INTERNAL FRAMES --------- */
        frmGestionEmpleado = new gestionEmpleados();
        frmGestionEmpleado.setBounds(100, 100, 762, 454);
        desktop.add(frmGestionEmpleado);

        frmGestionClientes = new gestionClientes();
        frmGestionClientes.setBounds(100, 100, 762, 454);
        desktop.add(frmGestionClientes);

        frmGestionPagoCliente = new gestionPagoCliente();
        frmGestionPagoCliente.setBounds(100, 100, 762, 454);
        desktop.add(frmGestionPagoCliente);

        frmGestionEntregas = new gestionEntregas();
        frmGestionEntregas.setBounds(100, 100, 750, 550);
        desktop.add(frmGestionEntregas);

        frmGestionSueldos = new gestionSueldos();
        frmGestionSueldos.setBounds(100, 100, 760, 560);
        desktop.add(frmGestionSueldos);

        frmConsultaEntregas = new consultaEntregas();
        frmConsultaEntregas.setBounds(100, 100, 751, 551);
        desktop.add(frmConsultaEntregas);

        frmConsultaSueldos = new consultaSueldos();
        frmConsultaSueldos.setBounds(100, 100, 751, 590);
        desktop.add(frmConsultaSueldos);        

    }
    
    @Override
    public Image getIconImage() {
        Image retValue = null;
        try{
        retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("carta.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane(){
            ImageIcon icon = new ImageIcon("resources/portada.jpeg");
            Image image = icon.getImage();

            Image newimage = image.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawImage(newimage, 0, 0, this);
            }
        }
        ;
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        desktop.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1171, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem6.setText("Respaldar");
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator1);

        jMenuItem4.setText("Salir");
        jMenu1.add(jMenuItem4);

        menu.add(jMenu1);

        jMenu2.setText("Gestionar");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Empleados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Pagos Unidad");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        menu.add(jMenu2);

        jMenu3.setText("Registrar");

        jMenuItem5.setText("Entregas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem7.setText("Liquidacion Sueldos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        menu.add(jMenu3);

        jMenu4.setText("Consultar");

        jMenuItem8.setText("Entregas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Sueldos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        menu.add(jMenu4);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            frmGestionEmpleado.setEmpleados(Factory.getInstance().getIOperations().getEmpleados());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmGestionEmpleado.getSize();
        frmGestionEmpleado.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmGestionEmpleado.initializeComponents();
        frmGestionEmpleado.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            frmGestionClientes.setClientes(Factory.getInstance().getIOperations().getClientes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmGestionClientes.getSize();
        frmGestionClientes.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmGestionClientes.initializeComponents();
        frmGestionClientes.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            frmGestionPagoCliente.setEmpleados(Factory.getInstance().getIOperations().getEmpleados());
            frmGestionPagoCliente.setClientes(Factory.getInstance().getIOperations().getClientes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmGestionPagoCliente.getSize();
        frmGestionPagoCliente.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmGestionPagoCliente.initializeComponents();
        frmGestionPagoCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            frmGestionEntregas.setEntregas(Factory.getInstance().getIOperations().getEntregas());
            frmGestionEntregas.setEmpleados(Factory.getInstance().getIOperations().getEmpleados());
            frmGestionEntregas.setClientes(Factory.getInstance().getIOperations().getClientes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmGestionEntregas.getSize();
        frmGestionEntregas.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmGestionEntregas.initializeComponents();
        frmGestionEntregas.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            frmConsultaEntregas.setEmpleados(Factory.getInstance().getIOperations().getEmpleados());
            frmConsultaEntregas.setEntregas(Factory.getInstance().getIOperations().getEntregas());
            frmConsultaEntregas.setClientes(Factory.getInstance().getIOperations().getClientes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmConsultaEntregas.getSize();
        frmConsultaEntregas.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmConsultaEntregas.initializeComponents();
        frmConsultaEntregas.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            frmGestionSueldos.setEmpleados(Factory.getInstance().getIOperations().getEmpleados());
            frmGestionSueldos.setSueldos(Factory.getInstance().getIOperations().getSueldos());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmGestionSueldos.getSize();
        frmGestionSueldos.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmGestionSueldos.initializeComponents();
        frmGestionSueldos.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            frmConsultaSueldos.setEmpleados(Factory.getInstance().getIOperations().getEmpleados());
            frmConsultaSueldos.setSueldos(Factory.getInstance().getIOperations().getSueldos());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frmConsultaSueldos.getSize();
        frmConsultaSueldos.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
        frmConsultaSueldos.initializeComponents();
        frmConsultaSueldos.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    Principal princ = new Principal();
                    princ.setVisible(true);
                    princ.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
}
