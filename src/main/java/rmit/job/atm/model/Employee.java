package rmit.job.atm.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "employee_seq")
	private Long id;

	private String fullName;

	private String location;

	private Double salary;
}
