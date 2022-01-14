package rmit.job.atm.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employer_seq")
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "employer")
    private Set<Job> jobs;
}
