package io.zjh.kafkaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author onlyonezhongjinhui
 */
@SpringBootApplication
public class KafkaSpringApplication implements ApplicationRunner {

    @Autowired
    private KafkaProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        producer.produce();
    }

}
