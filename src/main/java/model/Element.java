package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "element")
public class Element implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String first_el;

    private String second_el;

    @OneToOne(mappedBy = "element",cascade = CascadeType.ALL, orphanRemoval = true)
    private Content content;
}
