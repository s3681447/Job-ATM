package rmit.job.atm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "employee_seq")
	private Long id;

	@OneToOne //(fetch = FetchType.LAZY)
//	@JsonBackReference(value = "employees-user")
	private User user;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Application> applications;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Preference> preferences;

	private String fullName;

	private Integer age;

	private String location;

	private String expLevel;

	@Column(unique = true)
	private String tel;
}
