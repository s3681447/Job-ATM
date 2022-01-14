package rmit.job.atm.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "employee_seq")
	private Long id;

	@OneToOne //(fetch = FetchType.LAZY)
	private User user;

	@OneToMany(mappedBy = "employee")
	Set<Application> applications;

	@OneToMany(mappedBy = "employee")
	private Set<Preference> preferences;

	private String fullName;

	private String location;

//	private Double salary;
}
