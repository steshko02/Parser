package entity;

import lombok.Data;
import text_elements.Elements;

import java.util.Objects;

@Data
public class TextItem implements Item {

    private String context;
    private Elements type;

    public TextItem(String context,Elements type) {
        this.context = context;
        this.type =type;
    }

    @Override
    public String toString() {
        if(this.type == Elements.WORD){
            return " "+context;
        }
        else if(this.type == Elements.CODE){
            return context+"\n";
        }
        else
            return context;
    }

    @Override
    public Item getChild(int i) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextItem textItem = (TextItem) o;
        return Objects.equals(context, textItem.context) && type == textItem.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, type);
    }
}
