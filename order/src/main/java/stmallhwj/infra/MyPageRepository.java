package stmallhwj.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmallhwj.domain.*;

@RepositoryRestResource(collectionResourceRel = "myPages", path = "myPages")
public interface MyPageRepository
    extends PagingAndSortingRepository<MyPage, Long> {}
