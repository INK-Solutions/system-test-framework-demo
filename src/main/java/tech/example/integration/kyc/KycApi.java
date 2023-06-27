package tech.example.integration.kyc;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tech.example.dao.model.client.KycResponse;

interface KycApi {
    @GET("api/kyc/validation")
    Call<KycResponse> getValidationResult(@Query("clientId") String clientId);
}
