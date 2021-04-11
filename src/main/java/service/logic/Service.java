package service.logic;

import entity.CompositeItem;
import entity.TextItem;
import service.sort.SortSentence;
import text_elements.Elements;

public class Service {

    public CompositeItem getSentenceByWordCount(CompositeItem ci){
        if(ci == null) throw new NullPointerException("Null object");
        CompositeItem compositeItem =  new CompositeItem();
        compositeItem.setItems(CompositeItem.getItemsByType(Elements.SENTENCE, ci));
        SortSentence.sortPartsByNumberOfItems(compositeItem);

        return compositeItem;
    }

    public void deleteWord(String wordForDelete,CompositeItem text) {

        for (int i=0; i<text.getItems().size(); i++) {

            if(text.getChild(i).getType().equals(Elements.WORD)){
                text.getItems().remove(new TextItem(wordForDelete,Elements.WORD));
                break;
            }
            else if(!text.getChild(i).getType().equals(Elements.CODE)){
                deleteWord(wordForDelete, (CompositeItem) text.getChild(i));
            }
            else break;
        }
    }
}