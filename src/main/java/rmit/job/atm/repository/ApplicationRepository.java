package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.Application;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Long> {
}
