/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Roberto
 */
public class Informes extends javax.swing.JPanel {

    /**
     * Creates new form Informes
     */
    public Informes() {
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        infVentFondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda de Ventas"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 160, -1));
        jPanel6.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 160, -1));

        jTextField1.setText("jTextField1");
        jPanel6.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 100, -1));

        button1.setActionCommand("Buscar");
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button1.setLabel("Buscar");
        button1.setName(""); // NOI18N
        jPanel6.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        label1.setText("Hasta");
        jPanel6.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        label2.setText("Busqueda por Rut");
        jPanel6.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        label3.setText("Desde");
        jPanel6.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));
        label3.getAccessibleContext().setAccessibleName("Desde");

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 210));

        infVentFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        jPanel3.add(infVentFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Informe de Ventas", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Informe de Inventario", jPanel2);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Informe Clientes", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Inf. Devuluciones y Cambios", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 540));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 540));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel infVentFondo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
}
