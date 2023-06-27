package tech.example.service.event.outgoing;

import lombok.Getter;
import tech.example.dao.model.loan.LoanRequest;

import java.math.BigDecimal;

/*
This class is given as an example and should be replaced with real business logic
 */
@Getter
public class LoanRequestCreatedEvent extends OutgoingEvent {
    private final String clientId;
    private final String loanId;
    private final BigDecimal amount;

    protected LoanRequestCreatedEvent(String clientId, String loanId, BigDecimal amount) {
        this.clientId = clientId;
        this.loanId = loanId;
        this.amount = amount;
    }

    public static LoanRequestCreatedEvent from(LoanRequest loanRequest) {
        return new LoanRequestCreatedEvent(loanRequest.getClientId(), loanRequest.getId(), loanRequest.getAmount());
    }
}
