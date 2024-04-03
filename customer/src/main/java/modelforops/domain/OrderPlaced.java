package modelforops.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import modelforops.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private String productId;
    private String productName;
    private Integer qty;
    private Date orderDt;
    private String address;
    private String status;
}
