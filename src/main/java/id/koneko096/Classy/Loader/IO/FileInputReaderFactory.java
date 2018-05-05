package id.koneko096.Classy.Loader.IO;

import java.io.*;

public class FileInputReaderFactory {
    public static InputReader make(String fileName) {
        InputReader inputReaderTemp;
        File initialFile = new File(fileName);

        try {
            InputStream is = new FileInputStream(initialFile);
            inputReaderTemp = new InputReader(is, "File input path: " + fileName);
        } catch (FileNotFoundException e) {
            inputReaderTemp = null;
            e.printStackTrace();
        }

        return inputReaderTemp;
    }
}
