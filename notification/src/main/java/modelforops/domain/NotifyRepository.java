package modelforops.domain;

import modelforops.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "notifies", path = "notifies")
public interface NotifyRepository
    extends PagingAndSortingRepository<Notify, Long> {}
