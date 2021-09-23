/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginC;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Roberto
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form DREAMGIFT
     */
    public Login() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginBotonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loginBotonIngresar = new javax.swing.JButton();
        loginUsuario = new javax.swing.JTextField();
        loginPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(167, 196, 182));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginBotonSalir.setBackground(new java.awt.Color(255, 255, 255));
        loginBotonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginBotonSalir.setText("Salir");
        loginBotonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBotonSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBotonSalirMouseExited(evt);
            }
        });
        loginBotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBotonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(loginBotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 80, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 200, 20));

        loginBotonIngresar.setBackground(new java.awt.Color(255, 255, 255));
        loginBotonIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginBotonIngresar.setText("Ingresar");
        loginBotonIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBotonIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBotonIngresarMouseExited(evt);
            }
        });
        loginBotonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBotonIngresarActionPerformed(evt);
            }
        });
        loginBotonIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBotonIngresarKeyPressed(evt);
            }
        });
        jPanel1.add(loginBotonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 120, 40));

        loginUsuario.setForeground(new java.awt.Color(153, 153, 153));
        loginUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loginUsuario.setText("Ingresar Usuario");
        loginUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginUsuarioMouseExited(evt);
            }
        });
        loginUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(loginUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 270, -1));

        loginPassword.setForeground(new java.awt.Color(153, 153, 153));
        loginPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loginPassword.setText("IngresarContraseña");
        loginPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginPasswordMouseExited(evt);
            }
        });
        loginPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(loginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 270, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 200, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral3.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBotonSalirActionPerformed
        LoginC.Salir();
    }//GEN-LAST:event_loginBotonSalirActionPerformed

    private void loginBotonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBotonIngresarActionPerformed
       LoginC.ConsultarUsuario();
    }//GEN-LAST:event_loginBotonIngresarActionPerformed

    private void loginBotonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBotonSalirMouseEntered
        loginBotonSalir.setBackground(Color.red);
    }//GEN-LAST:event_loginBotonSalirMouseEntered

    private void loginBotonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBotonSalirMouseExited
        loginBotonSalir.setBackground(Color.white);
    }//GEN-LAST:event_loginBotonSalirMouseExited

    private void loginBotonIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBotonIngresarMouseEntered
        loginBotonIngresar.setBackground(Color.green);
    }//GEN-LAST:event_loginBotonIngresarMouseEntered

    private void loginBotonIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBotonIngresarMouseExited
        loginBotonIngresar.setBackground(Color.white);
    }//GEN-LAST:event_loginBotonIngresarMouseExited

    private void loginUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUsuarioMouseEntered
         LoginC.CheckUserText();
         LoginC.CheckUserText();
    }//GEN-LAST:event_loginUsuarioMouseEntered

    private void loginPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordMouseEntered
        LoginC.CheckPasswordText();
        LoginC.CheckPasswordText();
    }//GEN-LAST:event_loginPasswordMouseEntered

    private void loginUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUsuarioMouseExited
        LoginC.CheckUserTextVacio();
    }//GEN-LAST:event_loginUsuarioMouseExited

    private void loginPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordMouseExited
       LoginC.CheckPasswordText();
       LoginC.CheckPasswordTextVacio();
    }//GEN-LAST:event_loginPasswordMouseExited

    private void loginUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginUsuarioKeyPressed
        LoginC.CheckKeyPress(evt);
        LoginC.CheckUserText();
    }//GEN-LAST:event_loginUsuarioKeyPressed

    private void loginPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginPasswordKeyPressed
        LoginC.CheckKeyPress(evt);
        LoginC.CheckPasswordText();
    }//GEN-LAST:event_loginPasswordKeyPressed

    private void loginBotonIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBotonIngresarKeyPressed
        LoginC.CheckKeyPress(evt);
    }//GEN-LAST:event_loginBotonIngresarKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable(){public void run() {}});
        new Login().setVisible(true);
        /* Create and display the form */
        
    }


    public JPasswordField getLoginPassword() {
        return loginPassword;
    }

    public JTextField getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginPasswordSetText(String loginPassword) {
        this.loginPassword.setText(loginPassword);
    }

    public void setLoginUsuarioSetText(String loginUsuario) {
        this.loginUsuario.setText(loginUsuario);
    }

    public void setLoginPasswordSetTextSetColor(java.awt.Color color) {
        this.loginPassword.setForeground(color);
    }
    
    public void setLoginUsuarioSetTextSetColor(java.awt.Color color) {
        this.loginUsuario.setForeground(color);
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton loginBotonIngresar;
    public javax.swing.JButton loginBotonSalir;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JTextField loginUsuario;
    // End of variables declaration//GEN-END:variables
}
