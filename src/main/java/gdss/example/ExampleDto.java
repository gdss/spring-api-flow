package gdss.example;

import gdss.AbstractEntityDto;

public class ExampleDto extends AbstractEntityDto {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
