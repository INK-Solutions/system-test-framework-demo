package tech.example.dao.model.loan;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.example.dao.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/*
This class is given as an example and should be replaced with real business logic
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "loan_request")
public class LoanRequest extends AbstractEntity {
    private BigDecimal amount;
    private String clientId;
    private Boolean approved;
    private String kycValidationResult;
}
