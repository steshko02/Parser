package service.sort;

import entity.CompositeItem;
import entity.Item;
import entity.TextItem;
import lombok.extern.slf4j.Slf4j;
import text_elements.Elements;

import java.util.Comparator;
import java.util.List;

@Slf4j
public class SortSentence {

    public static void sortPartsByNumberOfItems(CompositeItem composite) {

        if(composite.getItems() == null){
            log.error("Null object");
            throw  new NullPointerException("Null Object");
        }
        List<Item> items = composite.getItems();
        items.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof CompositeItem && o2 instanceof CompositeItem) {
                    CompositeItem c1 = (CompositeItem) o1;
                    CompositeItem c2 = (CompositeItem) o2;
                    Integer i1 = c1.getItems().size();
                    Integer i2 = c2.getItems().size();
                    return i1.compareTo(i2);
                }
                else {
                    log.error("Is not CompositeItem list.");
                    throw new ClassCastException("");
                }
            }
        });
    }
}

