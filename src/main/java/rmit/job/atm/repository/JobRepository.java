package rmit.job.atm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;
import rmit.job.atm.model.Job;

import java.util.List;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {

    // Sample Endpoint: http://localhost:8080/jobs/search/byTitle?q=joB
    @RestResource(path = "byTitle")
    List<Job> findByTitleContainingIgnoreCase(@Param("q") String keyword);


//    @Query(value = "SELECT j FROM Jobs j " +
//            "JOIN Jobs_Categories jc ON j.id = jc.job_id " +
//            "JOIN Categories c ON c.id = jc.category_id " +
//            "WHERE c.id = :cateId", nativeQuery = true) // TODO
//    List<Job> findByCategoryId(@PathVariable("cateId") Long categoryId);
}
