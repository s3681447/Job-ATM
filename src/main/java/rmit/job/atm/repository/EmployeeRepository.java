package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import rmit.job.atm.model.Employee;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    // Sample Endpoint: http://localhost:8080/employees/search/byTel?q=84555555555
    @RestResource(path = "byTel")
    List<Employee> findByTelContainingIgnoreCase(@Param("q") String tel);
}
