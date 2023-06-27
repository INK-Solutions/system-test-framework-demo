package tech.example.service.exception;

public class EntityNotFoundException extends TechnicalErrorException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
