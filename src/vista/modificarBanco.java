/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.bancosC;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Mauro
 */
public class modificarBanco extends javax.swing.JFrame {
    /**
     * Creates new form modificarBanco
     */
    public modificarBanco() {
        setUndecorated(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        bankNameTF = new javax.swing.JTextField();
        bankCodeTF = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        resultMessage = new javax.swing.JLabel();
        bankStatusCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 39, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 102, -1, -1));
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, -1, -1));
        getContentPane().add(bankNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 36, 128, -1));
        getContentPane().add(bankCodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 67, 128, -1));

        saveButton.setText("Guardar");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        getContentPane().add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 157, -1, -1));

        closeButton.setText("Cerrar");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 157, 73, -1));
        getContentPane().add(resultMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 131, 185, 15));

        bankStatusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));
        getContentPane().add(bankStatusCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 98, 90, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/spiral205x212.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        var response = bancosC.modificarBanco(this.idLabel.getText(), this.bankNameTF.getText(), this.bankCodeTF.getText(), this.bankStatusCB.getSelectedIndex() );
        if( response )
            this.resultMessage.setText("Banco modificado exitosamente");
        else
            this.resultMessage.setText("No fue posible modificar el banco");
    }//GEN-LAST:event_saveButtonMouseClicked

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        setVisible(false);
        bancosC.buscar("1");
    }//GEN-LAST:event_closeButtonMouseClicked

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
            java.util.logging.Logger.getLogger(modificarBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarBanco().setVisible(true);
            }
        });
    }

    public JTextField getBankCodeTF() {
        return bankCodeTF;
    }

    public void setBankCodeTF(JTextField bankCodeTF) {
        this.bankCodeTF = bankCodeTF;
    }

    public JTextField getBankNameTF() {
        return bankNameTF;
    }

    public void setBankNameTF(JTextField bankNameTF) {
        this.bankNameTF = bankNameTF;
    }
    
    public javax.swing.JComboBox<String> getBankStatusCB() {
        return this.bankStatusCB;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bankCodeTF;
    private javax.swing.JTextField bankNameTF;
    private javax.swing.JComboBox<String> bankStatusCB;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel resultMessage;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
