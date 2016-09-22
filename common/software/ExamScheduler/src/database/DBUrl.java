package database;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import oracle.jdbc.OracleTypes;
import server.dbapi.DbUrlAdapter;
import server.exceptions.DatabaseException;

/**
 *
 * @author hani Tested by hani Dec 5
 *
 */
public class DBUrl extends DbUrlAdapter {

    PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    //Tested by hani Dec 7
    @Override
    public String createUrl(String _url) throws DatabaseException {
       // int url_id = 0;
        String sql = "{call insert_urls(:v_url_id, ?)}";

        try {
            CallableStatement cs = DBConnection.con.prepareCall(sql);
            cs.setString(2, _url);//always
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return _url;

        /*
         String sql = "INSERT INTO urls (url) "
         + "VALUES('" + _url + "' )";
         try {
         DBConnection.getStatement().executeUpdate(sql);
         } catch (SQLException ex) {
         throw new DatabaseException(ex);
         }

         return _url;*/
    }

    //Tested by hani Dec 5
    // returns an updated url (String)

    public static String setUrl(int _urlId, String _url) throws DatabaseException {

        String sql = "UPDATE urls SET url = '" + _url + "' WHERE url_id = " + _urlId;
        try {
            DBConnection.getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return _url;
    }

    //Tested by hani Dec 5
    // returns a number of rows deleted

    public static int deleteUrl(int _urlId) throws DatabaseException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM urls WHERE url_id = " + _urlId;
        try {
            rowsDeleted = DBConnection.getStatement().executeUpdate(sql);
            if (rowsDeleted == 0) {
                throw new DatabaseException("Nothing has been deleted: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return rowsDeleted;
    }

    //Tested by hani Dec 5

    public static String getUrl(int _urlId) throws DatabaseException {
        String r;
        String sql = "SELECT * FROM URLS WHERE url_id = " + _urlId;
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                rs.next();

                r = rs.getString("URL");
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
            //DBConnection.getStatement().close(); // ?
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    //Tested by hani Dec 5
    // returns a HashMap <url_id, url String itself>

    public static HashMap<Integer, String> getUrls() throws DatabaseException {
        HashMap<Integer, String> result = new HashMap<>();
        int id = 0;
        String r;
        String sql = "SELECT * FROM urls";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("url_id");
                    r = rs.getString("url");
                    result.put(id, r);
                }
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return result;
    }
}
