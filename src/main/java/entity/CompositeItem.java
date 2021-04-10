package entity;

import lombok.Data;
import text_elements.Elements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
public class CompositeItem implements Item {
    private List<Item> items = new ArrayList<>();
    private Elements type;

    public CompositeItem(Elements type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        for (Item str : items){
           // res.append("\t\n");
            if(this.type == Elements.TEXT){
                res.append("\t").append(str.toString()).append("\n");
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


    //делать проверки (МОЖНО В СЕРВИС ЗАСУНУТЬ)
    public static List<Item> getItemsByType(Elements type,CompositeItem compositeItem){
        List<Item> result = new LinkedList<>();
                for (Item item : compositeItem.getItems()) {

                    if (item instanceof TextItem) {
                        if (item.getType().equals(type)) {
                            result.add(item);
                        }
                    }
                    if (item instanceof CompositeItem) {
                        if (item.getType().equals(type)) {
                            result.add(item);
                        } else {
                            result.addAll(getItemsByType(type, (CompositeItem) item));
                        }
                    }
                }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeItem that = (CompositeItem) o;
        return Objects.equals(items, that.items) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, type);
    }

}


