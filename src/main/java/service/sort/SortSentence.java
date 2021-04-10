package service.sort;

import entity.CompositeItem;
import entity.Item;
import lombok.extern.slf4j.Slf4j;
import text_elements.Elements;

import java.util.Comparator;
import java.util.List;

@Slf4j
public class SortSentence {

    //        @Override
//        public int compare(CompositeItem o1, CompositeItem o2) {
//            return o1.getItems().size() - o2.getItems().size();
//        }
    public static void sortPartsByNumberOfItems(CompositeItem composite) {
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
                return 0;
            }
        });
    }
}

