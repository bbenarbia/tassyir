package net.bbenarbia.exception;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * create BusinessException.
     * @param message
     *            the message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * create BusinessException.
     * @param throwable
     *            the throwable
     */
    public BusinessException(Throwable throwable) {
        super(throwable);
    }
}

