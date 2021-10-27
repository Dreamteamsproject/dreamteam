/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.InformesController;
import controlador.MainPageController;

/**
 *
 * @author Mauro
 */
public class mainPage extends javax.swing.JFrame {

    /**
     * Creates new form mainPage
     */
    public mainPage() {
        InformesController.InformesController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IngresarVentas = new javax.swing.JButton();
        IngresarCompras = new javax.swing.JButton();
        IngresarAdmin = new javax.swing.JButton();
        IngresarInformes1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IngresarVentas.setText("Ventas");
        IngresarVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresarVentasMouseClicked(evt);
            }
        });
        getContentPane().add(IngresarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 80, -1));

        IngresarCompras.setText("Compras");
        IngresarCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresarComprasMouseClicked(evt);
            }
        });
        getContentPane().add(IngresarCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 80, -1));

        IngresarAdmin.setText("SuperAdm");
        IngresarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresarAdminMouseClicked(evt);
            }
        });
        IngresarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarAdminActionPerformed(evt);
            }
        });
        getContentPane().add(IngresarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 80, -1));

        IngresarInformes1.setText("Informes");
        IngresarInformes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IngresarInformes1MouseClicked(evt);
            }
        });
        IngresarInformes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarInformes1ActionPerformed(evt);
            }
        });
        getContentPane().add(IngresarInformes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 80, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 140, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/256x287.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarVentasMouseClicked
        MainPageController.abrirVentas();
    }//GEN-LAST:event_IngresarVentasMouseClicked

    private void IngresarComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarComprasMouseClicked
        MainPageController.abrirCompras();
    }//GEN-LAST:event_IngresarComprasMouseClicked

    private void IngresarAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarAdminMouseClicked
        MainPageController.abrirAdm();
    }//GEN-LAST:event_IngresarAdminMouseClicked

    private void IngresarInformes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarInformes1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarInformes1MouseClicked

    private void IngresarInformes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarInformes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarInformes1ActionPerformed

    private void IngresarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarAdminActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngresarAdmin;
    private javax.swing.JButton IngresarCompras;
    private javax.swing.JButton IngresarInformes1;
    private javax.swing.JButton IngresarVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}