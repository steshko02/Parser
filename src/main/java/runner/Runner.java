package runner;

import entity.CompositeItem;
import entity.Item;
import entity.Text;
import parsing.ParsingText;
import text_elements.Elements;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Text text1 = new Text();

        text1.initialization("C:\\Users\\stesh\\OneDrive\\Рабочий стол\\123131.txt");

        ParsingText parsingText = new ParsingText();

        CompositeItem ci = parsingText.listingParse(text1.getText()); // параграфы
       System.out.println(ci);

        CompositeItem nn = new CompositeItem(Elements.PUNCTUATION);
        List<Item> ss = nn.getItemsWithType(Elements.PARAGRAPH,ci);
        ss.remove(1);
        System.out.println(ss);
        List<Item> s1s = nn.getItemsWithType(Elements.WORD,((CompositeItem) ci.getChild(0)));
        //System.out.println(ci.getChild(0).getChild(0).toString());
        s1s.remove(0);
        ci.setItems(ss);

        if(ci.getChild(0).getChild(0) instanceof CompositeItem) {
            ((CompositeItem) ci.getChild(0).getChild(0)).setItems(s1s);
        }
        System.out.println(ci);
//создать методы, из которых можно получить по типу значения через foreach
    }
}
