package server.exceptions;

/**
 * Created by ivan on 25/11/15.
 */
public final class ServerException extends Exception {
    
    public ServerException() {}

    public ServerException(String msg) {
        super(msg);
    }

    public ServerException(Throwable e) {
        super(e);
    }

    public ServerException(String msg, Throwable e) {
        super(msg,e);
    }


    public String toString() {
        String result = "Server Exception: ";

        if(!super.getMessage().equals("")) {
            result += super.getMessage();
        }

        return result;
    }
    
}
