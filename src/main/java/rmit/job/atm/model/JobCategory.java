package rmit.job.atm.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "jobs_categories")
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_category_seq")
    private Long id;

    //// private Long jobID;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    //// private Long categoryID;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
