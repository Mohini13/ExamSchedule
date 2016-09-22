package humber.cpan205na.controller.dbapi;

import humber.cpan205na.controller.serverapi.Professor;

import java.util.HashMap;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbProfessor {

    Professor createProfessor(int _id, String _name); //throws DBException;
    Professor setProfessor(int _id, String _name);
    boolean deleteProfessor(int _id);

    static Professor getProfessor(int _id) {
        return new Professor();
    }

    static HashMap<Integer, Professor> getProfessors() { // <id_Professor, Professor object itself>
        return new HashMap<Integer, Professor>();
    }
    
}
