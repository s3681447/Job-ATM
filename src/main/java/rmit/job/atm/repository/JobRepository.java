package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.Job;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
}
