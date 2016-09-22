package server.dbapi;

import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Program;

import java.util.HashMap;

/**
 * Created by ivan on 02/12/15.
 */
public abstract class DbProgramAdapter {

    public abstract Program createProgram(String _name) throws DatabaseException;

    // returns an updated Program
    public static Program setProgram(int _id, String _name, HashMap<Integer, Course> courses) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    public static int deleteProgram(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static Program getProgram(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // <id_Program, Program object itself>
    public static HashMap<Integer, Program> getPrograms() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}

// this PL/SQL procedure inserts data into program and returns program id
/*

create or replace procedure insert_program(
  p_prog_name IN program.prog_name%TYPE,
  v_prog_id OUT program.prog_id%TYPE) is
begin
  insert into program (prog_name) values(p_prog_name);
  SELECT Program_prog_id_SEQ.CURRVAL into v_prog_id FROM dual;
end;
/
commit;

-- test procedure
set serveroutput on
variable v_prog_id number
exec insert_program('Animation 4D',:v_prog_id);
print v_prog_id



*/