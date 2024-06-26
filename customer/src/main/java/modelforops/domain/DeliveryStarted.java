package modelforops.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import modelforops.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String userId;
    private String productId;
    private String productName;
    private Integer qty;
    private String status;
    private Date delieveryDt;
}
