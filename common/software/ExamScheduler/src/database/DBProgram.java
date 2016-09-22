/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import oracle.jdbc.OracleTypes;
import server.dbapi.DbProgramAdapter;
import server.dbapi.Idb;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Program;

/**
 *
 * @author hani
 * Tested by hani Dec 5
 */

public class DBProgram extends DbProgramAdapter
{

    PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    //Tested by hani Dec 7
    @Override
    public Program createProgram(String _name) throws DatabaseException {
        Program pro = null;
        int program_id;

        // insert_program
        // ? is a name of course, :v_prog_id is an OUT parameter
        String sql = "{call insert_program(:v_prog_id, ?)}";

        try {
            CallableStatement cs = DBConnection.con.prepareCall(sql);
            cs.setString(2, _name);//always
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();

            program_id = cs.getInt(1); // 1 is the first OUT parameter
            pro = new Program(program_id, _name);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return pro;
    }

    // it works BUT Database Exception: java.sql.SQLException: Unsupported feature
    /*@Override
    public Program createProgram(String _name) throws DatabaseException {
        Program pro = null;
        int program_id = 0;
        String err_msg = "Creating Program failed.";

        //
        String sql = "INSERT INTO program (prog_name) VALUES ( ? )";

        try {
            // hibernate.jdbc.use_get_generated_keys
            pstmt = DBConnection.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //pstmt = DBConnection.con.prepareStatement(sql);
            pstmt.setString(1, _name);
            int affectedRows = pstmt.executeUpdate();

            if(affectedRows == 0) {
                throw new DatabaseException(err_msg);
            }

            ResultSet insertedId = pstmt.getGeneratedKeys();
            if(insertedId.next()) {
                program_id = (int)insertedId.getLong("prog_id"); // getLong(1)
                pro = new Program(_name);
                pro.setProgramId(program_id);
            } else throw new DatabaseException(err_msg + " No inserted id found.");

        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return pro;
    }*/

    // it is ok but we need inserted_id
    /*@Override
    public Program createProgram(String _name) throws DatabaseException {
       Program pro = null;
        String sql = "INSERT INTO program (prog_name) "
                + "VALUES('" + _name + "')";
        try {
            DBConnection.getStatement().executeUpdate(sql);
            pro = new Program(_name);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return pro;
    }*/

    public static Program setProgram(int _id, String _name, HashMap<Integer, Course> courses) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
    //Tested by hani Dec 5
     public static int deleteProgram(int _id) throws DatabaseException {
         int rowsDeleted = 0;
        String sql = "DELETE FROM program WHERE prog_id = " + _id;
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
//Tested by hani Dec 5  TEST AGAIN
    public static Program getProgram(int _id) throws DatabaseException {
       Program pro = null;
        String sql = "SELECT * FROM program WHERE prog_id = " + _id;
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                rs.next();
                pro = new Program(rs.getInt("prog_id"), rs.getString("prog_name"));
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
            //DBConnection.getStatement().close(); // ?
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return pro;
    }
//Tested by hani Dec 5
    // <id_Program, Program object itself>
    public static HashMap<Integer, Program> getPrograms() throws DatabaseException {
      HashMap<Integer, Program> result = new HashMap<>();
        int id = 0;
        Program pro= null;
        String sql = "SELECT * FROM program";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("prog_id");
                    pro= new Program(rs.getInt("prog_id"), rs.getString("prog_name"));
                    result.put(id, pro);
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
  