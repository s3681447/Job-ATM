package rmit.job.atm.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_seq")
    private Long id;

    @Column(unique = true)
    private String tel;

    private String pin;

    private String role;

    private boolean firstLogin;
}
