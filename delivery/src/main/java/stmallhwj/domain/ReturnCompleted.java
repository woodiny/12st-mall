package stmallhwj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallhwj.domain.*;
import stmallhwj.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReturnCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long userId;
    private String productName;
    private String qty;
    private Date deliveryDt;
    private String status;

    public ReturnCompleted(Delivery aggregate) {
        super(aggregate);
    }

    public ReturnCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
