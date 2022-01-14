package rmit.job.atm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private Long id;

    private String name;

//    private Long parentId;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subcategories = new HashSet<>();
}
