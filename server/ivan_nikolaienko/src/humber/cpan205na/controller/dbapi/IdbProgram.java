package humber.cpan205na.controller.dbapi;

import humber.cpan205na.controller.serverapi.Program;

import java.util.HashMap;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbProgram {

    Program createProgram(int _id, String _name); //throws DBException;
    Program setProgram(int _id, String _name);
    boolean deleteProgram(int _id);

    static Program getProgram(int _id) {
        return new Program();
    }

    static HashMap<Integer, Program> getPrograms() { // <id_Program, Program object itself>
        return new HashMap<Integer, Program>();
    }
    
}
