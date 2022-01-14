package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.Preference;

public interface PreferenceRepository extends PagingAndSortingRepository<Preference, Long> {
}
