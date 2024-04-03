package modelforops.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import modelforops.config.kafka.KafkaProcessor;
import modelforops.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotifyRepository notifyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockIncreased'"
    )
    public void wheneverStockIncreased_NotifyToUser(
        @Payload StockIncreased stockIncreased
    ) {
        StockIncreased event = stockIncreased;
        System.out.println(
            "\n\n##### listener NotifyToUser : " + stockIncreased + "\n\n"
        );

        // Sample Logic //
        Notify.notifyToUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_NotifyToUser(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener NotifyToUser : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Notify.notifyToUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCancelled'"
    )
    public void wheneverDeliveryCancelled_NotifyToUser(
        @Payload DeliveryCancelled deliveryCancelled
    ) {
        DeliveryCancelled event = deliveryCancelled;
        System.out.println(
            "\n\n##### listener NotifyToUser : " + deliveryCancelled + "\n\n"
        );

        // Sample Logic //
        Notify.notifyToUser(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
