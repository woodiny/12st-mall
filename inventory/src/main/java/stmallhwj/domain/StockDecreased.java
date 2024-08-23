package stmallhwj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallhwj.domain.*;
import stmallhwj.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private Photo productImg;
    private Integer stock;
    private Date registDt;
    private String status;

    public StockDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
