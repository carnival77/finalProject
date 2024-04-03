package modelforops.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import modelforops.config.kafka.KafkaProcessor;
import modelforops.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    //>>> DDD / CQRS
}
