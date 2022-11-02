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
        return content.getContent() == this.content;
    }
}
