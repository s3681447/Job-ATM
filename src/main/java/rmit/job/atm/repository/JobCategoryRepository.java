package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.JobCategory;

public interface JobCategoryRepository extends PagingAndSortingRepository<JobCategory, Long> {
}
