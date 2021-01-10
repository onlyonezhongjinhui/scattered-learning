package io.zjh.kafkaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author onlyonezhongjinhui
 */
@Component
public class KafkaProducer {

    private static final String TOPIC = "test-topic";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void produce() {
        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(TOPIC, "test message " + i);
        }
    }

}
