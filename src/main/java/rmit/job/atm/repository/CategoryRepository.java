package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
