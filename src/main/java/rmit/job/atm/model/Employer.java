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
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employer_seq")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "employee-user")
    private User user;

    private String fullName;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Job> jobs;
}
