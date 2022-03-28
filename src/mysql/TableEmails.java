package mysql;

import files.FileClass;
import java.util.ArrayList;
import mvc.model.ModelEmails;
import java.sql.*;
import mvc.model.ModelConnection;


public class TableEmails extends MySQLConnection implements IMySQLTableCruds{
    
    private static TableEmails instance;
    private FileClass fileClass;
    private ModelConnection modelConnection;
    
    public TableEmails(){
        super();
        this.registerObjects();
    }
    
    public static TableEmails getInstance(){
        return instance=new TableEmails();
    }
    
    private void registerObjects(){
        this.fileClass=new FileClass();
        String currentDatabase=fileClass.getMySQLCurrentDatabase();
        this.modelConnection=new ModelConnection(fileClass.getMySQLIp(currentDatabase),fileClass.getMySQLPort(currentDatabase),currentDatabase,fileClass.getMySQLUsername(currentDatabase),fileClass.getMySQLPassword(currentDatabase),fileClass.getMySQLStatus(currentDatabase));
    }

    @Override
    public boolean insert(Object data) {
        boolean status=false;
        try {
            ModelEmails me=(ModelEmails)data;
            String sql="INSERT INTO emails(CLIENTE,CORREO) VALUES(?,?);";
            PreparedStatement ps=openConnection(modelConnection).prepareStatement(sql);
            ps.setString(1, me.getCustomer());
            ps.setString(2, me.getEmail());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.closeConnection();
        }
        return status;
    }

    @Override
    public boolean delete(String column, Object data) {
        boolean status=false;
        try {
            ModelEmails me=(ModelEmails)data;
            String sql="DELETE FROM emails WHERE "+column+"=?";
            PreparedStatement ps=openConnection(modelConnection).prepareStatement(sql);
            if(column.equalsIgnoreCase("idEmails")){
                ps.setInt(1, me.getId());
            }else if(column.equalsIgnoreCase("CLIENTE")){
                ps.setString(1, me.getCustomer());
            }else if(column.equalsIgnoreCase("CORREO")){
                ps.setString(1, me.getEmail());
            }
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.closeConnection();
        }
        return status;
    }

    @Override
    public boolean update(String column, Object data) {
        boolean status=false;
        try {
            ModelEmails me=(ModelEmails)data;
            String sql="UPDATE emails SET "+column+"=? WHERE idEmails="+me.getId();
            PreparedStatement ps=openConnection(modelConnection).prepareStatement(sql);
            if(column.equalsIgnoreCase("CLIENTE")){
                ps.setString(1, me.getCustomer());
            }else if(column.equalsIgnoreCase("CORREO")){
                ps.setString(1, me.getEmail());
            }
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.closeConnection();
        }
        return status;
    }

    @Override
    public ArrayList getAll() {
        ArrayList<ModelEmails> list=new ArrayList<>();
        try {
            String sql="SELECT * FROM emails";
            Statement statement=openConnection(modelConnection).createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                ModelEmails me=new ModelEmails();
                me.setId(rs.getInt("idEmails"));
                me.setCustomer(rs.getString("CLIENTE"));
                me.setEmail(rs.getString("CORREO"));
                list.add(me);
            }
            rs.close();
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.closeConnection();
        }
        return list;
    }
    
}
