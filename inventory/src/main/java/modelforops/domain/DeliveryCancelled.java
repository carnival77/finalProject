package modelforops.domain;

import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String userId;
    private String productId;
    private String productName;
    private Integer qty;
    private String status;
    private Date delieveryDt;
}
