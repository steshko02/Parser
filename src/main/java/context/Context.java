package context;
import entity.TextItem;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import text_elements.Elements;

@Data
@Slf4j
public class Context {
   TextItem textItem = new TextItem("",Elements.TEXT);

   public void initialization( String string) {
      this.textItem.setContext(string);
      log.info("Context was initialize");
   }
}
