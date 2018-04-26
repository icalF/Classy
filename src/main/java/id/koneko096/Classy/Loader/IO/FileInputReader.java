package id.koneko096.Classy.Loader.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputReader {
    private final InputReader inputReader;

    public FileInputReader(String fileName) {
        InputReader inputReaderTemp;
        File initialFile = new File(fileName);

        try {
            InputStream is = new FileInputStream(initialFile);
            inputReaderTemp = new InputReader(is);
        } catch (FileNotFoundException e) {
            inputReaderTemp = null;
            e.printStackTrace();
        }
        this.inputReader = inputReaderTemp;
    }

    public String next() {
        return inputReader.next();
    }
}
