package mysql;

import java.util.ArrayList;

public interface IMySQLTableCruds {
    
    public boolean insert(Object data);
    public boolean delete(String column,Object data);
    public boolean update(String column,Object data);
    public ArrayList getAll();
}
