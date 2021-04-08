package entity;

import lombok.Data;
import text_elements.Elements;

import java.util.List;

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
}
