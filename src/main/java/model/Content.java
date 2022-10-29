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


    public Content() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
