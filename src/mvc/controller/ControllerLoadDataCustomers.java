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
import mvc.model.ModelDataCustomers;
import mvc.view.ViewLoadDataCustomers;
import mysql.TableDataCustomers;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControllerLoadDataCustomers extends ViewLoadDataCustomers implements ActionListener{
    
    private static ControllerLoadDataCustomers instance;
    private ModelDataCustomers modelDC;
    private FileClass fileClass;
    
    public ControllerLoadDataCustomers() throws Exception{
        super();
        this.registerEvents();
        this.registerObjects();
    }
    
    public static ControllerLoadDataCustomers getInstance() throws Exception{
        return instance=new ControllerLoadDataCustomers();
    }
    
    private void registerEvents(){
        this.jbtFileExcel.addActionListener(this);
        this.jbtLoadCustomers.addActionListener(this);
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
        this.modelDC=new ModelDataCustomers();
        ExtraCode.loadDataComboBox(jcbDatabaseList, fileClass.getDatabaseList());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jbtFileExcel==e.getSource()){
            this.btnFileExcel();
        }else if(jbtLoadCustomers==e.getSource()){
            this.btnLoadCustomers();
        }
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
    
    private void btnLoadCustomers(){
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            if(jcbDatabaseList.getSelectedIndex()!=0){
                String database=jcbDatabaseList.getSelectedItem().toString();
                this.fileClass.setMySQLCurrentDatabase(database);
                String path=jtfFileExcel.getText();
                if(!path.equalsIgnoreCase("")){
                    if(!jtfNumColumns.getText().equalsIgnoreCase("")){
                        int columnsCount=Integer.parseInt(jtfNumColumns.getText());
                        if(fileClass.getMySQLStatus(fileClass.getMySQLCurrentDatabase())){
                            FileInputStream fis=new FileInputStream(path);
                            XSSFWorkbook wb = new XSSFWorkbook(fis);
                            XSSFSheet sheet = wb.getSheetAt(0);
                            int numRows = sheet.getLastRowNum();
                            boolean haveProblem=false;
                            for (int i = 1; i <= numRows; i++) {
                                Row row = sheet.getRow(i);
                                this.modelDC=new ModelDataCustomers();
                                for(int j=0;j<columnsCount;j++){
                                    if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("DNI")){
                                        System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " + ExtraCode.convertCellValueToString(row.getCell(j)));
                                        this.modelDC.setDni(ExtraCode.convertCellValueToString(row.getCell(j)));
                                    }
                                    if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("CODIGO_CLIENTE")){
                                        System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " + ExtraCode.convertCellValueToString(row.getCell(j)));
                                        this.modelDC.setCodeCustomer(ExtraCode.convertCellValueToString(row.getCell(j)));
                                    }
                                    if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("CLIENTE")){
                                        System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " + ExtraCode.convertCellValueToString(row.getCell(j)));
                                        this.modelDC.setCustomer(ExtraCode.convertCellValueToString(row.getCell(j)));
                                    }
                                    if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("MONTO_CAMPAÑA")){
                                        System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " + ExtraCode.convertCellValueToString(row.getCell(j)));
                                        this.modelDC.setAmount_campaign(ExtraCode.convertCellValueToString(row.getCell(j)));
                                    }
                                    if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("MONTO_TOTAL")){
                                        System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " + ExtraCode.convertCellValueToString(row.getCell(j)));
                                        this.modelDC.setAmount_total(ExtraCode.convertCellValueToString(row.getCell(j)));
                                    }
                                    if(sheet.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("BANCO")){
                                        System.out.println(sheet.getRow(0).getCell(j).getStringCellValue() + " - " + ExtraCode.convertCellValueToString(row.getCell(j)));
                                        this.modelDC.setBanco(ExtraCode.convertCellValueToString(row.getCell(j)));
                                    }
                                }
                                TableDataCustomers tdc=new TableDataCustomers();
                                if(tdc.insert(modelDC)){
                                    System.out.println("N° "+i+": "+modelDC.getDni()+" - "+modelDC.getCustomer());
                                }else{
                                    System.err.println("Error: No se pudo registar la data del cliente "+modelDC.getCustomer().toUpperCase());
                                    haveProblem=true;
                                    break;
                                }
                            }
                            if(haveProblem==false){
                                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                ExtraCode.sendMessageSuccessful("Carga de datos de clientes hacia la base de datos completada con éxito.");
                            }else{
                                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                ExtraCode.sendMessageError("Error: Hubo un problema a cargar la data de los clientes, verifique la consola o ");
                            }
                        }else{
                            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            ExtraCode.sendMessageError("Error: Conexión no establecida, vuelva a intentarlo.");
                        }
                    }else{
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        ExtraCode.sendMessageError("Error: Cantidad de columnas no ingresada, vuelva a intentarlo.");
                    }
                }else{
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    ExtraCode.sendMessageError("Error: Archivo excel no seleccionado, vuelva a intentarlo.");
                }
            }else{
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                ExtraCode.sendMessageError("Error: Base de datos no seleccionado, vuelva a intentarlo.");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
