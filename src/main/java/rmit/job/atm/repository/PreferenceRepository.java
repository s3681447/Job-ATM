package rmit.job.atm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import rmit.job.atm.model.Preference;

import java.util.List;

public interface PreferenceRepository extends PagingAndSortingRepository<Preference, Long> {

    // Sample endpoint: http:localhost:8080/preferences/search/byEmployeeId?q=2
//    @Query("select p from Preference p where p.employee.id = :q")
    @RestResource(path = "byEmployeeId")
    List<Preference> findByEmployeeId(@Param("q") Long eid);
}
