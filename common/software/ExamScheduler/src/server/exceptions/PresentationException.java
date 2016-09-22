
package server.exceptions;

/**
 *
 * @author Jordan
 *
 * updated Nov 25, 2015 by Ivan
 */
public final class PresentationException extends Exception
{
    public PresentationException() {}

    public PresentationException(String msg) {
        super(msg);
    }

    public PresentationException(Throwable e) {super(e);}

    public PresentationException(String msg, Throwable e) {super(msg, e);}

    public String toString() {
        String result = "Presentation Exception: ";

        if(!super.getMessage().equals("")) {
            result += super.getMessage();
        }

        return result;
    }
}
