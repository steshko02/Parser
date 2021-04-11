package service.FileWorker;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
@Slf4j
public class FileReader {
    public String read(String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (IOException e) {
            log.error("error type "+e);
            e.printStackTrace();
        }
        log.info("File was read");
        return text;
    }
}