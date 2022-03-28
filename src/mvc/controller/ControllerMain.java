package mvc.controller;

import codes.ExecuteAutomaticMail;
import codes.ExtraCode;
import files.FileClass;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mail.ControllerMail;
import mail.Mail;
import mvc.model.ModelDataCustomers;
import mvc.model.ModelEmails;
import mvc.view.ViewMain;
import mysql.TableDataCustomers;

public class ControllerMain extends ViewMain implements ActionListener{
    
    private static ControllerMain instance;
    private ArrayList<String> listCustomers;
    private FileClass fileClass;
    private ModelEmails modelEmails;
    private ExecuteAutomaticMail executeAM;
    private int listPositionCustomer;
    private int timeToSend;
    private String emailsTest="";
    
    public ControllerMain()throws Exception{
        super();
        this.registerEvents();
        this.registerObjects();
    }
    
    public static ControllerMain getInstance() throws Exception{
        return instance=new ControllerMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jcbShowPassword==e.getSource()){
            this.cbShowPassword();
        }else if(jbtBrowseFolderFiles==e.getSource()){
            this.btnBrowseFolderFiles();
        }else if(jcbEditFor==e.getSource()){
            this.cbEditFor();
        }else if(jcbEditSubject==e.getSource()){
            this.cbEditSubject();
        }else if(jcbEditBody==e.getSource()){
            this.cbEditBody();
        }else if(jcbEditCustomer==e.getSource()){
            this.cbEditCustomer();
        }else if(jbtStart==e.getSource()){
            this.btnStart();
        }else if(jbtPause==e.getSource()){
            this.btnPause();
        }else if(jbtGoOptionData==e.getSource()){
            this.btnGoOptionData();
        }else if(jbtSelectDatabase==e.getSource()){
            this.btnSelectDatabase();
        }else if(jbtFinish==e.getSource()){
            this.btnStop();
        }else if(jbtContinue==e.getSource()){
            this.btnContinue();
        }else if(jbtSendEmail==e.getSource()){
            this.btnSendEmail();
        }else if(jrbAutomatic==e.getSource()){
            this.rbAutomatic();
        }else if(jrbManual==e.getSource()){
            this.rbManual();
        }else if(jbtRegisterMySQL==e.getSource()){
            this.btnRegisterMySQL();
        }
    }
    
    private void registerEvents(){
        this.jbtRegisterMySQL.addActionListener(this);
        this.jcbShowPassword.addActionListener(this);
        this.jbtBrowseFolderFiles.addActionListener(this);
        this.jcbEditFor.addActionListener(this);
        this.jcbEditSubject.addActionListener(this);
        this.jcbEditBody.addActionListener(this);
        this.jcbEditCustomer.addActionListener(this);
        this.jbtStart.addActionListener(this);
        this.jbtPause.addActionListener(this);
        this.jbtGoOptionData.addActionListener(this);
        this.jbtSelectDatabase.addActionListener(this);
        this.jbtFinish.addActionListener(this);
        this.jbtPause.addActionListener(this);
        this.jbtContinue.addActionListener(this);
        this.jbtSendEmail.addActionListener(this);
        this.jrbAutomatic.addActionListener(this);
        this.jrbManual.addActionListener(this);
        this.jrbTest.addActionListener(this);
        this.jrbCustomers.addActionListener(this);
        this.jbtSendEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
            }
        });
        this.jtfSetTimeMinutes.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                ExtraCode.verifyTypeLetter(e);
            }
        });
    }
    
    private void registerObjects(){
        this.fileClass=new FileClass();
        this.listCustomers=new ArrayList<>();
        this.modelEmails=new ModelEmails();
        this.executeAM=new ExecuteAutomaticMail(this);
        this.listPositionCustomer=0;
        this.timeToSend=0;
        
        ExtraCode.loadDataComboBox(jcbFirm, (ArrayList)fileClass.getListFirms());
        ExtraCode.loadDataComboBox(jcbTemplates, (ArrayList)fileClass.getListTemplates());
        
        this.jlCurrentDatabase.setText(fileClass.getMySQLCurrentDatabase());
        this.setVisible(true);
    }
    
    /*JRadioButtons*/
    private void rbAutomatic(){
        this.jtfSetTimeMinutes.setEditable(true);
    }
    
    private void rbManual(){
        this.jtfSetTimeMinutes.setEditable(false);
        this.jtfSetTimeMinutes.setText(null);
    }
    
    /*CheckBox*/
    private void cbEditCustomer(){
        if(jcbEditCustomer.isSelected()){
            this.jtfCustomer.setEditable(true);
        }else{
            this.jtfCustomer.setEditable(false);
        }
    }
    
    private void cbEditBody(){
        if(jcbEditBody.isSelected()){
            this.jepBody.setEditable(true);
        }else{
            this.jepBody.setEditable(false);
        }
    }
    
    private void cbEditSubject(){
        if(jcbEditSubject.isSelected()){
            this.jtfSubject.setEditable(true);
        }else{
            this.jtfSubject.setEditable(false);
        }
    }
    
    private void cbEditFor(){
        if(jcbEditFor.isSelected()){
            this.jtfFor.setEditable(true);
        }else{
            this.jtfFor.setEditable(false);
        }
    }
    
    private void cbShowPassword(){
        if(jcbShowPassword.isSelected()){
            this.jpPasswordEmail.setEchoChar((char)0);
        }else{
            this.jpPasswordEmail.setEchoChar('•');
        }
    }
    
    /*Buttons*/
    private void btnRegisterMySQL(){
        try {
            ControllerConnection.getInstance();
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnSelectDatabase(){
        JComboBox jcb=new JComboBox();
        ExtraCode.loadDataComboBox(jcb, fileClass.getDatabaseList());
        JOptionPane.showMessageDialog(null, jcb,"Seleccione base de datos",0);
        if(jcb.getSelectedIndex()!=0){
            String nameDB=jcb.getSelectedItem().toString();
            this.fileClass.setMySQLCurrentDatabase(nameDB);
            this.jlCurrentDatabase.setText(fileClass.getMySQLCurrentDatabase());
            this.repaint();
        }else{
            ExtraCode.sendMessageError("Error: Debe selecciona una base de datos.");
        }
    }
    
    private void btnGoOptionData(){
        try {
            if(jcbOptionsData.getSelectedIndex()!=0){
                if(jcbOptionsData.getSelectedIndex()==1){
                    ControllerLoadDataEmails.getInstance();
                    this.dispose();
                }else if(jcbOptionsData.getSelectedIndex()==2){
                    ControllerLoadDataCustomers.getInstance();
                    this.dispose();
                }
            }else{
                ExtraCode.sendMessageError("Error: Debe de seleccionar una opción de data, vuelva a intentarlo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void btnBrowseFolderFiles(){
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);
        if (jfc.showDialog(this, "Seleccione carpeta de archivos PDF") == JFileChooser.APPROVE_OPTION) {
            if(ExtraCode.verifyFilesPDF(jfc.getSelectedFile().getAbsolutePath(), listCustomers)==null){
                this.jtfDirectoryPDFs.setText(jfc.getSelectedFile().getAbsolutePath());
                this.repaint();
            }else{
                ExtraCode.sendMessageError("Error: Se encontró un archivo con diferente extensión a lo indicado.\nVerifique los archivos de la carpeta e intentelo de nuevo.");
            }
        }
    }
    
    private void btnSendEmail(){
        this.executeAM.start();
        this.executeAM.resumeThread();
        this.executeAM=new ExecuteAutomaticMail(this);
    }
    
    private void btnStart(){
        String emailFrom=jtfEmail.getText();
        if(!emailFrom.isEmpty()){
            String passwordFrom=new String(jpPasswordEmail.getPassword());
            if(!passwordFrom.isEmpty()){
                if(jrbManual.isSelected()){
                    String directoryPDFs=jtfDirectoryPDFs.getText();
                    if(!directoryPDFs.isEmpty()){
                        String currentDatabase=jlCurrentDatabase.getText();
                        if(!currentDatabase.isEmpty()){
                            if(jcbTemplates.getSelectedIndex()!=0){
                                this.jbtStart.setEnabled(false);
                                this.jbtContinue.setEnabled(true);
                                this.jbtSendEmail.setEnabled(true);
                                this.jbtPause.setEnabled(false);
                                this.jbtFinish.setEnabled(true);
                                this.emailsTest=ExtraCode.getTestEmails(" ;");
                                this.statusButtons(false);
                                this.updateDataMail();
                            }else{
                                ExtraCode.sendMessageError("Error: Debe seleccionar un tipo de plantilla, vuelva a intentarlo.");
                            }
                        }else{
                            ExtraCode.sendMessageError("Error: Debe seleccionar o registrar una base de datos cargada con la data de clientes.");
                        }
                    }else{
                        ExtraCode.sendMessageError("Error: Carpeta de archivos PDF no seleccionada, vuelva a intentarlo.");
                    }
                }else{
                    if(jrbAutomatic.isSelected()){
                        String minutesInString=jtfSetTimeMinutes.getText();
                        if(!minutesInString.isEmpty()){
                            double minutes=Double.parseDouble(minutesInString);
                            this.timeToSend=Integer.parseInt(String.valueOf(Math.round((60000*minutes)*100)/100));
                            String directoryPDFs=jtfDirectoryPDFs.getText();
                            if(!directoryPDFs.isEmpty()){
                                String currentDatabase=jlCurrentDatabase.getText();
                                if(!currentDatabase.isEmpty()){
                                    if(jcbTemplates.getSelectedIndex()!=0){
                                        this.jbtStart.setEnabled(false);
                                        this.jbtContinue.setEnabled(false);
                                        this.jbtSendEmail.setEnabled(false);
                                        this.jbtPause.setEnabled(true);
                                        this.jbtFinish.setEnabled(true);
                                        this.emailsTest=ExtraCode.getTestEmails(" ;");
                                        this.statusButtons(false);
                                        this.executeAM.start();
                                    }else{
                                        ExtraCode.sendMessageError("Error: Debe seleccionar un tipo de plantilla, vuelva a intentarlo.");
                                    }
                                }else{
                                    ExtraCode.sendMessageError("Error: Debe seleccionar o registrar una base de datos cargada con la data de clientes.");
                                }
                            }else{
                                ExtraCode.sendMessageError("Error: Carpeta de archivos PDF no seleccionada, vuelva a intentarlo.");
                            }
                        }else{
                            ExtraCode.sendMessageError("Error: Debe establecer un tiempo de envio por minuto, vuelva a intentarlo.");
                        }
                    }
                }
            }else{
                ExtraCode.sendMessageError("Error: Contraseña de la cuenta quién envia no ingresado, vuelva a intentarlo1.");
            }
        }else{
            ExtraCode.sendMessageError("Error: Correo del quién envia no ingresado, vuelva a intentarlo.");
        }
    }
    
    private void btnPause(){
        if(jrbAutomatic.isSelected()){
            this.jbtContinue.setEnabled(true);
            this.jbtPause.setEnabled(false);
            this.executeAM.pauseThread();
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void btnContinue(){
        if(jrbManual.isSelected()){
            this.updateDataMail();
        }else if(jrbAutomatic.isSelected()){
            String minutesInString=jtfSetTimeMinutes.getText();
            if(!minutesInString.isEmpty()){
                this.jbtContinue.setEnabled(false);
                this.jbtPause.setEnabled(true);
                double minutes=Double.parseDouble(minutesInString);
                this.timeToSend=Integer.parseInt(String.valueOf(Math.round((60000*minutes)*100)/100));
                this.executeAM.resumeThread();
            }else{
                ExtraCode.sendMessageError("Error: Debe establecer un tiempo de envio por minuto, vuelva a intentarlo.");
            }
        }
    }
    
    private void btnStop(){
        this.executeAM.stop();
        this.executeAM=new ExecuteAutomaticMail(this);
        this.listCustomers.clear();
        this.modelEmails=new ModelEmails();
        this.listPositionCustomer=0;
        this.emailsTest="";
        this.jcbTemplates.setSelectedIndex(0);
        this.jtfCustomer.setText(null);
        this.jtfFor.setText(null);
        this.jtfSubject.setText(null);
        this.jepBody.setText(null);
        this.jcbFirm.setSelectedIndex(0);
        this.jtfDirectoryPDFs.setText(null);
        this.jtfCurrentPathFile.setText(null);
        this.jbtStart.setEnabled(true);
        this.jbtContinue.setEnabled(false);
        this.jbtSendEmail.setEnabled(false);
        this.jbtPause.setEnabled(false);
        this.jbtFinish.setEnabled(false);
        this.statusButtons(true);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    /*Metods*/
    private void statusButtons(boolean status){
        this.jtfEmail.setEditable(status);
        this.jpPasswordEmail.setEditable(status);
        this.jrbAutomatic.setEnabled(status);
        this.jrbManual.setEnabled(status);
        this.jrbTest.setEnabled(status);
        this.jrbCustomers.setEnabled(status);
    }
    
    private void updateDataMail(){
        if(listPositionCustomer<listCustomers.size()){
            this.jtfCurrentPathFile.setText(jtfDirectoryPDFs.getText()+"\\"+listCustomers.get(listPositionCustomer)+".pdf");
            this.jtfCustomer.setText(listCustomers.get(listPositionCustomer));
            if(jrbTest.isSelected()){
                this.jtfFor.setText((String) emailsTest.subSequence(0, emailsTest.length() -2));
            }else if(jrbCustomers.isSelected()){
                this.jtfFor.setText(modelEmails.getEmailsTo(jtfCustomer.getText(), " ;"));
            }
            String bodyText="";
            String subject="";
            String template=jcbTemplates.getSelectedItem().toString();
            if(template.equalsIgnoreCase("PLANTILLA-ECL")){
                subject=fileClass.getTemplateSubject(template).replaceFirst("%customer_fullname%", listCustomers.get(listPositionCustomer));
                ArrayList<ModelDataCustomers> list=TableDataCustomers.getInstance().getAll();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getCustomer().equalsIgnoreCase(listCustomers.get(listPositionCustomer))){
                        bodyText=fileClass.getTemplate(template).replaceAll("%customer_fullname%", jtfCustomer.getText()).replaceAll("%num_account%", list.get(i).getCodeCustomer()).replaceAll("%balance_total%", list.get(i).getAmount_total());
                        break;
                    }
                }
            }else if(template.equalsIgnoreCase("PLANTILLA-J&E")){
                subject=fileClass.getTemplateSubject(template).replaceFirst("%customer_fullname%", listCustomers.get(listPositionCustomer));
                ArrayList<ModelDataCustomers> list=TableDataCustomers.getInstance().getAll();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getCustomer().equalsIgnoreCase(listCustomers.get(listPositionCustomer))){
                        bodyText=fileClass.getTemplate(template).replaceAll("%name_financial%", list.get(i).getBanco()).replaceAll("%balance_total%", list.get(i).getAmount_total());
                        break;
                    }
                }
            }else if(template.equalsIgnoreCase("PLANTILLA-JZG")){
                subject=fileClass.getTemplateSubject(template).replaceFirst("%customer_fullname%", listCustomers.get(listPositionCustomer));
                ArrayList<ModelDataCustomers> list=TableDataCustomers.getInstance().getAll();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getCustomer().equalsIgnoreCase(listCustomers.get(listPositionCustomer))){
                        bodyText=fileClass.getTemplate(template).replaceAll("%customer_fullname%", jtfCustomer.getText()).replaceAll("%balance_total%", list.get(i).getAmount_total());
                        break;
                    }
                }
            }else if(template.equalsIgnoreCase("PLANTILLA-RIPLEY")){
                subject=fileClass.getTemplateSubject(template).replaceFirst("%customer_fullname%", listCustomers.get(listPositionCustomer));
                ArrayList<ModelDataCustomers> list=TableDataCustomers.getInstance().getAll();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getCustomer().equalsIgnoreCase(listCustomers.get(listPositionCustomer))){
                        bodyText=fileClass.getTemplate(template).replaceAll("%customer_fullname%", jtfCustomer.getText()).replaceAll("%balance_total%", list.get(i).getAmount_total());
                        break;
                    }
                }
            }else if(template.equalsIgnoreCase("PLANTILLA-CREDIVISION")){
                subject=fileClass.getTemplateSubject(template).replaceFirst("%customer_fullname%", listCustomers.get(listPositionCustomer));
                ArrayList<ModelDataCustomers> list=TableDataCustomers.getInstance().getAll();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getCustomer().equalsIgnoreCase(listCustomers.get(listPositionCustomer))){
                        bodyText=fileClass.getTemplate(template).replaceAll("%customer_fullname%", jtfCustomer.getText()).replaceAll("%balance_total%", list.get(i).getAmount_total());
                        break;
                    }
                }
            }
            this.jtfSubject.setText(subject);
            this.jepBody.setText(bodyText);
            this.listPositionCustomer++;
            this.repaint();
        }else{
            this.jbtFinish.doClick();
        }
    }
    
    public boolean sendMail(){
        boolean status=false;
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            String username=jtfEmail.getText();
            String password=new String(jpPasswordEmail.getPassword());
            String destiny=jtfFor.getText();
            String subject=jtfSubject.getText();
            String body=jepBody.getText();
            String file=jtfCurrentPathFile.getText();
            Mail mail=new Mail(username, password, destiny, subject, body,file);
            if(ControllerMail.getInstance().sendMail(mail)){
                if(ExtraCode.deleteFile(file)){
                    System.out.println("[N°: "+listPositionCustomer+" - "+ExtraCode.getCurrentDate("dd/MM/yyyy hh:mm:ss aa")+"] Correo enviado con éxito a "+jtfCustomer.getText()+" ["+destiny+"]");
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    status=true;
                }else{
                    System.out.println("[N°: "+listPositionCustomer+" - "+ExtraCode.getCurrentDate("dd/MM/yyyy hh:mm:ss aa")+"] Correo enviado con éxito a "+jtfCustomer.getText()+" ["+destiny+"]");
                    System.err.println("["+ExtraCode.getCurrentDate("dd/MM/yyyy hh:mm:ss aa")+"] No se pudo eliminar el archivo del "+destiny);
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    status=true;
                }
            }else{
                System.err.println("[N°: "+listPositionCustomer+" - "+ExtraCode.getCurrentDate("dd/MM/yyyy hh:mm:ss aa")+"] Error: No se pudo enviar el correo a "+jtfCustomer.getText()+" ["+destiny+"], pruebe nuevamente o hágalo manualmente.");
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        return status;
    }
    
    public void sendMailAutomatic(){
        try {
            this.updateDataMail();
            this.sendMail();
            try {
                Thread.sleep(timeToSend);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
