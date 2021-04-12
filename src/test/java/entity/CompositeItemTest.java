package entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import text_elements.Elements;

import java.util.ArrayList;
import java.util.List;


public class CompositeItemTest {


    private static  CompositeItem item ;


    @Test(expected = NullPointerException.class)
    public void testGetItemsByTypeNullPointerException() {
        CompositeItem.getItemsByType(null, null);
    }


    @Test
    public void testGetChild() {
        item = new CompositeItem(Elements.SENTENCE);
        Item expected = new TextItem("HELLO", Elements.WORD);
        item.getItems().add(expected);
        Assert.assertEquals(item.getChild(0), expected);
    }

    @Test
    public void testGetItemsByTypeWithTextItems() {
        item = new CompositeItem(Elements.SENTENCE);
        Item expected1 = new TextItem("HELLO", Elements.WORD);
        Item expected2 = new TextItem("HELLO", Elements.WORD);
        Item expected3 = new TextItem("HELLO", Elements.WORD);

        item.getItems().add(expected1);
        item.getItems().add(expected2);
        item.getItems().add(expected3);

        List<Item> actual = new ArrayList<>();

        actual.add(expected1);
        actual.add(expected2);
        actual.add(expected3);

        Assert.assertEquals(actual,CompositeItem.getItemsByType(Elements.WORD,item));
    }

    @Test
    public void testGetItemsByTypeWithCompositeItems() {
        item = new CompositeItem(Elements.SENTENCE);
        Item expected1 = new CompositeItem(Elements.SENTENCE);
        Item expected2 = new CompositeItem(Elements.SENTENCE);

        item.getItems().add(expected1);
        item.getItems().add(expected2);

        List<Item> actual = new ArrayList<>();

        actual.add(expected1);
        actual.add(expected2);

        Assert.assertEquals(actual,CompositeItem.getItemsByType(Elements.SENTENCE,item));
    }

}