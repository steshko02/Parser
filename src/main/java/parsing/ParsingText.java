package parsing;

import entity.CompositeItem;
import entity.Item;
import entity.Text;
import entity.TextItem;
import text_elements.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingText {

    public static final String REGEX_LISTING_OR_PARAGRAPHS  =
            "(Start listing(\\s*.\\s*)+?\\n?End listing)|.*[A-Za-zА-Яа-я]+\\s*.*";

    public static final String REGEX_LISTING = "(Start listing(\\s*.\\s*)+?\\n?End listing)";

    public static final String REGEX_SENTENCE =
            "[^.!?]+(\\.+|\\?|!|:\\n?)";
    public static final String REGEX_WORD_OR_PUNCTUATION=
            "[A-Za-zА-Яа-я0-9]+|\\.+|\\?|!|,|(\\s?-\\s?)|\"|(:\\s?)|;";
    public static final String REGEX_PUNCTUATION=
            "\\.+|\\?|!|,|(\\s?-\\s?)|\"|(:\\s?)|;";


    public CompositeItem listingParse(String text){
        CompositeItem textItems = new CompositeItem(Elements.PARAGRAPH);
        Pattern pattern =  Pattern.compile(REGEX_LISTING_OR_PARAGRAPHS);
        Matcher matcher = pattern.matcher(text);
        String pr="";
        while (matcher.find()){
            pr=matcher.group();
            if(Pattern.matches(REGEX_LISTING,pr)){
                TextItem code = new TextItem(pr,Elements.CODE);
                textItems.getItems().add(code);
            }
            else {
                CompositeItem compositeItem = new CompositeItem(Elements.PARAGRAPH);
                compositeItem.getItems().add(parseToSentences(pr));
                textItems.getItems().add(compositeItem);
            }
        }
        return  textItems;
    }

    public Item parseToSentences(String text) {
        CompositeItem paragraphsItems = new CompositeItem(Elements.SENTENCE);
        Pattern pattern =  Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(text);
        String snt= "";
        while (matcher.find()){
            snt=matcher.group();
            CompositeItem words = new CompositeItem(Elements.SENTENCE);
            words.getItems().add(parseToWords(snt));
            paragraphsItems.getItems().add(words);
        }
        return paragraphsItems;
    }

    // СДЕЛАТЬ ЧТОБЫ ОЛИЧАЛИСЬ ЗНАКИ ПРЕПИНАНИЯ И СЛОВА
    public Item parseToWords(String text) {
        CompositeItem words = new CompositeItem(Elements.WORD);
        Pattern pattern =  Pattern.compile(REGEX_WORD_OR_PUNCTUATION);
        Matcher matcher = pattern.matcher(text);
        String wd= "";
        while (matcher.find()){
            wd=matcher.group();
            if(Pattern.matches(REGEX_PUNCTUATION,wd)){
                TextItem pn =  new TextItem(wd,Elements.PUNCTUATION);
                words.getItems().add(pn);
            }
            else {
                TextItem word =  new TextItem(wd,Elements.WORD);
                words.getItems().add(word);
            }

        }
        return words;
    }
}
// добавить enum чтобы потом легче сортировать