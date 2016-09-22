package server.exceptions;

/**
 * Created by ivan on 19/11/15.
 */
public final class UserNotFoundException extends Exception {

    public UserNotFoundException() {}

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(Throwable e) { super(e);}

    public UserNotFoundException(String msg, Throwable e) { super(msg, e); }

    @Override
    public String toString() {
        String result = "User not found exception: ";

        if(!super.getMessage().equals("")) {
            result += super.getMessage();
        }

        return result;
    }
}
