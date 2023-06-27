package tech.example.integration.kyc;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;

@Configuration
public class KycApiConfiguration {
    @Value("${api.gateway.client.details.request.base.url}")
    private String clientDetailsApiBaseUrl;

    @Value("${api.gateway.client.details.request.api.key}")
    private String apiKey;

    @Bean
    public KycApi kycApi() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.connectTimeout(Duration.ofSeconds(10));
        okHttpBuilder.addInterceptor(chain -> {
            final Request request =
                    chain.request().newBuilder().addHeader("api-key", apiKey)
                            .build();
            return chain.proceed(request);
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl(clientDetailsApiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();
        return retrofit.create(KycApi.class);
    }
}
