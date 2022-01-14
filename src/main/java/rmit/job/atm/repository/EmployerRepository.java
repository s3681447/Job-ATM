package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.Employer;

public interface EmployerRepository extends PagingAndSortingRepository<Employer, Long> {
}
