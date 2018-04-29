package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.Header;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Loader.IO.InputReader;

import java.util.List;

public interface BaseLoader {
    void loadInput(InputReader input);
    Header loadHeader();
    List<Instance> loadInstances(Header header);
}
