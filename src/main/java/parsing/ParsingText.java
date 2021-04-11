package parsing;

import entity.CompositeItem;
import entity.Item;
import entity.TextItem;
import lombok.extern.slf4j.Slf4j;
import text_elements.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class ParsingText {

    public CompositeItem listingParse(String text){
        if(text == null) {
            log.error("Null object");
            throw new NullPointerException("Null string"); //попробовать переделать
        }

        CompositeItem textItems = new CompositeItem(Elements.TEXT);
        Pattern pattern =  Pattern.compile(Elements.TEXT.getRegexForSplit());
        Matcher matcher = pattern.matcher(text);

        String pr;
        while (matcher.find()){
            pr=matcher.group();
            Item part;
            if(Pattern.matches(Elements.CODE.getRegexForSplit(), pr)){
                part = new TextItem(pr,Elements.CODE);
            }
            else {
                part = parseToSentences(pr);
            }
            textItems.getItems().add(part);
        }
        log.info("Paragraphs parser is finished");
        return  textItems;
    }

    public CompositeItem parseToSentences(String text) {

        if(text == null) {
            log.error("Null object");
            throw new NullPointerException("Null string"); //попробовать переделать
        }
        CompositeItem paragraphsItems = new CompositeItem(Elements.PARAGRAPH); //
        Pattern pattern =  Pattern.compile(Elements.SENTENCE.getRegexForSplit());
        Matcher matcher = pattern.matcher(text);

        String snt;
        while (matcher.find()){
            snt=matcher.group();
            paragraphsItems.getItems().add(parseToWords(snt));
        }
        log.info("Sentence parser is finished");
        return paragraphsItems;
    }

    public CompositeItem parseToWords(String text) {

        if(text == null) {
            log.error("Null object");
            throw new NullPointerException("Null string");
        }
        CompositeItem words = new CompositeItem(Elements.SENTENCE);
        Pattern pattern =  Pattern.compile(Elements.WORD.getRegexForSplit());
        Matcher matcher = pattern.matcher(text);

        String wd;
        while (matcher.find()){
            wd=matcher.group();
            TextItem item;
            if(Pattern.matches(Elements.PUNCTUATION.getRegexForSplit(), wd)){
                item = new TextItem(wd,Elements.PUNCTUATION);
            }
            else {
                item =  new TextItem(wd,Elements.WORD);
            }
            words.getItems().add(item);
        }
        log.info("TextItem parser is finished");
        return words;
    }
}
