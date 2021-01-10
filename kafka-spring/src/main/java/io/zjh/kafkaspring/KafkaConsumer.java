package io.zjh.kafkaspring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author onlyonezhongjinhui
 */
@Component
public class KafkaConsumer {

    @KafkaListener(id = "consumer-id", topics = "test-topic")
    public void listen(String msg) {
        System.out.println("listen : " + msg);
    }

}
