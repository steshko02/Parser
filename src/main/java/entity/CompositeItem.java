package entity;

import lombok.Data;
import text_elements.Elements;

import java.util.LinkedList;
import java.util.List;

@Data
public class CompositeItem implements Item {
    private List<Item> items = new LinkedList<>();
    private Elements type;

    public CompositeItem(Elements type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        for (Item str : items){
            if(this.type == Elements.PARAGRAPH){
                 res.append("\n\t").append(str.toString()).append("\n");
            }
            else if(this.type == Elements.SENTENCE){
                res.append(str.toString());
            }
            else if(this.type == Elements.WORD) {
                res.append(str.toString());
            }
            else  {
                res.append(str.toString());
            }
        }
        return res+"";
    }

    @Override
    public Item getChild(int i) {
        return items.get(i);
    }

    public  List<Item> getItemsWithType(Elements type,CompositeItem compositeItem){
        List<Item> result = new LinkedList<>();

                for (Item item : compositeItem.getItems()) {

                    if (item instanceof TextItem) {
                        if (item.getType().equals(type)) {
                            result.add(item);
                        }
                    }
                    if (item instanceof CompositeItem) {
                        for (Item item1 : ((CompositeItem) item).getItems()) {

                            if (item.getType().equals(type)) {
                                result.add(item1);
                            } else {
                                result.addAll(getItemsWithType(type, (CompositeItem) item1));
                            }
                        }
                    }
                }
        return result;
    }
}


