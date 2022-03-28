package mvc.view;

import javax.swing.UIManager;

public class ViewLoadDataEmails extends javax.swing.JFrame {
    
    public ViewLoadDataEmails() throws Exception{
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
        jbtLoadEmails = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jcbDatabaseList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_main.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat Alternates ExtraBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema de carga de data de correos");
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
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("El archivo excel seleccionado debe contener SOLAMENTE las columnas de  CLIENTE y CORREO, sino puede haber");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        panelImage1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 770, 80));

        jbtLoadEmails.setText("Cargar correos");
        panelImage1.add(jbtLoadEmails, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Archivo excel:");
        panelImage1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jcbDatabaseList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Seleccione ----" }));
        panelImage1.add(jcbDatabaseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 220, -1));

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
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtFileExcel;
    public javax.swing.JButton jbtLoadEmails;
    public javax.swing.JComboBox<String> jcbDatabaseList;
    public javax.swing.JTextField jtfFileExcel;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
