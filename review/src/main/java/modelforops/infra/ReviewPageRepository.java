package modelforops.infra;

import java.util.List;
import modelforops.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "reviewPages",
    path = "reviewPages"
)
public interface ReviewPageRepository
    extends PagingAndSortingRepository<ReviewPage, Long> {}
