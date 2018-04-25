package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.InstanceSet;

public class CsvLoader implements BaseLoader {
    @Override
    public InstanceSet parseFile(String fileName) {
        return new InstanceSet(null);
    }
}
