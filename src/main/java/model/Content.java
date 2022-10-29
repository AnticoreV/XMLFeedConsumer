package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "content")
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_el;

    private String content;

    private String attribute;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "el_id")
    private Element element;
}
