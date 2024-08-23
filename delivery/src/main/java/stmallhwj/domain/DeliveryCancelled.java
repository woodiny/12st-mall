package stmallhwj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallhwj.domain.*;
import stmallhwj.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long userId;
    private String productName;
    private String qty;
    private Date deliveryDt;
    private String status;

    public DeliveryCancelled(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
