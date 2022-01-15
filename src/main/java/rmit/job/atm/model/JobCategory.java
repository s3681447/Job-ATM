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
@Table(name = "jobs_categories")
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_category_seq")
    private Long id;

    //// private Long jobID;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference(value = "JobCategory-job")
    @JoinColumn(name = "job_id")
    private Job job;

    //// private Long categoryID;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference(value = "JobCategory-category")
    @JoinColumn(name = "category_id")
    private Category category;
}
