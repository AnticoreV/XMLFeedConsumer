package sapronov.model;

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

    public Element() {
    }

    public String getFirst_el() {
        return first_el;
    }

    public void setFirst_el(String first_el) {
        this.first_el = first_el;
    }

    public String getSecond_el() {
        return second_el;
    }

    public void setSecond_el(String second_el) {
        this.second_el = second_el;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){return true;}
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return element.getFirst_el() == this.first_el
                || element.getSecond_el() == this.second_el;
    }
}
