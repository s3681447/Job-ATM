package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
