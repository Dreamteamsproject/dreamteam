/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.SAPackC;

/**
 *
 * @author Roberto
 */
public class compras extends javax.swing.JFrame {

    /**
     * Creates new form compras
     */
    public compras() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        solicPedido = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        infBuscFech = new com.toedter.calendar.JDateChooser();
        label3 = new java.awt.Label();
        Infbuscrut = new javax.swing.JTextField();
        infBuscBtn = new java.awt.Button();
        label12 = new java.awt.Label();
        jScrollPane13 = new javax.swing.JScrollPane();
        packArtListado = new javax.swing.JList<>();
        packquitarArtBtn = new javax.swing.JButton();
        Cantidad = new javax.swing.JLabel();
        packCantAdd = new java.awt.TextField();
        packAddArtBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        packCreaListado = new javax.swing.JTable();
        InfVentRealV5 = new java.awt.Button();
        InfVentRealV6 = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        infTable = new javax.swing.JTable();
        InfVentRealV2 = new java.awt.Button();
        InfVentRealV3 = new java.awt.Button();
        InfVentRealV4 = new java.awt.Button();
        label4 = new java.awt.Label();
        infVentFondo = new javax.swing.JLabel();
        regCompras = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        label5 = new java.awt.Label();
        label7 = new java.awt.Label();
        jTextField3 = new javax.swing.JTextField();
        button4 = new java.awt.Button();
        label9 = new java.awt.Label();
        jComboBox2 = new javax.swing.JComboBox<>();
        label11 = new java.awt.Label();
        jTextField4 = new javax.swing.JTextField();
        button5 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        button6 = new java.awt.Button();
        label6 = new java.awt.Label();
        jPanel10 = new javax.swing.JPanel();
        label10 = new java.awt.Label();
        jTextField6 = new javax.swing.JTextField();
        button8 = new java.awt.Button();
        label18 = new java.awt.Label();
        jComboBox3 = new javax.swing.JComboBox<>();
        label19 = new java.awt.Label();
        jTextField7 = new javax.swing.JTextField();
        button10 = new java.awt.Button();
        label20 = new java.awt.Label();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        label21 = new java.awt.Label();
        button11 = new java.awt.Button();
        infVentFondo1 = new javax.swing.JLabel();
        revFacturas = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        label22 = new java.awt.Label();
        label23 = new java.awt.Label();
        jTextField10 = new javax.swing.JTextField();
        button12 = new java.awt.Button();
        label24 = new java.awt.Label();
        jComboBox4 = new javax.swing.JComboBox<>();
        label25 = new java.awt.Label();
        jTextField11 = new javax.swing.JTextField();
        button13 = new java.awt.Button();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        button14 = new java.awt.Button();
        label26 = new java.awt.Label();
        button17 = new java.awt.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        infVentFondo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        solicPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(32, 134, 192));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solicitud de Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(infBuscFech, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 160, -1));

        label3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Fecha Pedido");
        jPanel6.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 30));
        label3.getAccessibleContext().setAccessibleName("Fecha Pedido");

        jPanel6.add(Infbuscrut, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 100, -1));

        infBuscBtn.setActionCommand("Buscar");
        infBuscBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infBuscBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        infBuscBtn.setLabel("Buscar");
        infBuscBtn.setName(""); // NOI18N
        jPanel6.add(infBuscBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 20));

        label12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label12.setForeground(new java.awt.Color(255, 255, 255));
        label12.setText("Numero Pedido");
        jPanel6.add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        packArtListado.setToolTipText("");
        jScrollPane13.setViewportView(packArtListado);

        jPanel6.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 190, 120));

        packquitarArtBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        packquitarArtBtn.setForeground(new java.awt.Color(195, 8, 26));
        packquitarArtBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha izq.png"))); // NOI18N
        packquitarArtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packquitarArtBtnActionPerformed(evt);
            }
        });
        jPanel6.add(packquitarArtBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 50, 30));

        Cantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        Cantidad.setText("Cantidad");
        jPanel6.add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        packCantAdd.setName(""); // NOI18N
        packCantAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packCantAddActionPerformed(evt);
            }
        });
        jPanel6.add(packCantAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 30, -1));

        packAddArtBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        packAddArtBtn.setForeground(new java.awt.Color(18, 13, 158));
        packAddArtBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha der.png"))); // NOI18N
        packAddArtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packAddArtBtnActionPerformed(evt);
            }
        });
        jPanel6.add(packAddArtBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 50, 30));

        packCreaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Producto"
            }
        ));
        jScrollPane4.setViewportView(packCreaListado);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 190, 120));

        InfVentRealV5.setActionCommand("Buscar");
        InfVentRealV5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfVentRealV5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        InfVentRealV5.setLabel("Cancelar");
        InfVentRealV5.setName(""); // NOI18N
        jPanel6.add(InfVentRealV5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 110, -1));

        InfVentRealV6.setActionCommand("Buscar");
        InfVentRealV6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfVentRealV6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        InfVentRealV6.setLabel("Guardar");
        InfVentRealV6.setName(""); // NOI18N
        jPanel6.add(InfVentRealV6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 110, -1));

        solicPedido.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 260));
        jPanel6.getAccessibleContext().setAccessibleName("Solicitud de Pedido");

        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        solicPedido.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 100, 20));

        button1.setActionCommand("Buscar");
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button1.setLabel("Buscar");
        button1.setName(""); // NOI18N
        solicPedido.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, 20));

        infTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero Pedido", "Fecha Pedido", "Cantidad de Articulos", "Seleccion"
            }
        ));
        jScrollPane1.setViewportView(infTable);

        solicPedido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 317, 680, 140));

        InfVentRealV2.setActionCommand("Buscar");
        InfVentRealV2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfVentRealV2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        InfVentRealV2.setLabel("Editar");
        InfVentRealV2.setName(""); // NOI18N
        solicPedido.add(InfVentRealV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 110, -1));

        InfVentRealV3.setActionCommand("Buscar");
        InfVentRealV3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfVentRealV3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        InfVentRealV3.setLabel("Generar OC");
        InfVentRealV3.setName(""); // NOI18N
        solicPedido.add(InfVentRealV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 470, 110, -1));

        InfVentRealV4.setActionCommand("Buscar");
        InfVentRealV4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfVentRealV4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        InfVentRealV4.setLabel("Ver");
        InfVentRealV4.setName(""); // NOI18N
        solicPedido.add(InfVentRealV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 110, -1));

        label4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label4.setText("Detalle de Pedidos realizados");
        solicPedido.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        infVentFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        infVentFondo.setText("Ver");
        solicPedido.add(infVentFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Solicitud de Pedido", solicPedido);

        regCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(32, 134, 192));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Factura de Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, -1));

        label5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Fecha Recepcion");
        jPanel8.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        label7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("Rut");
        jPanel8.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 20));
        label7.getAccessibleContext().setAccessibleName("Rut");

        jPanel8.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, -1));

        button4.setActionCommand("Buscar");
        button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button4.setLabel("Cancelar");
        button4.setName(""); // NOI18N
        jPanel8.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 100, -1));

        label9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 255, 255));
        label9.setText("Proveedor Razon Social");
        jPanel8.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jPanel8.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 170, -1));

        label11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label11.setForeground(new java.awt.Color(255, 255, 255));
        label11.setText("Numero Factura");
        jPanel8.add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel8.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, -1));

        button5.setActionCommand("Buscar");
        button5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button5.setLabel("Guardar");
        button5.setName(""); // NOI18N
        jPanel8.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 90, -1));

        regCompras.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 120));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Articulo", "Nombre Articulo", "Stock", "Fecha de Vencimiento", "Valor Producto", "Rut Proveedor"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        regCompras.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 287, 680, 170));

        button6.setActionCommand("Buscar");
        button6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button6.setLabel("Eliminar");
        button6.setName(""); // NOI18N
        regCompras.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 110, -1));

        label6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label6.setText("Detalle de Inventario");
        regCompras.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 20));

        jPanel10.setBackground(new java.awt.Color(32, 134, 192));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Detalle de Factura de proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label10.setForeground(new java.awt.Color(255, 255, 255));
        label10.setText("Cantidad");
        jPanel10.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, 20));
        jPanel10.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 30, -1));

        button8.setActionCommand("Buscar");
        button8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button8.setLabel("Cancelar");
        button8.setName(""); // NOI18N
        jPanel10.add(button8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 100, -1));

        label18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label18.setForeground(new java.awt.Color(255, 255, 255));
        label18.setText("Articulo");
        jPanel10.add(label18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jPanel10.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 150, -1));

        label19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label19.setForeground(new java.awt.Color(255, 255, 255));
        label19.setText("Codigo");
        jPanel10.add(label19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel10.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 100, -1));

        button10.setActionCommand("Buscar");
        button10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button10.setLabel("Agregar Articulo");
        button10.setName(""); // NOI18N
        jPanel10.add(button10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        label20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label20.setForeground(new java.awt.Color(255, 255, 255));
        label20.setText("Valor");
        jPanel10.add(label20, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, 20));
        jPanel10.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 50, -1));
        jPanel10.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        label21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label21.setForeground(new java.awt.Color(255, 255, 255));
        label21.setText("Vencimiento");
        jPanel10.add(label21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        regCompras.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 680, 110));

        button11.setActionCommand("Buscar");
        button11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button11.setLabel("Editar");
        button11.setName(""); // NOI18N
        regCompras.add(button11, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 470, 110, -1));

        infVentFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        regCompras.add(infVentFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Registro Compras", regCompras);

        revFacturas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(32, 134, 192));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Factura de Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jDateChooser8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, -1));

        label22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label22.setForeground(new java.awt.Color(255, 255, 255));
        label22.setText("Fecha Recepcion");
        jPanel11.add(label22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        label23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label23.setForeground(new java.awt.Color(255, 255, 255));
        label23.setText("Rut");
        jPanel11.add(label23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 20));
        jPanel11.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, -1));

        button12.setActionCommand("Buscar");
        button12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button12.setLabel("Cancelar");
        button12.setName(""); // NOI18N
        jPanel11.add(button12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 100, -1));

        label24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label24.setForeground(new java.awt.Color(255, 255, 255));
        label24.setText("Proveedor Razon Social");
        jPanel11.add(label24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jPanel11.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 170, -1));

        label25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label25.setForeground(new java.awt.Color(255, 255, 255));
        label25.setText("Numero Factura");
        jPanel11.add(label25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel11.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, -1));

        button13.setActionCommand("Buscar");
        button13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button13.setLabel("Guardar");
        button13.setName(""); // NOI18N
        jPanel11.add(button13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 90, -1));

        revFacturas.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 120));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Articulo", "Nombre Articulo", "Stock", "Fecha de Vencimiento", "Valor Producto", "Rut Proveedor"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        revFacturas.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 680, 170));

        button14.setActionCommand("Buscar");
        button14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button14.setLabel("Eliminar");
        button14.setName(""); // NOI18N
        revFacturas.add(button14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 110, -1));

        label26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label26.setText("Detalle de Inventario");
        revFacturas.add(label26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 20));

        button17.setActionCommand("Buscar");
        button17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button17.setLabel("Editar");
        button17.setName(""); // NOI18N
        revFacturas.add(button17, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 470, 110, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        revFacturas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 137, 670, 110));

        infVentFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spiral720x570.jpg"))); // NOI18N
        revFacturas.add(infVentFondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        jTabbedPane1.addTab("Registro Compras (No esta listo)", revFacturas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void packquitarArtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packquitarArtBtnActionPerformed
        SAPackC.eleminarArt();
    }//GEN-LAST:event_packquitarArtBtnActionPerformed

    private void packCantAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packCantAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_packCantAddActionPerformed

    private void packAddArtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packAddArtBtnActionPerformed
        SAPackC.añadirArt();
    }//GEN-LAST:event_packAddArtBtnActionPerformed

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
            java.util.logging.Logger.getLogger(compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private java.awt.Button InfVentRealV2;
    public java.awt.Button InfVentRealV3;
    public java.awt.Button InfVentRealV4;
    public java.awt.Button InfVentRealV5;
    public java.awt.Button InfVentRealV6;
    private javax.swing.JTextField Infbuscrut;
    private java.awt.Button button1;
    public java.awt.Button button10;
    public java.awt.Button button11;
    public java.awt.Button button12;
    public java.awt.Button button13;
    public java.awt.Button button14;
    public java.awt.Button button17;
    private java.awt.Button button4;
    public java.awt.Button button5;
    private java.awt.Button button6;
    public java.awt.Button button8;
    private java.awt.Button infBuscBtn;
    private com.toedter.calendar.JDateChooser infBuscFech;
    private javax.swing.JTable infTable;
    private javax.swing.JLabel infVentFondo;
    private javax.swing.JLabel infVentFondo1;
    private javax.swing.JLabel infVentFondo3;
    private javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JComboBox<String> jComboBox3;
    public javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    public com.toedter.calendar.JDateChooser jDateChooser8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField10;
    public javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JTextField jTextField9;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label20;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label24;
    private java.awt.Label label25;
    private java.awt.Label label26;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label9;
    public javax.swing.JButton packAddArtBtn;
    public javax.swing.JList<String> packArtListado;
    public java.awt.TextField packCantAdd;
    public javax.swing.JTable packCreaListado;
    public javax.swing.JButton packquitarArtBtn;
    private javax.swing.JPanel regCompras;
    private javax.swing.JPanel revFacturas;
    private javax.swing.JPanel solicPedido;
    // End of variables declaration//GEN-END:variables
}
