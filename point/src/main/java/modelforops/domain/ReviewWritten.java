package modelforops.domain;

import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

@Data
@ToString
public class ReviewWritten extends AbstractEvent {

    private Long id;
    private String userId;
    private String productId;
    private String productName;
    private String comment;
    private Date orderDt;
    private Date deliveryDt;
    private String address;
}
