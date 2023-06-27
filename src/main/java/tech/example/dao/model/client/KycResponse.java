package tech.example.dao.model.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KycResponse {
    private String clientId;
    private String validationResult;
}
