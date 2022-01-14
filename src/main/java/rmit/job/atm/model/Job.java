package rmit.job.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "job_seq")
    private Long id;

    //// private String employerID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "job")
    private Set<JobCategory> jobCategories;

    @OneToMany(mappedBy = "job")
    private Set<Application> applications;

    private String title;

    private Double salaryRangeMin;

    private Double salaryRangeMax;

    private String postalCode;

    private String location;

}
