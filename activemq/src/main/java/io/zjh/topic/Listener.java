package io.zjh.topic;

import org.apache.activemq.ActiveMQConnection;

import javax.jms.*;
import java.util.UUID;

/**
 * @author onlyonezhongjinhui
 */
public class Listener {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String DESTINATION = "test.topic";

    private static void run() throws JMSException {
        String consumerId = "consumer-" + UUID.randomUUID();
        Connection connection = ActiveMQConnection.makeConnection();
        connection.setClientID(consumerId);
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(DESTINATION);
        MessageConsumer consumer = session.createDurableSubscriber(topic, consumerId);
        consumer.setMessageListener(System.out::println);
    }

    public static void main(String[] args) throws JMSException {
        run();
    }

}
