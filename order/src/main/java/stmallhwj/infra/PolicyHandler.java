package stmallhwj.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallhwj.config.kafka.KafkaProcessor;
import stmallhwj.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockIncreased'"
    )
    public void wheneverStockIncreased_NotifyToWaitingUsers(
        @Payload StockIncreased stockIncreased
    ) {
        StockIncreased event = stockIncreased;
        System.out.println(
            "\n\n##### listener NotifyToWaitingUsers : " +
            stockIncreased +
            "\n\n"
        );

        // Sample Logic //
        Order.notifyToWaitingUsers(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReturnCompleted'"
    )
    public void wheneverReturnCompleted_UpdateStatus(
        @Payload ReturnCompleted returnCompleted
    ) {
        ReturnCompleted event = returnCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + returnCompleted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCompleted'"
    )
    public void wheneverShippingCompleted_UpdateStatus(
        @Payload ShippingCompleted shippingCompleted
    ) {
        ShippingCompleted event = shippingCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + shippingCompleted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
