package runner;

import entity.CompositeItem;
import entity.Item;
import entity.Text;
import parsing.ParsingText;
import service.logic.Service;
import service.sort.SortSentence;
import text_elements.Elements;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Text text1 = new Text();

        text1.initialization("C:\\Users\\stesh\\OneDrive\\Рабочий стол\\123131.txt");

        ParsingText parsingText = new ParsingText();

        CompositeItem ci = parsingText.listingParse(text1.getText()); // параграфы

          Service service = new Service();

        service.deleteWord("алгоритм",ci);
        System.out.println(ci);

    }
}
