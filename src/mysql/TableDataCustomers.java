package mysql;

import files.FileClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.model.ModelConnection;
import mvc.model.ModelDataCustomers;

public class TableDataCustomers extends MySQLConnection implements IMySQLTableCruds{
    
    private static TableDataCustomers instance;
    private FileClass fileClass;
    private ModelConnection modelConnection;

    public TableDataCustomers() {
        super();
        this.registerObjects();
    }
    
    public static TableDataCustomers getInstance(){
        return instance=new TableDataCustomers();
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
            ModelDataCustomers me=(ModelDataCustomers)data;
            String sql="INSERT INTO data_customers(DNI,CODIGO_CLIENTE,CLIENTE,MONTO_CAMPAÑA,MONTO_TOTAL,BANCO) VALUES(?,?,?,?,?,?);";
            PreparedStatement ps=openConnection(modelConnection).prepareStatement(sql);
            ps.setString(1, me.getDni());
            ps.setString(2, me.getCodeCustomer());
            ps.setString(3, me.getCustomer());
            ps.setString(4, me.getAmount_campaign());
            ps.setString(5, me.getAmount_total());
            ps.setString(6, me.getBanco());
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
            ModelDataCustomers mdc=(ModelDataCustomers)data;
            String sql="DELETE FROM data_customers WHERE "+column+"=?";
            PreparedStatement ps=openConnection(modelConnection).prepareStatement(sql);
            if(column.equalsIgnoreCase("idData")){
                ps.setInt(1, mdc.getId());
            }else if(column.equalsIgnoreCase("DNI")){
                ps.setString(1, mdc.getDni());
            }else if(column.equalsIgnoreCase("CODIGO_CLIENTE")){
                ps.setString(1, mdc.getCodeCustomer());
            }else if(column.equalsIgnoreCase("CLIENTE")){
                ps.setString(1, mdc.getCustomer());
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
            ModelDataCustomers mdc=(ModelDataCustomers)data;
            String sql="UPDATE data_customers SET "+column+"=? WHERE idData="+mdc.getId();
            PreparedStatement ps=openConnection(modelConnection).prepareStatement(sql);
            if(column.equalsIgnoreCase("idData")){
                ps.setInt(1, mdc.getId());
            }else if(column.equalsIgnoreCase("DNI")){
                ps.setString(1, mdc.getDni());
            }else if(column.equalsIgnoreCase("CODIGO_CLIENTE")){
                ps.setString(1, mdc.getCodeCustomer());
            }else if(column.equalsIgnoreCase("CLIENTE")){
                ps.setString(1, mdc.getCustomer());
            }else if(column.equalsIgnoreCase("MONTO_CAMPAÑA")){
                ps.setString(1, mdc.getAmount_campaign());
            }else if(column.equalsIgnoreCase("MONTO_TOTAL")){
                ps.setString(1, mdc.getAmount_total());
            }else if(column.equalsIgnoreCase("BANCO")){
                ps.setString(1, mdc.getBanco());
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
        ArrayList<ModelDataCustomers> list=new ArrayList<>();
        try {
            String sql="SELECT * FROM data_customers";
            Statement statement=openConnection(modelConnection).createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                ModelDataCustomers mdc=new ModelDataCustomers();
                mdc.setId(rs.getInt("idData"));
                mdc.setDni(rs.getString("DNI"));
                mdc.setCodeCustomer(rs.getString("CODIGO_CLIENTE"));
                mdc.setCustomer(rs.getString("CLIENTE"));
                mdc.setAmount_campaign(rs.getString("MONTO_CAMPAÑA"));
                mdc.setAmount_total(rs.getString("MONTO_TOTAL"));
                mdc.setBanco(rs.getString("BANCO"));
                list.add(mdc);
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
