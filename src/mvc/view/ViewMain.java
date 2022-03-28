package mvc.view;

import javax.swing.UIManager;

public class ViewMain extends javax.swing.JFrame {

    public ViewMain() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbgShippingMethod = new javax.swing.ButtonGroup();
        jbgModalitySend = new javax.swing.ButtonGroup();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jpPasswordEmail = new javax.swing.JPasswordField();
        jcbShowPassword = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfDirectoryPDFs = new javax.swing.JTextField();
        jbtBrowseFolderFiles = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtfCurrentPathFile = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtfSubject = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbEditBody = new javax.swing.JCheckBox();
        jcbEditFor = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbFirm = new javax.swing.JComboBox<>();
        jbtFinish = new javax.swing.JButton();
        jbtStart = new javax.swing.JButton();
        jbtPause = new javax.swing.JButton();
        jcbEditSubject = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jepBody = new javax.swing.JEditorPane();
        jtfFor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfCustomer = new javax.swing.JTextField();
        jcbEditCustomer = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jcbTemplates = new javax.swing.JComboBox<>();
        jbtContinue = new javax.swing.JButton();
        jbtSendEmail = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlCurrentDatabase = new javax.swing.JLabel();
        jbtGoOptionData = new javax.swing.JButton();
        jcbOptionsData = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jbtSelectDatabase = new javax.swing.JButton();
        jbtRegisterMySQL = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jrbAutomatic = new javax.swing.JRadioButton();
        jrbManual = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtfSetTimeMinutes = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jrbCustomers = new javax.swing.JRadioButton();
        jrbTest = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_main.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat Alternates ExtraBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema de Envio de Correos Masivos");
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuenta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates Medium", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jtfEmail.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel1.add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Correo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jpPasswordEmail.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jpPasswordEmail.setEchoChar('•');
        jPanel1.add(jpPasswordEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 140, -1));

        jcbShowPassword.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jcbShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        jcbShowPassword.setText("Mostrar contraseña");
        jcbShowPassword.setBorder(null);
        jcbShowPassword.setContentAreaFilled(false);
        jcbShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_off.png"))); // NOI18N
        jcbShowPassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_on.png"))); // NOI18N
        jPanel1.add(jcbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        panelImage1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 550, 100));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Archivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates Medium", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Carpeta con archivos pdf:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jtfDirectoryPDFs.setEditable(false);
        jtfDirectoryPDFs.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel2.add(jtfDirectoryPDFs, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 25, 240, -1));

        jbtBrowseFolderFiles.setText("Examinar");
        jbtBrowseFolderFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtBrowseFolderFiles.setFocusPainted(false);
        jPanel2.add(jbtBrowseFolderFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Path del archivo actual:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jtfCurrentPathFile.setEditable(false);
        jtfCurrentPathFile.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel2.add(jtfCurrentPathFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 55, 240, -1));

        panelImage1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 550, 100));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates Medium", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Firma:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        jtfSubject.setEditable(false);
        jtfSubject.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel3.add(jtfSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 470, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jcbEditBody.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jcbEditBody.setForeground(new java.awt.Color(255, 255, 255));
        jcbEditBody.setText("Editar");
        jcbEditBody.setBorder(null);
        jcbEditBody.setContentAreaFilled(false);
        jcbEditBody.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbEditBody.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_off.png"))); // NOI18N
        jcbEditBody.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_on.png"))); // NOI18N
        jPanel3.add(jcbEditBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        jcbEditFor.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jcbEditFor.setForeground(new java.awt.Color(255, 255, 255));
        jcbEditFor.setText("Editar");
        jcbEditFor.setBorder(null);
        jcbEditFor.setContentAreaFilled(false);
        jcbEditFor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbEditFor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_off.png"))); // NOI18N
        jcbEditFor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_on.png"))); // NOI18N
        jPanel3.add(jcbEditFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Plantilla:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cuerpo:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jcbFirm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccionar ----" }));
        jcbFirm.setFocusable(false);
        jPanel3.add(jcbFirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 440, -1));

        jbtFinish.setText("Finalizar");
        jbtFinish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtFinish.setEnabled(false);
        jbtFinish.setFocusPainted(false);
        jPanel3.add(jbtFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 90, -1));

        jbtStart.setText("Empezar");
        jbtStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtStart.setFocusPainted(false);
        jPanel3.add(jbtStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 90, -1));

        jbtPause.setText("Pausar");
        jbtPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtPause.setEnabled(false);
        jbtPause.setFocusPainted(false);
        jPanel3.add(jbtPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 90, -1));

        jcbEditSubject.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jcbEditSubject.setForeground(new java.awt.Color(255, 255, 255));
        jcbEditSubject.setText("Editar");
        jcbEditSubject.setBorder(null);
        jcbEditSubject.setContentAreaFilled(false);
        jcbEditSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbEditSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_off.png"))); // NOI18N
        jcbEditSubject.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_on.png"))); // NOI18N
        jPanel3.add(jcbEditSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, -1));

        jepBody.setEditable(false);
        jepBody.setContentType("text/html");
        jScrollPane2.setViewportView(jepBody);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 470, 320));

        jtfFor.setEditable(false);
        jtfFor.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel3.add(jtfFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 470, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Para:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jtfCustomer.setEditable(false);
        jtfCustomer.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel3.add(jtfCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 470, -1));

        jcbEditCustomer.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jcbEditCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jcbEditCustomer.setText("Editar");
        jcbEditCustomer.setBorder(null);
        jcbEditCustomer.setContentAreaFilled(false);
        jcbEditCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_off.png"))); // NOI18N
        jcbEditCustomer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_toggle_on.png"))); // NOI18N
        jPanel3.add(jcbEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Asunto:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jcbTemplates.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccionar ----" }));
        jcbTemplates.setFocusable(false);
        jPanel3.add(jcbTemplates, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 230, -1));

        jbtContinue.setText("Continuar");
        jbtContinue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtContinue.setEnabled(false);
        jbtContinue.setFocusPainted(false);
        jPanel3.add(jbtContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 90, -1));

        jbtSendEmail.setText("Enviar");
        jbtSendEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSendEmail.setEnabled(false);
        jbtSendEmail.setFocusPainted(false);
        jPanel3.add(jbtSendEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 90, -1));

        panelImage1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 690, 610));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates Medium", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlCurrentDatabase.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jlCurrentDatabase.setForeground(new java.awt.Color(255, 255, 255));
        jlCurrentDatabase.setText("null");
        jPanel4.add(jlCurrentDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jbtGoOptionData.setText("Ir");
        jbtGoOptionData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtGoOptionData.setFocusPainted(false);
        jPanel4.add(jbtGoOptionData, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jcbOptionsData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccionar ----", "Correos", "Data" }));
        jcbOptionsData.setFocusable(false);
        jPanel4.add(jcbOptionsData, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 230, -1));

        jLabel14.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ir al sistema de registro de bases de datos:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel15.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Base de datos actual:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jbtSelectDatabase.setText("Cambiar");
        jbtSelectDatabase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSelectDatabase.setFocusPainted(false);
        jPanel4.add(jbtSelectDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jbtRegisterMySQL.setText("Ir");
        jbtRegisterMySQL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRegisterMySQL.setFocusPainted(false);
        jPanel4.add(jbtRegisterMySQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Seleccione opción:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        panelImage1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 550, 180));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        panelImage1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 20, 640));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modalidad de Envio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates Medium", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbgShippingMethod.add(jrbAutomatic);
        jrbAutomatic.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jrbAutomatic.setForeground(new java.awt.Color(255, 255, 255));
        jrbAutomatic.setText("Automático");
        jrbAutomatic.setContentAreaFilled(false);
        jrbAutomatic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrbAutomatic.setFocusPainted(false);
        jPanel6.add(jrbAutomatic, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jbgShippingMethod.add(jrbManual);
        jrbManual.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jrbManual.setForeground(new java.awt.Color(255, 255, 255));
        jrbManual.setSelected(true);
        jrbManual.setText("Manual");
        jrbManual.setContentAreaFilled(false);
        jrbManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrbManual.setFocusPainted(false);
        jPanel6.add(jrbManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Seleccione modalidad de envío:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel17.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Establecer tiempo (En minutos):");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jtfSetTimeMinutes.setEditable(false);
        jPanel6.add(jtfSetTimeMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 80, -1));

        jLabel19.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Seleccione método de envio:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jbgModalitySend.add(jrbCustomers);
        jrbCustomers.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jrbCustomers.setForeground(new java.awt.Color(255, 255, 255));
        jrbCustomers.setText("Clientes");
        jrbCustomers.setContentAreaFilled(false);
        jrbCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrbCustomers.setFocusPainted(false);
        jPanel6.add(jrbCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jbgModalitySend.add(jrbTest);
        jrbTest.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jrbTest.setForeground(new java.awt.Color(255, 255, 255));
        jrbTest.setSelected(true);
        jrbTest.setText("Prueba");
        jrbTest.setContentAreaFilled(false);
        jrbTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrbTest.setFocusPainted(false);
        jPanel6.add(jrbTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        panelImage1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 550, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.ButtonGroup jbgModalitySend;
    private javax.swing.ButtonGroup jbgShippingMethod;
    public javax.swing.JButton jbtBrowseFolderFiles;
    public javax.swing.JButton jbtContinue;
    public javax.swing.JButton jbtFinish;
    public javax.swing.JButton jbtGoOptionData;
    public javax.swing.JButton jbtPause;
    public javax.swing.JButton jbtRegisterMySQL;
    public javax.swing.JButton jbtSelectDatabase;
    public javax.swing.JButton jbtSendEmail;
    public javax.swing.JButton jbtStart;
    public javax.swing.JCheckBox jcbEditBody;
    public javax.swing.JCheckBox jcbEditCustomer;
    public javax.swing.JCheckBox jcbEditFor;
    public javax.swing.JCheckBox jcbEditSubject;
    public javax.swing.JComboBox<String> jcbFirm;
    public javax.swing.JComboBox<String> jcbOptionsData;
    public javax.swing.JCheckBox jcbShowPassword;
    public javax.swing.JComboBox<String> jcbTemplates;
    public javax.swing.JEditorPane jepBody;
    public javax.swing.JLabel jlCurrentDatabase;
    public javax.swing.JPasswordField jpPasswordEmail;
    public javax.swing.JRadioButton jrbAutomatic;
    public javax.swing.JRadioButton jrbCustomers;
    public javax.swing.JRadioButton jrbManual;
    public javax.swing.JRadioButton jrbTest;
    public javax.swing.JTextField jtfCurrentPathFile;
    public javax.swing.JTextField jtfCustomer;
    public javax.swing.JTextField jtfDirectoryPDFs;
    public javax.swing.JTextField jtfEmail;
    public javax.swing.JTextField jtfFor;
    public javax.swing.JTextField jtfSetTimeMinutes;
    public javax.swing.JTextField jtfSubject;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
