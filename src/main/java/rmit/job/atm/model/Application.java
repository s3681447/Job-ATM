package rmit.job.atm.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_seq")
    private Long id;

    // TODO: add annotation
    private Long jobID;

    // TODO: add annotation
    private Long categoryID;
}
