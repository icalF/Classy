package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.Header;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Loader.IO.InputReader;
import org.slf4j.Logger;

import java.util.List;

public interface BaseLoader {

    /**
     * Get input supplier
     * TODO: return chainable object
     */
    void loadInput(InputReader input);

    default void writeLog(Logger log, String readerName) {
        log.debug("Load input dataset using: {}", readerName);
    }

    Header parseHeader();

    List<Instance> parseInstances(Header header);
}
