package mvc.controller;

import codes.ExtraCode;
import files.FileClass;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mvc.model.ModelConnection;
import mvc.view.ViewConnection;
import mysql.MySQLConnection;

public class ControllerConnection extends ViewConnection implements ActionListener{
    
    private static ControllerConnection instance;
    private ModelConnection modelConnection;
    private FileClass fileClass;
    
    public ControllerConnection()throws Exception{
        super();
        this.registerEvents();
        this.registerObjects();
    }
    
    public static ControllerConnection getInstance()throws Exception{
        return instance=new ControllerConnection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jcbShowPassword==e.getSource()){
            this.btnShowPassword();
        }else if(jbtRegisterDatabase==e.getSource()){
            this.btnRegisterDatabase();
        }else if(jbtSaveConnection==e.getSource()){
            this.btnSaveConnection();
        }else if(jbtDeleteDatabase==e.getSource()){
            this.btnDeleteDatabase();
        }
    }
    
    private void registerEvents(){
        this.jcbShowPassword.addActionListener(this);
        this.jbtRegisterDatabase.addActionListener(this);
        this.jbtSaveConnection.addActionListener(this);
        this.jbtDeleteDatabase.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    ControllerMain.getInstance();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void registerObjects(){
        this.fileClass=new FileClass();
        this.loadStatusMySQL();
        ExtraCode.loadDataComboBox(jcbDatabaseList,fileClass.getDatabaseList());
        this.setVisible(true);
    }
    
    private void loadStatusMySQL(){
        String currentDatabase=fileClass.getMySQLCurrentDatabase();
        this.modelConnection=new ModelConnection(fileClass.getMySQLIp(currentDatabase),fileClass.getMySQLPort(currentDatabase),currentDatabase,fileClass.getMySQLUsername(currentDatabase),fileClass.getMySQLPassword(currentDatabase),fileClass.getMySQLStatus(currentDatabase));
        if(modelConnection.isStatus()==false){
            this.jlStatusConnection.setText("Desconectado");
            this.jtaDetailsConnection.setText("No hay datos que mostrar.");
        }else{
            this.jlStatusConnection.setText("Conectado");
            this.jtaDetailsConnection.setText("Actualmente se encuentra conectado a través de los siguientes datos:\nIp: "+modelConnection.getIp()+"\nPuerto: "+modelConnection.getPort()+"\nBase de datos: "+modelConnection.getDatabase()+"\nUsuario: "+modelConnection.getUsername()+"\nContraseña: •••••••••••");
        }
    }
    
    private void btnDeleteDatabase(){
        JComboBox jcb=new JComboBox();
        ExtraCode.loadDataComboBox(jcb, fileClass.getDatabaseList());
        JOptionPane.showMessageDialog(null, jcb,"Seleccione base de datos",0);
        if(jcb.getSelectedIndex()!=0){
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            String nameDB=jcb.getSelectedItem().toString();
            this.modelConnection.setDatabase(nameDB);
            this.modelConnection.setIp(fileClass.getMySQLIp(nameDB));
            this.modelConnection.setPort(fileClass.getMySQLPort(nameDB));
            this.modelConnection.setUsername(fileClass.getMySQLUsername(nameDB));
            this.modelConnection.setPassword(fileClass.getMySQLPassword(nameDB));
            if(MySQLConnection.getInstance().deleteDatabase(modelConnection)){
                this.fileClass.setMySQLCurrentDatabase(null);
                this.fileClass.removeDatabaseFromConfig(nameDB);
                ExtraCode.loadDataComboBox(jcbDatabaseList, fileClass.getDatabaseList());
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ExtraCode.sendMessageSuccessful("Base de datos elimina con éxito.");
            }else{
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ExtraCode.sendMessageError("Error: No se pudo eliminar la base de datos, vuelva a intentarlo.");
            }
        }else{
            ExtraCode.sendMessageError("Error: Debe selecciona una base de datos.");
        }
    }
    
    private void btnShowPassword(){
        if(jcbShowPassword.isSelected()){
            this.jpfPassword.setEchoChar((char)0);
        }else{
            this.jpfPassword.setEchoChar('•');
        }
    }
    
    private void btnSaveConnection(){
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String ip=jtfIp.getText();
        String port=jtfPort.getText();
        String database=jtfDatabase.getText();
        String username=jtfUsername.getText();
        String password=new String(jpfPassword.getPassword());
        if(!ip.equalsIgnoreCase("")){
            if(!port.equalsIgnoreCase("")){
                if(!database.equalsIgnoreCase("")){
                    if(!username.equalsIgnoreCase("")){
                        if(!password.equalsIgnoreCase("")){
                            this.modelConnection=new ModelConnection(ip, port, database, username, password, true);
                            this.fileClass.saveCurrentConnection(modelConnection);
                            this.fileClass.addNewDatabaseName(database);
                            this.jtfIp.setText(null);
                            this.jtfPort.setText(null);
                            this.jtfDatabase.setText(null);
                            this.jtfUsername.setText(null);
                            this.jpfPassword.setText(null);
                            this.loadStatusMySQL();
                            ExtraCode.loadDataComboBox(jcbDatabaseList, fileClass.getDatabaseList());
                            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            ExtraCode.sendMessageSuccessful("Conexión guardada con éxito.");
                        }else{
                            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            ExtraCode.sendMessageError("Error: CONTRASEÑA no ingresada, vuelva a intentarlo.");
                        }
                    }else{
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ExtraCode.sendMessageError("Error: USUARIO no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    ExtraCode.sendMessageError("Error: BASE DE DATOS no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ExtraCode.sendMessageError("Error: PUERTO no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            ExtraCode.sendMessageError("Error: IP no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void btnRegisterDatabase(){
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String ip=jtfIp.getText();
        String port=jtfPort.getText();
        String database=jtfDatabase.getText();
        String username=jtfUsername.getText();
        String password=new String(jpfPassword.getPassword());
        if(!ip.equalsIgnoreCase("")){
            if(!port.equalsIgnoreCase("")){
                if(!database.equalsIgnoreCase("")){
                    if(!username.equalsIgnoreCase("")){
                        if(!password.equalsIgnoreCase("")){
                            this.modelConnection=new ModelConnection(ip, port, database, username, password, true);
                            if(fileClass.addNewDatabaseName(database)){
                                this.fileClass.saveCurrentConnection(modelConnection);
                                if(MySQLConnection.getInstance().createDatabase(modelConnection)){
                                    if(MySQLConnection.getInstance().createTableEmail(modelConnection)){
                                        if(MySQLConnection.getInstance().createTableDataCustomer(modelConnection)){
                                            this.jtfIp.setText(null);
                                            this.jtfPort.setText(null);
                                            this.jtfDatabase.setText(null);
                                            this.jtfUsername.setText(null);
                                            this.jpfPassword.setText(null);
                                            this.loadStatusMySQL();
                                            ExtraCode.loadDataComboBox(jcbDatabaseList, fileClass.getDatabaseList());
                                            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            ExtraCode.sendMessageSuccessful("Base de datos y tablas creadas con éxito.\nConexión guardada.");
                                        }else{
                                            this.modelConnection=new ModelConnection();
                                            this.fileClass.saveCurrentConnection(modelConnection);
                                            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            ExtraCode.sendMessageError("Error: No se pudo crear la tabla data_customers.");
                                        }
                                    }else{
                                        this.modelConnection=new ModelConnection();
                                        this.fileClass.saveCurrentConnection(modelConnection);
                                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        ExtraCode.sendMessageError("Error: No se pudo crear la tabla emails.");
                                    }
                                }else{
                                    this.modelConnection=new ModelConnection();
                                    this.fileClass.removeDatabaseFromConfig(database);
                                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    ExtraCode.sendMessageError("Error: No se pudo crear la base de datos.");
                                }
                            }else{
                                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                ExtraCode.sendMessageError("Error: No se pudo crear la base de datos, debido a que ya se encuentra disponible en la lista de bases de datos.");
                            }
                        }else{
                            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            ExtraCode.sendMessageError("Error: CONTRASEÑA no ingresada, vuelva a intentarlo.");
                        }
                    }else{
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ExtraCode.sendMessageError("Error: USUARIO no ingresado, vuelva a intentarlo.");
                    }
                }else{
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    ExtraCode.sendMessageError("Error: BASE DE DATOS no ingresado, vuelva a intentarlo.");
                }
            }else{
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ExtraCode.sendMessageError("Error: PUERTO no ingresado, vuelva a intentarlo.");
            }
        }else{
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            ExtraCode.sendMessageError("Error: IP no ingresado, vuelva a intentarlo.");
        }
    }
}
