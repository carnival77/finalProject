package modelforops.domain;

import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

@Data
@ToString
public class OutOfStock extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;
    private Long orderId;
}
