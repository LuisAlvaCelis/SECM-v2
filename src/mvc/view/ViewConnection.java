package mvc.view;

import javax.swing.UIManager;

public class ViewConnection extends javax.swing.JFrame {

    public ViewConnection() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jlStatusConnection = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDetailsConnection = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jtfIp = new javax.swing.JTextField();
        jtfPort = new javax.swing.JTextField();
        jtfDatabase = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jcbShowPassword = new javax.swing.JCheckBox();
        jbtSaveConnection = new javax.swing.JButton();
        jbtRegisterDatabase = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbDatabaseList = new javax.swing.JComboBox<>();
        jbtDeleteDatabase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_main.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlStatusConnection.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jlStatusConnection.setForeground(new java.awt.Color(255, 255, 255));
        jlStatusConnection.setText("Desconectado");
        panelImage1.add(jlStatusConnection, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat Alternates ExtraBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de registro de conexión MYSQL");
        panelImage1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtaDetailsConnection.setEditable(false);
        jtaDetailsConnection.setColumns(20);
        jtaDetailsConnection.setRows(5);
        jScrollPane1.setViewportView(jtaDetailsConnection);

        panelImage1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 480, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado actual de conexión:");
        panelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar conexión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates SemiBold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ip:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Puerto:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Base de datos:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel1.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 230, -1));
        jPanel1.add(jtfIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 230, -1));
        jPanel1.add(jtfPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 230, -1));
        jPanel1.add(jtfDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, -1));
        jPanel1.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 230, -1));

        jcbShowPassword.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jcbShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        jcbShowPassword.setText("Mostrar contraseña");
        jcbShowPassword.setBorder(null);
        jcbShowPassword.setContentAreaFilled(false);
        jcbShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_off.png"))); // NOI18N
        jcbShowPassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_on.png"))); // NOI18N
        jPanel1.add(jcbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jbtSaveConnection.setText("Guardar conexión");
        jPanel1.add(jbtSaveConnection, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 190, -1));

        jbtRegisterDatabase.setText("Crear y guardar base de datos");
        jPanel1.add(jbtRegisterDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 190, -1));

        panelImage1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 510, 300));

        jLabel10.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Detalles de conexión:");
        panelImage1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Bases de datos disponibles:");
        panelImage1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jcbDatabaseList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        panelImage1.add(jcbDatabaseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 280, -1));

        jbtDeleteDatabase.setText("Eliminar base de datos");
        panelImage1.add(jbtDeleteDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtDeleteDatabase;
    public javax.swing.JButton jbtRegisterDatabase;
    public javax.swing.JButton jbtSaveConnection;
    public javax.swing.JComboBox<String> jcbDatabaseList;
    public javax.swing.JCheckBox jcbShowPassword;
    public javax.swing.JLabel jlStatusConnection;
    public javax.swing.JPasswordField jpfPassword;
    public javax.swing.JTextArea jtaDetailsConnection;
    public javax.swing.JTextField jtfDatabase;
    public javax.swing.JTextField jtfIp;
    public javax.swing.JTextField jtfPort;
    public javax.swing.JTextField jtfUsername;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
