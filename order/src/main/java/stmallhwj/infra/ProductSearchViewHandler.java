package stmallhwj.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallhwj.config.kafka.KafkaProcessor;
import stmallhwj.domain.*;

@Service
public class ProductSearchViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ProductSearchRepository productSearchRepository;
    //>>> DDD / CQRS
}
