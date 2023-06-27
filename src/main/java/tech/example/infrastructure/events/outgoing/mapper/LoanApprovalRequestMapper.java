package tech.example.infrastructure.events.outgoing.mapper;

import house.inksoftware.avro.generated.loan.LoanApprovalRequest;
import tech.example.service.event.outgoing.LoanRequestCreatedEvent;

/*
This class is given as an example and should be replaced with real business logic
 */
public class LoanApprovalRequestMapper {
    public static LoanApprovalRequest map(LoanRequestCreatedEvent event) {
        return LoanApprovalRequest.newBuilder()
                                  .setEventId(event.getId())
                                  .setLoanId(event.getLoanId())
                                  .setClientId(event.getClientId())
                                  .setAmount(event.getAmount().doubleValue())
                                  .build();
    }
}
