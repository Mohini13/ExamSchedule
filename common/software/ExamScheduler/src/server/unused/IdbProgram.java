package server.unused;

import java.util.HashMap;
import server.exceptions.DatabaseException;
import server.serverapi.Program;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbProgram {

    Program createProgram(String _name) throws DatabaseException;

    Program setProgram(int _id, String _name) throws DatabaseException;

    boolean deleteProgram(int _id) throws DatabaseException;

    static Program getProgram(int _id) throws DatabaseException {
//        return new Program();
        throw new IllegalStateException("implement this first!");
    }

    // <id_Program, Program object itself>
    static HashMap<Integer, Program> getPrograms() throws DatabaseException {
        return new HashMap<>();
    }
    
}
