package modelforops.infra;

import java.util.List;
import modelforops.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "orderHistories",
    path = "orderHistories"
)
public interface OrderHistoryRepository
    extends PagingAndSortingRepository<OrderHistory, Long> {}
