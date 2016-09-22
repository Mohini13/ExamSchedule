package server.unused;

import java.util.HashMap;

import server.AdminUser;
import server.exceptions.DatabaseException;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbProfessor {

    AdminUser createProfessor(String _name) throws DatabaseException;

    AdminUser setProfessor(int _id, String _name) throws DatabaseException;

    boolean deleteProfessor(int _id) throws DatabaseException;

    static AdminUser getProfessor(int _id) throws DatabaseException {
        return new AdminUser(0, "userName","userPassword");
    }

    // <id_Professor, Professor object itself>
    static HashMap<Integer, AdminUser> getProfessors() throws DatabaseException {
        return new HashMap<>();
    }
    
}
