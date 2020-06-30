package csv;

/**
 * @author Hanz
 * @date 2020/6/30
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

