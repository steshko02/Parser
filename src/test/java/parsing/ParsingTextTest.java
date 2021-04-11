package parsing;

import entity.CompositeItem;
import entity.TextItem;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import text_elements.Elements;


public class ParsingTextTest {

    public static String testText;
    public static ParsingText parser = new ParsingText();
    public static CompositeItem text;
    public static final CompositeItem paragraph = new CompositeItem(Elements.PARAGRAPH);
    public static  CompositeItem sentence;

    @BeforeClass
    public static void init(){
        sentence = new CompositeItem(Elements.SENTENCE);

        sentence.getItems().add(new TextItem("This",Elements.WORD));
        sentence.getItems().add(new TextItem("is",Elements.WORD));
        sentence.getItems().add(new TextItem("text",Elements.WORD));
        sentence.getItems().add(new TextItem(".",Elements.PUNCTUATION));
    }

    @Test
    public void parseTextToListing() {
        testText = "Start listing\n" +
                "public String hello(){\n" +
                "return \"Hello Word\"\n" +
                "}\n" +
                "End listing";
        CompositeItem expected = parser.listingParse(testText);

        text = new CompositeItem(Elements.TEXT);
        text.getItems().add(new TextItem(testText, Elements.CODE));

        Assert.assertEquals(expected,text);
    }
    @Test
    public void parseTextToParagraphs() {
        testText = "\tThis is text.";
        CompositeItem expected = parser.listingParse(testText);

        text = new CompositeItem(Elements.TEXT);
        paragraph.getItems().add(sentence);
        text.getItems().add(paragraph);

        Assert.assertEquals(expected,text);
    }
    @Test
    public void parseTextToSentences() {
        testText = "This is text.";
        CompositeItem expected = parser.parseToSentences(testText);

        paragraph.getItems().add(sentence);

        Assert.assertEquals(expected,paragraph);
    }
    @Test
    public void parseTextToWord() {
        testText = "This is text.";
        CompositeItem expected = parser.parseToSentences(testText);
        Assert.assertEquals(expected,sentence);
    }
}