/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ArticulosC;
import controlador.CatArtC;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Mauro
 */
public class modificarCatArt extends javax.swing.JFrame {
    /**
     * Creates new form modificarBanco
     */
    public modificarCatArt() {
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
        jLabel4 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        catArtNameTF = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        resultMessage = new javax.swing.JLabel();
        catArtStatusCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, -1, -1));
        getContentPane().add(catArtNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 134, -1));

        saveButton.setText("Guardar");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        getContentPane().add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        closeButton.setText("Cerrar");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 73, -1));
        getContentPane().add(resultMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 134, 185, 15));

        catArtStatusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));
        getContentPane().add(catArtStatusCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 105, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/256x287blue2.jpg"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        var response = CatArtC.modificarCatArt(this.idLabel.getText(), this.catArtNameTF.getText(), this.catArtStatusCB.getSelectedIndex());
        if( response )
            this.resultMessage.setText("Categoria modificada exitosamente");
        else
            this.resultMessage.setText("No fue posible modificar la categoria");
    }//GEN-LAST:event_saveButtonMouseClicked

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        setVisible(false);
        ArticulosC.actualizarListaCategorias();
        CatArtC.buscar("1");
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

    public JTextField getCatArtNameTF() {
        return catArtNameTF;
    }

    public void setCatArtNameTF(JTextField bankNameTF) {
        this.catArtNameTF = bankNameTF;
    }

    public javax.swing.JComboBox<String> getCatArtStatusCB() {
        return catArtStatusCB;
    }

    public void setCatArtStatusTF(javax.swing.JComboBox<String> redStatusCB) {
        this.catArtStatusCB = redStatusCB;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField catArtNameTF;
    private javax.swing.JComboBox<String> catArtStatusCB;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel resultMessage;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
