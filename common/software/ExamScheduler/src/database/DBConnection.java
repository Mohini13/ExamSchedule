package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

public class DBConnection {

    private static DBConnection theConnection = null;
    final String url = "jdbc:oracle:thin:robproject/oracle@dilbert.humber.ca:1521:grok";
    public String err = null;

    public boolean driverLoaded = false;
    public static Connection con = null;

    private static Statement statement;

    private DBConnection() {
        theConnection = this; // ?
        init();
    }

    public static DBConnection getInstance() {
        if (theConnection == null) {
            theConnection = new DBConnection();
        }
        return theConnection;
    }

    private void init() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(url);
            con = ods.getConnection();
            statement = con.createStatement();
        } catch (Exception e1) {
            err = e1.toString();
        }
    }

    // this is used in queries
    public static Statement getStatement() {
        return statement;
    }    
    // close connection on server shutdown
    public void destroy() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e1) {
           
        }

    }

}
