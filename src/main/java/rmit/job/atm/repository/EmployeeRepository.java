package rmit.job.atm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rmit.job.atm.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
