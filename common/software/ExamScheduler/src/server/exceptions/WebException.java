
package server.exceptions;

/**
 * Created by ivan on 19/11/15.
 */

public final class WebException extends Exception
{
    public WebException() {}

    public WebException(String msg) {
        super(msg);
    }

    public WebException(Throwable e) {super(e);}

    public WebException(String msg, Throwable e) { super(msg, e);}

    @Override
    public String toString() {
        String result = "Web Exception: ";

        if(!super.getMessage().equals("")) {
            result += super.getMessage();
        }

        return result;
    }
}
