package codes;

import files.FileClass;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;

public class ExtraCode {
    
    public static String convertCellValueToString(Cell cell){
        String value=null;
        switch(cell.getCellTypeEnum()){
            case STRING -> value=cell.getStringCellValue();
            case NUMERIC -> value=String.valueOf(cell.getNumericCellValue());
            default -> {
            }
        }
        return value;
    }
    
    public static void verifyTypeLetter(KeyEvent e){
        if(Character.isLetter(e.getKeyChar())){
            e.consume();
            sendMessageError("Error: Debe colocar solo números, no  letras.");
        }
    }
    
    public static boolean deleteFile(String path){
        File file=new File(path);
        return file.delete();
    }
    
    public static String verifyFilesPDF(String path, ArrayList<String> list){
        String fileProblem=null;
        File folder=new File(path);
        for (File file : folder.listFiles()) {
            if(!file.getName().endsWith(".pdf")){
                fileProblem=file.getName();
                break;
            }else{
                list.add(file.getName().replaceAll(".pdf", ""));
            }
        }
        return fileProblem;
    }
    
    public static String getCurrentDate(String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(Calendar.getInstance().getTime());
    }
    
    public static String getTestEmails(String separate){
        String emails="";
        FileClass fc=new FileClass();
        for(int i=0;i<fc.getMailsTest().size();i++){
            emails=emails+fc.getMailsTest().get(i)+separate;
        }
        return emails;
    }
    
    public static void loadDataComboBox(JComboBox jcb,ArrayList data){
        jcb.removeAllItems();
        jcb.addItem("---- Seleccione ----");
        ArrayList<String> list=data;
        for(int i=0;i<list.size();i++){
            jcb.addItem(list.get(i));
        }
    }
    
    public static void sendMessageError(String msg){
        JOptionPane.showMessageDialog(null, msg, "Error", 0, new ImageIcon(new ExtraCode().getClass().getResource("/images/error32x32.png")));
    }
    
    public static void sendMessageSuccessful(String msg){
        JOptionPane.showMessageDialog(null, msg, "Éxito", 0, new ImageIcon(new ExtraCode().getClass().getResource("/images/exito32x32.png")));
    }
}
