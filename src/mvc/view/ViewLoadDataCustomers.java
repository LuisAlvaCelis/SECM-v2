package mvc.view;

import javax.swing.UIManager;

public class ViewLoadDataCustomers extends javax.swing.JFrame {
    
    public ViewLoadDataCustomers() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfFileExcel = new javax.swing.JTextField();
        jbtFileExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbtLoadCustomers = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jcbDatabaseList = new javax.swing.JComboBox<>();
        jtfNumColumns = new javax.swing.JTextField();
        jlColumnsExcel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbtLoadNameColumns = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_main.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat Alternates ExtraBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema de carga de data de clientes");
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccione base de datos:");
        panelImage1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jtfFileExcel.setEditable(false);
        jtfFileExcel.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        panelImage1.add(jtfFileExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 460, -1));

        jbtFileExcel.setText("Examinar");
        jbtFileExcel.setFocusPainted(false);
        panelImage1.add(jbtFileExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recuerda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates SemiBold", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("fallos al ejecutar este proceso, y en tal caso de que suceda, por favor contactar con el desarrollador del programa.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MONTO_CAMPAÑA, MONTO_TOTAL y BANCO, caso contrario puede ocacionar problemas o");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("El archivo excel seleccionado puede contener SOLAMENTE las columnas de  DNI, CODIGO_CLIENTE, CLIENTE,");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        panelImage1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 770, 100));

        jbtLoadCustomers.setText("Cargar data");
        panelImage1.add(jbtLoadCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Archivo excel:");
        panelImage1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jcbDatabaseList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        panelImage1.add(jcbDatabaseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 220, -1));

        jtfNumColumns.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        panelImage1.add(jtfNumColumns, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 120, -1));

        jlColumnsExcel.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jlColumnsExcel.setForeground(new java.awt.Color(255, 255, 255));
        jlColumnsExcel.setText("Null");
        panelImage1.add(jlColumnsExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Columnas disponibles:");
        panelImage1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Seleccionar columnas donde iran los datos");
        panelImage1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jbtLoadNameColumns.setText("Cargar");
        jbtLoadNameColumns.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtLoadNameColumns.setEnabled(false);
        panelImage1.add(jbtLoadNameColumns, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("BANCO");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.setEnabled(false);
        panelImage1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("DNI");
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.setEnabled(false);
        panelImage1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("CODIGO_CLIENTE");
        jCheckBox3.setContentAreaFilled(false);
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox3.setEnabled(false);
        panelImage1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("CLIENTE");
        jCheckBox4.setContentAreaFilled(false);
        jCheckBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox4.setEnabled(false);
        panelImage1.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jCheckBox6.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("MONTO_CAMPAÑA");
        jCheckBox6.setContentAreaFilled(false);
        jCheckBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox6.setEnabled(false);
        panelImage1.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 230, -1, -1));

        jCheckBox7.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("MONTO_TOTAL");
        jCheckBox7.setContentAreaFilled(false);
        jCheckBox7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox7.setEnabled(false);
        panelImage1.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 230, -1, -1));

        jLabel13.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombres de columnas:");
        panelImage1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtFileExcel;
    public javax.swing.JButton jbtLoadCustomers;
    public javax.swing.JButton jbtLoadNameColumns;
    public javax.swing.JComboBox<String> jcbDatabaseList;
    public javax.swing.JLabel jlColumnsExcel;
    public javax.swing.JTextField jtfFileExcel;
    public javax.swing.JTextField jtfNumColumns;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
