package modelforops.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

//<<< DDD / Domain Event
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

    public ReviewWritten(Review aggregate) {
        super(aggregate);
    }

    public ReviewWritten() {
        super();
    }
}
//>>> DDD / Domain Event
