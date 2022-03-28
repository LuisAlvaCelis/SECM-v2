package files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mvc.model.ModelConnection;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileClass {
    
    private static FileClass instance;
    private final File directory;
    private final File file;
    private final YamlConfiguration config;
    
    public FileClass(){
        this.directory=new File("C:\\SECM");
        this.file=new File(directory,"config.yml");
        this.config=YamlConfiguration.loadConfiguration(file);
    }
    
    public static FileClass getInstance(){
        return instance=new FileClass();
    }
    
    public boolean createFile(){
        boolean status=false;
        try {
            if(!file.exists()){
                this.directory.mkdir();
                this.file.createNewFile();
                this.config.createSection("Firms");
                this.config.set("MySQL.status", false);
                this.config.set("MySQL.ip", "");
                this.config.set("MySQL.port", "");
                this.config.set("MySQL.database_currently_connected", "");
                this.config.set("MySQL.username", "");
                this.config.set("MySQL.password", "");
                this.config.save(file);
                status=true;
            }else{
                status=true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    private YamlConfiguration getConfigYML(){
        return config;
    }
    
    public void saveCurrentConnection(ModelConnection mc){
        try {
            this.getConfigYML().set("MySQL.database_currently_connected", mc.getDatabase());
            this.getConfigYML().set("MySQL."+mc.getDatabase()+".ip", mc.getIp());
            this.getConfigYML().set("MySQL."+mc.getDatabase()+".port", mc.getPort());
            this.getConfigYML().set("MySQL."+mc.getDatabase()+".username", mc.getUsername());
            this.getConfigYML().set("MySQL."+mc.getDatabase()+".password", mc.getPassword());
            this.getConfigYML().set("MySQL."+mc.getDatabase()+".status", mc.isStatus());
            this.getConfigYML().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList getMailsTest(){
        return (ArrayList)getConfigYML().getStringList("Mails-test");
    }
    
    public ArrayList getDatabaseList(){
        return (ArrayList)getConfigYML().getStringList("MySQL.database_list");
    }
    
    public boolean addNewDatabaseName(String name){
        boolean status=false;
        try {
            ArrayList<String> list=getDatabaseList();
            if(!list.contains(name)){
                list.add(name);
                this.getConfigYML().set("MySQL.database_list", list);
                this.getConfigYML().save(file);
                status=true;
            }else{
                System.out.println("Error: La base de datos ('"+name+"') ya ha sido registrado anteriormente.");
                status=false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public void removeDatabaseFromList(String name){
        try {
            ArrayList<String> list=getDatabaseList();
            for(int i=0;i<list.size();i++){
                if(list.get(i).equalsIgnoreCase(name)){
                    list.remove(i);
                    break;
                }
            }
            this.getConfigYML().set("MySQL.database_list", list);
            this.getConfigYML().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void removeDatabaseFromConfig(String db){
        try {
            this.getConfigYML().set("MySQL."+db, null);
            this.getConfigYML().set("MySQL.database_currently_connected", getDatabaseList().get(0));
            this.getConfigYML().save(file);
            this.removeDatabaseFromList(db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean getMySQLStatus(String db){
        return this.getConfigYML().getBoolean("MySQL."+db+".status");
    }
    
    public String getMySQLIp(String db){
        return this.getConfigYML().getString("MySQL."+db+".ip");
    }
    
    public String getMySQLPort(String db){
        return this.getConfigYML().getString("MySQL."+db+".port");
    }
    
    public String getMySQLCurrentDatabase(){
        return this.getConfigYML().getString("MySQL.database_currently_connected");
    }
    
    public void setMySQLCurrentDatabase(String db){
        try {
            this.getConfigYML().set("MySQL.database_currently_connected", db);
            this.getConfigYML().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getMySQLUsername(String db){
        return this.getConfigYML().getString("MySQL."+db+".username");
    }
    
    public String getMySQLPassword(String db){
        return this.getConfigYML().getString("MySQL."+db+".password");
    }
    
    public List getListFirms(){
        return getConfigYML().getStringList("Firms");
    }
    
    public List getListTemplates(){
        return getConfigYML().getStringList("Templates-list");
    }
    
    public String getTemplate(String name){
        return getConfigYML().getString("Templates."+name+".text");
    }
    
    public String getTemplateSubject(String name){
        return getConfigYML().getString("Templates."+name+".subject");
    }
}
