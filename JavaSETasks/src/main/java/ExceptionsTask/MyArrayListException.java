package ExceptionsTask;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyArrayListException extends Exception {
    // TODO: реализовать стандартные конструкторы и т.д.
    // TODO: пока перегружен toString() [1. Осталось 3]
    private final int sizeBound = 10;

    public MyArrayListException() {
        super();
    }

    public MyArrayListException(String message) {
        super(message);
    }

    public MyArrayListException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArrayListException(Throwable cause) {
        super(cause);
    }

    public MyArrayListException(String message, int size) {
        super(message);
        //this.size = size;
    }

    public int getSizeBound() {
        return sizeBound;
    }

    /*public ArrayList<Integer> getBoundedArrayList() {
        return boundedArrayList;
    }

    public void setBoundedArrayList(ArrayList<Integer> boundedArrayList) {
        this.boundedArrayList = boundedArrayList;
    }*/

    @Override
    public String getMessage() {
        return "Size can't be more than"
                .concat(String.valueOf(sizeBound))
                .concat(super.getMessage());
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    /*@Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }*/

    @Override
    public String toString() {
        return "MyArrayListException{" +
                "sizeBound=" + sizeBound +
                '}';
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    /*@Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }*/

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }
}
