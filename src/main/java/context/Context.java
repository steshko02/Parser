package context;

import entity.Item;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Context {

   private List<Item> Items = new LinkedList<>();


}
