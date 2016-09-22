/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Trisha
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import oracle.jdbc.OracleTypes;
import server.dbapi.DbServletTableAdapter;
import server.exceptions.DatabaseException;
import web.Servlet;
import web.ServletTable;

public class DBServletTable extends DbServletTableAdapter
{

    private static ResultSet rs = null;

    public static ServletTable addUrlServlet(String _url, Servlet _servlet) throws DatabaseException
    {
        ServletTable servTab = null;
        int servlet_id;
        String sql = "{call insert_servlet(:v_servlet_id, ?, ?)}";
        try
        {
            CallableStatement cs = DBConnection.con.prepareCall(sql);
            cs.setString(2, _url);
            cs.setString(3, _servlet.toString());
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();

            servlet_id = cs.getInt(1);
            servTab = new ServletTable(getServletTable());
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex.toString());
        }
        return servTab;

    }

    // this removes a url-servlet pair
    // returns an updated ServletTable
    public static ServletTable delUrlServlet(String _url, Servlet _servlet) throws DatabaseException
    {
        ServletTable servTab = null;
        String sql = "DELETE FROM SERVLET "
                + "WHERE url = '" + _url + "'"
                + " AND servlet_name = '" + _servlet + "'";
        try
        {
            DBConnection.getStatement().executeUpdate(sql);
            servTab = new ServletTable(getServletTable());
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex);
        }
        return servTab;
    }

    // this deletes all url-servlet pairs from database
    // returns a number of rows deleted
    public static int deleteServletTable() throws DatabaseException
    {
        int rowsDeleted = 0;

        try
        {

            String sql = "DELETE FROM SERVLET";
            rowsDeleted = DBConnection.getStatement().executeUpdate(sql);
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex);
        }
        return rowsDeleted;
    }

    // Ivan, Dec 7
    // if Servlet is a fully qualified class name, all server.api classes should implement Servlet interface?
    // returns a HashMap: url and Servlet
    public static HashMap<String, Servlet> getServletTable() throws DatabaseException
    {
        HashMap<String, Servlet> result = new HashMap<>();
        Servlet servlet = null;
        String url, servlet_name;
        String sql = "SELECT * FROM Servlet";
        try
        {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null)
            {
                while (rs.next())
                {
                    url = rs.getString("url");
                    servlet_name = rs.getString("servlet_name");
                    Class cls = Class.forName(servlet_name);
                    servlet = (Servlet) cls.newInstance();
                    result.put(url, servlet);
                }
            } else
            {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex);
        } catch (Exception ex) { // this catches all exceptions
            throw new DatabaseException(ex);
        }

        return result;
    }
}
