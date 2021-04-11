package context;

import entity.Item;
import entity.TextItem;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import service.FileWorker.FileReader;
import text_elements.Elements;

import java.util.LinkedList;
import java.util.List;

@Data
@Slf4j
public class Context {
   TextItem textItem = new TextItem("",Elements.TEXT);
   public void initialization( String string) {
      this.textItem.setContext(string);
      log.info("Context was initialize");
   }
}
