package entity;

import lombok.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Data
public class Text  {

   private String text;

   public void initialization( String path) {
       text = "";
      try {
         FileInputStream inFile = new FileInputStream(path);
         byte[] str = new byte[inFile.available()];
         inFile.read(str);
         text = new String(str); // String with all text
         // System.out.println(text);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      //System.out.println(text);
   }
}


