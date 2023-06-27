package tech.example.service.loan;

import tech.example.service.exception.ExceptionErrorCode;
import tech.example.service.exception.GenericException;

/*
This class is given as an example and should be replaced with real business logic
 */
public class LoanAlreadyGivenException extends GenericException {
    public LoanAlreadyGivenException(String message) {
        super(message, "Loan already given");
    }


    @Override
    public ExceptionErrorCode errorCode() {
        return ExceptionErrorCode.LOAN_ALREADY_GIVEN_EXCEPTION;
    }
}
