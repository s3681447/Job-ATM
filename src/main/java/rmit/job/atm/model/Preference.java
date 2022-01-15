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
@Table(name = "preferences")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preference_seq")
    private Long id;

    //// private Long employeeID;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference(value = "prefernce-employee")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //// private Long categoryID;
    @ManyToOne//(fetch = FetchType.LAZY)
    @JsonBackReference(value = "prefernce-category")
    @JoinColumn(name = "category_id")
    private Category category;
}
