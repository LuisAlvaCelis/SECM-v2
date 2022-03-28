package mvc.controller;

import codes.ExtraCode;
import files.FileClass;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import mvc.model.ModelEmails;
import mvc.view.ViewLoadDataEmails;
import mysql.TableEmails;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControllerLoadDataEmails extends ViewLoadDataEmails implements ActionListener{
    
    private static ControllerLoadDataEmails instance;
    private ModelEmails modelEmails;
    private FileClass fileClass;
    
    public ControllerLoadDataEmails()throws Exception{
        super();
        this.registerEvents();
        this.registerObjects();
    }
    
    public static ControllerLoadDataEmails getInstance()throws Exception{
        return instance=new ControllerLoadDataEmails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jbtFileExcel==e.getSource()){
            this.btnFileExcel();
        }else if(jbtLoadEmails==e.getSource()){
            this.btnLoadEmails();
        }
    }
    
    private void registerEvents(){
        this.jbtFileExcel.addActionListener(this);
        this.jbtLoadEmails.addActionListener(this);
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
        this.modelEmails=new ModelEmails();
        ExtraCode.loadDataComboBox(jcbDatabaseList, FileClass.getInstance().getDatabaseList());
        this.setVisible(true);
    }
    
    private void btnFileExcel(){
        JFileChooser jfc=new JFileChooser();
        if(jfc.showDialog(this, "Seleccione archivo (.xlsx)")==JFileChooser.APPROVE_OPTION){
            String path=jfc.getSelectedFile().getAbsolutePath();
            if(path.endsWith("xlsx")){
                this.jtfFileExcel.setText(path);
            }else{
                ExtraCode.sendMessageError("Error: Archivo no admitido, vuelva a intentarlo.");
            }
        }
    }
    
    private void btnLoadEmails(){
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            if(jcbDatabaseList.getSelectedIndex()!=0){
                String database=jcbDatabaseList.getSelectedItem().toString();
                this.fileClass.setMySQLCurrentDatabase(database);
                String path=jtfFileExcel.getText();
                if(!path.equalsIgnoreCase("")){
                    if(fileClass.getMySQLStatus(fileClass.getMySQLCurrentDatabase())){
                        FileInputStream fis=new FileInputStream(path);
                        XSSFWorkbook wb = new XSSFWorkbook(fis);
                        XSSFSheet sheet = wb.getSheetAt(0);
                        int numRows = sheet.getLastRowNum();
                        for (int i = 1; i <= numRows; i++) {
                            Row row = sheet.getRow(i);
                            this.modelEmails.setCustomer(row.getCell(0).getStringCellValue());
                            this.modelEmails.setEmail(row.getCell(1).getStringCellValue());
                            TableEmails te=new TableEmails();
                            if(te.insert(modelEmails)){
                                System.out.println("N° "+i+": "+modelEmails.getCustomer()+" - "+modelEmails.getEmail());
                            }else{
                                System.out.println("Error");
                                break;
                            }
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ExtraCode.sendMessageSuccessful("Carga de correos hacia la base de datos completada con éxito.");
                    }else{
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ExtraCode.sendMessageError("Error: Conexión no establecida, vuelva a intentarlo.");
                    }
                }else{
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    ExtraCode.sendMessageError("Error: Archivo excel no seleccionado, vuelva a intentarlo.");
                }
            }else{
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ExtraCode.sendMessageSuccessful("Error: Base de datos no seleccionado, vuelva a intentarlo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
