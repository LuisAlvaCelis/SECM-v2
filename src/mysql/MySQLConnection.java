package mysql;

import java.sql.*;
import mvc.model.ModelConnection;

public class MySQLConnection{
    
    private static MySQLConnection instance;
    private Connection connection;
    
    public MySQLConnection(){
        super();
    }
    
    public static MySQLConnection getInstance(){
        return instance=new MySQLConnection();
    }
    
    public Connection openConnection(ModelConnection mc){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://"+mc.getIp()+":"+mc.getPort()+"/"+mc.getDatabase()+"?allowPublicKeyRetrieval=true&useSSL=false";
            this.connection=DriverManager.getConnection(url,mc.getUsername(),mc.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void closeConnection(){
        try {
            if(!connection.isClosed()){
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteDatabase(ModelConnection mc){
        boolean status=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://"+mc.getIp()+":"+mc.getPort()+"/?allowPublicKeyRetrieval=true&useSSL=false",mc.getUsername(),mc.getPassword());
            Statement statement=con.createStatement();
            int result=statement.executeUpdate("DROP DATABASE "+mc.getDatabase());
            if(result>0){
                status=true;
            }
            statement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean createDatabase(ModelConnection mc) {
        boolean status=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://"+mc.getIp()+":"+mc.getPort()+"/?allowPublicKeyRetrieval=true&useSSL=false",mc.getUsername(),mc.getPassword());
            Statement statement=con.createStatement();
            int result=statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+mc.getDatabase());
            if(result>0){
                status=true;
            }
            statement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean createTableEmail(ModelConnection mc){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS emails("
                    + "idEmails INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                    + "CLIENTE VARCHAR(100) NOT NULL,"
                    + "CORREO VARCHAR(150) NOT NULL"
                    + ");";
            Statement statement=openConnection(mc).createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.closeConnection();
        }
        return status;
    }
    
    public boolean createTableDataCustomer(ModelConnection mc){
        boolean status=false;
        try {
            String url="CREATE TABLE IF NOT EXISTS data_customers("
                    + "idData INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                    + "DNI VARCHAR(15) NOT NULL,"
                    + "CODIGO_CLIENTE VARCHAR(50) NOT NULL,"
                    + "CLIENTE VARCHAR(100) NOT NULL,"
                    + "MONTO_CAMPAÑA VARCHAR(20) DEFAULT NULL,"
                    + "MONTO_TOTAL VARCHAR(20) DEFAULT NULL,"
                    + "BANCO VARCHAR(30) DEFAULT NULL);";
            Statement statement=openConnection(mc).createStatement();
            int result=statement.executeUpdate(url);
            if(result==0){
                status=true;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            
        }
        return status;
    }
}
