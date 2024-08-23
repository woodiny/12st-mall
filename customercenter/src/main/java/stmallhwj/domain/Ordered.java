package stmallhwj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import stmallhwj.infra.AbstractEvent;

@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private Long productId;
    private Long qty;
    private Date orderDt;
    private String status;
}
