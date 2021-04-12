package service.logic;

import entity.CompositeItem;
import entity.Item;
import entity.TextItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import text_elements.Elements;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    private static  CompositeItem item;

    private final Service service = new Service();

    @Before
    public void setUp() throws  Exception{
        item = new CompositeItem(Elements.PARAGRAPH);
    }

    @Test(expected = NullPointerException.class)
    public void testGetSentenceByWordNullPointerException() {
        service.getSentenceByWordCount(null);
    }

    @Test
    public void testGetSentenceByWordCount() {
        List<Item> testList = new ArrayList<>();
        testList.add(new TextItem("213", Elements.WORD));
        testList.add(new TextItem("21213", Elements.WORD));
        testList.add(new TextItem("2112413", Elements.WORD));
        testList.add(new TextItem(".", Elements.PUNCTUATION));


        List<Item> testList1 = new ArrayList<>();
        testList1.add(new TextItem("21213", Elements.WORD));
        testList1.add(new TextItem("2112413", Elements.WORD));
        testList1.add(new TextItem(".", Elements.PUNCTUATION));

        List<Item> testList2 = new ArrayList<>();
        testList2.add(new TextItem("2112413", Elements.WORD));
        testList2.add(new TextItem(".", Elements.PUNCTUATION));


        CompositeItem s1 = new CompositeItem(Elements.SENTENCE);
        CompositeItem s2 = new CompositeItem(Elements.SENTENCE);
        CompositeItem s3 = new CompositeItem(Elements.SENTENCE);
        s1.setItems(testList);
        s2.setItems(testList1);
        s3.setItems(testList2);

        CompositeItem actual = new CompositeItem(Elements.PARAGRAPH);
        actual.getItems().add(s3);
        actual.getItems().add(s2);
        actual.getItems().add(s1);

        item.getItems().add(s1);
        item.getItems().add(s2);
        item.getItems().add(s3);

        Assert.assertEquals(service.getSentenceByWordCount(item), actual);

    }


    @Test
    public void testDeleteWord() {

        List<Item> testList = new ArrayList<>();
        testList.add(new TextItem("213", Elements.WORD));
        testList.add(new TextItem("21213", Elements.WORD));
        testList.add(new TextItem("2112413", Elements.WORD));

        CompositeItem expected = new CompositeItem(Elements.PARAGRAPH);
        expected.setItems(testList);

        service.deleteWord("213", expected);

        List<Item> newTestList = new ArrayList<>();
        newTestList.add(new TextItem("21213", Elements.WORD));
        newTestList.add(new TextItem("2112413", Elements.WORD));

        item.setItems(newTestList);

        Assert.assertEquals(expected, item);

    }
}