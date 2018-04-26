package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Loader.IO.FileInputReader;

import java.util.Arrays;
import java.util.List;

public class CsvLoader implements BaseLoader {
    private final static String COMMA = ",";

    @Override
    public InstanceSet parseFile(String fileName) {
        FileInputReader in = new FileInputReader(fileName);

        String header = in.next();
        String[] ar = header.split(CsvLoader.COMMA);
        List<String> attributeNames = Arrays.asList(ar).subList(0, ar.length-1);

        do {
            String line = in.next();
            String[] ar = line.split(CsvLoader.COMMA);
            List<String> attrs = Arrays.asList(ar).subList(0, ar.length-1);
            if (line == null) break;
        } while (true);
        return null;
    }
}
