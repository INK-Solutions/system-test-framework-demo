package tech.example.systemtest;

import house.inksoftware.systemtest.SystemTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Primary;
import tech.example.infrastructure.events.incoming.KafkaEventProcessedCallback;

@SpringBootTest(classes = {DefaultSystemTest.SystemTestKafkaEventProcessedCallback.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DefaultSystemTest extends SystemTest {
    @TestConfiguration
    @Primary
    public static class SystemTestKafkaEventProcessedCallback extends house.inksoftware.systemtest.domain.config.infra.kafka.incoming.KafkaEventProcessedCallback implements KafkaEventProcessedCallback {
    }
}
