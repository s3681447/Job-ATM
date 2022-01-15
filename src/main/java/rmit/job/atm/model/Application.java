package rmit.job.atm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_seq")
    private Long id;

    //// private Long employID;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference(value = "applications-employee")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //// private Long jobID;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference(value = "applications-job")
    @JoinColumn(name = "job_id")
    private Job job;

}
