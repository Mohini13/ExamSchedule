package server.exceptions;

/**
 * Created by ivan on 19/11/15.
 */
public final class DatabaseException extends Exception {

    public DatabaseException() {}

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(Throwable e) {
        super(e);
    }

    public DatabaseException(String msg, Throwable e) {
        super(msg,e);
    }


    public String toString() {
        String result = "Database Exception: ";

        if(!super.getMessage().equals("")) {
            result += super.getMessage();
        }

        return result;
    }
}
