package gdss.example;

import gdss.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class Example extends AbstractEntity {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
