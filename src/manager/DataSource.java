package manager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.*;

public class DataSource {
    private static MysqlDataSource ds = null;
    private static java.util.Properties p = null;
    private Logger logger = Logger.getLogger(this.getClass());

    public static javax.sql.DataSource getPool(HashMap<String,HashMap<Integer,String>> menu) {
        if (ds == null){
            ds = new MysqlDataSource();
            System.out.println(menu.get("server").get(0)+" "+menu.get("port").get(0)+" "+menu.get("db").get(0));
            ds.setServerName(menu.get("server").get(0));
            ds.setPortNumber(Integer.parseInt(menu.get("port").get(0)));
            ds.setDatabaseName(menu.get("db").get(0));
            ds.setUser(menu.get("user").get(0));
            ds.setPassword(menu.get("password").get(0));
            ds.setCharacterEncoding("utf-8");
        }
        
 
        return ds;
    }
 
    public static java.sql.Connection getConnection(HashMap<String,HashMap<Integer,String>> menu)
            throws java.sql.SQLException {
        return getPool(menu).getConnection();
    }
 
}
