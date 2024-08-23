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
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setOrderId(ordered.getId());
            myPage.setUserId(Long.valueOf(ordered.getUserId()));
            myPage.setProductName(ordered.getProductName());
            myPage.setProductId(ordered.getProductId());
            myPage.setOrderStatus(ordered.getStatus());
            myPage.setQty(String.valueOf(ordered.getQty()));
            myPage.setOrderDt(ordered.getOrderDt());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenShippingCompleted_then_UPDATE_1(
        @Payload ShippingCompleted shippingCompleted
    ) {
        try {
            if (!shippingCompleted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderId(
                shippingCompleted.getOrderId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setDeliveryStatus(shippingCompleted.getStatus());
                myPage.setDeliveryDt(shippingCompleted.getDeliveryDt());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturnCompleted_then_UPDATE_2(
        @Payload ReturnCompleted returnCompleted
    ) {
        try {
            if (!returnCompleted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderId(
                returnCompleted.getOrderId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setDeliveryStatus(returnCompleted.getStatus());
                myPage.setDeliveryDt(returnCompleted.getDeliveryDt());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
