package runner;

import context.Context;
import entity.CompositeItem;
import lombok.extern.slf4j.Slf4j;
import parsing.ParsingText;
import service.FileWorker.FileReader;
import service.logic.Service;
import service.sort.SortSentence;
import text_elements.Elements;

@Slf4j
public class Runner {

    public static void main(String[] args) {
        log.debug("start app");

        Context text1 = new Context();
        Service service = new Service();
        ParsingText parsingText = new ParsingText();

        text1.initialization(new FileReader().read("C:\\Users\\stesh\\OneDrive\\Рабочий стол\\123131.txt"));

        CompositeItem ci = parsingText.listingParse(text1.getTextItem().getContext()); // параграфы

        service.deleteWord("алгоритм",ci);
        System.out.println(ci);

        System.out.println(service.getSentenceByWordCount(ci));

        log.debug("finish app");
    }
}
