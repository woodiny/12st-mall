package stmallhwj.domain;

import java.util.*;
import lombok.*;
import stmallhwj.domain.*;
import stmallhwj.infra.AbstractEvent;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private String productName;
    private Object productImg;
    private Integer stock;
    private Date registDt;
    private String status;
}
