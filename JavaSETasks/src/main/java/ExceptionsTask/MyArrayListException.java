package ExceptionsTask;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The MyArrayListException wraps standard Java exception to control size of array.
 * If size of an array more than {@link MyArrayListException#sizeBound}.
 * @author Verstov Danila
 * @version 1.0
 */
public class MyArrayListException extends Exception {
    private static final long serialVersionUID = 7918828512120319558L;
    ResourceBundle labels = ResourceBundle.getBundle("text", Locale.FRANCE);
    /** Field that represents maximum number of elements in the array **/
    private final int sizeBound = 10;
    private String exceptionMessage;

    public MyArrayListException() {
        super();
    }

    public MyArrayListException(String message) {
        super(message);
        this.exceptionMessage = message;
    }

    public MyArrayListException(String message, Throwable cause) {
        super(message, cause);
        this.exceptionMessage = message;
    }

    public MyArrayListException(Throwable cause) {
        super(cause);
    }

    public int getSizeBound() {
        return sizeBound;
    }

    @Override
    public String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage(); // getMessage()
        if (message == null) {
            message = this.exceptionMessage;
        }
        return (message != null) ? (s + ": " + message) : s;
    }


    @Override
    public String getMessage() {
        if (this.exceptionMessage == null) {
            return "Can't be more than "
                    + sizeBound
                    + " "
                    + "elements in the array!"
                    + super.getMessage();
        } else {
            return this.exceptionMessage;
        }
        /*return this.exceptionMessage
                .concat("! ")
                .concat(super.getMessage());*/
    }

    @Override
    public String getLocalizedMessage() {
        return labels.getString("tooBigSize");
    }

    @Override
    public synchronized Throwable getCause() {
        //return (cause==this ? null : cause);
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public void printStackTrace() {
        System.err.println(new Date().toString());
        super.printStackTrace();
    }
}
