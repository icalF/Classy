package id.koneko096.Classy.Loader.IO;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Slf4j
public class FileInputReaderFactory {
    public static InputReader make(String fileName) {
        InputReader inputReaderTemp;
        File initialFile = new File(fileName);

        try {
            InputStream is = new FileInputStream(initialFile);
            inputReaderTemp = new InputReader(is, "File input path: " + fileName);
        } catch (FileNotFoundException e) {
            inputReaderTemp = null;
            log.error("File={} not found", fileName);
            e.printStackTrace();
        }

        return inputReaderTemp;
    }
}
