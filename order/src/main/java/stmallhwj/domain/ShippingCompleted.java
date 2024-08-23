package stmallhwj.domain;

import java.util.*;
import lombok.*;
import stmallhwj.domain.*;
import stmallhwj.infra.AbstractEvent;

@Data
@ToString
public class ShippingCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long userId;
    private String productName;
    private String qty;
    private Date deliveryDt;
    private String status;
}
