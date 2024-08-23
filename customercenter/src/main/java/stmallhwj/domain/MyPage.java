package stmallhwj.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long orderId;
    private Long userId;
    private String productName;
    private Long productId;
    private String orderStatus;
    private String deliveryStatus;
    private String qty;
    private Date orderDt;
    private Date deliveryDt;
}
