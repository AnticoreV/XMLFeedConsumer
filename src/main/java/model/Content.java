package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "content")
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_el")
    private int id;

    private String content;

    private String attribute_name;

    private String attribute_value;

    public String getAttribute_name() {
        return attribute_name;
    }

    public void setAttribute_name(String attribute_name) {
        this.attribute_name = attribute_name;
    }

    public String getAttribute_value() {
        return attribute_value;
    }

    public void setAttribute_value(String attribute_value) {
        this.attribute_value = attribute_value;
    }

    public Content() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){return true;}
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Content content = (Content) obj;
        return content.getContent() == this.content
                || content.getAttribute_name() == this.attribute_name
                || content.getAttribute_value() == this.attribute_value;
    }
}
