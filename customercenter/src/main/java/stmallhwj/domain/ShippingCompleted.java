package stmallhwj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import stmallhwj.infra.AbstractEvent;

@Data
public class ShippingCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long userId;
    private String productName;
    private String qty;
    private Date deliveryDt;
    private String status;
}
