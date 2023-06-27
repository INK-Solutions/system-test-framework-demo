package tech.example.infrastructure.events.incoming.mapper;

import house.inksoftware.avro.generated.loan.LoanApprovalDecision;
import tech.example.service.event.incoming.LoanApprovalResponse;

/*
This class is given as an example and should be replaced with real business logic
 */
public class LoanApprovalResponseMapper {
    public static LoanApprovalResponse map(LoanApprovalDecision event) {
        return LoanApprovalResponse.builder()
                .id(event.getId())
                .loanId(event.getLoanId())
                .approved(event.getApproved())
                .build();
    }
}
