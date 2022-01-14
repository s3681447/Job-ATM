package rmit.job.atm.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "preferences")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preference_seq")
    private Long id;

    // TODO: add annotation
    private Long employeeID;

    // TODO: add annotation
    private Long categoryID;
}
