package tech.example.service.exception;

public class TechnicalErrorException extends GenericException {
    public TechnicalErrorException(String message) {
        super(message, "Something went wrong");
    }

    @Override
    public ExceptionErrorCode errorCode() {
        return ExceptionErrorCode.SOMETHING_WENT_WRONG;
    }
}
