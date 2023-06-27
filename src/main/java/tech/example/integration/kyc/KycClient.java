package tech.example.integration.kyc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import tech.example.dao.model.client.KycResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KycClient {
    private final KycApi kycApi;

    public KycResponse getKycValidationResult(String clientId) {
        log.info("Querying for KYC validation status clientId: {}", clientId);
        try {
            Response<KycResponse> response = kycApi.getValidationResult(clientId).execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                String errorMessage = response.errorBody().string();
                log.error("Error: {}", errorMessage);
                return null;
            }
        } catch (IOException e) {
            log.error("Failed to get KYC validation status, clientId: {}, error: {}", clientId, e.getMessage());
            return null;
        }
    }
}
