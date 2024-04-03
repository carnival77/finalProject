package modelforops.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OutOfStock extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;
    private String orderId;

    public OutOfStock(Inventory aggregate) {
        super(aggregate);
    }

    public OutOfStock() {
        super();
    }
}
//>>> DDD / Domain Event
