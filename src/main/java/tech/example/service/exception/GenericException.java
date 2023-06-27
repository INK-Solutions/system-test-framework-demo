package tech.example.service.exception;

public abstract class GenericException extends RuntimeException {
    private final String customerFriendlyMessage;
    public GenericException(String message, String customerFriendlyMessage) {
        super(message);
        this.customerFriendlyMessage = customerFriendlyMessage;
    }

    public abstract ExceptionErrorCode errorCode();

    public String getCustomerFriendlyMessage() {
        return customerFriendlyMessage;
    }
}
