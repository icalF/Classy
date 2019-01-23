package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.Header;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Loader.IO.InputReader;
import id.koneko096.Classy.Util.Loggable;
import org.slf4j.Logger;

import java.util.List;

public interface BaseLoader extends Loggable {

  String LOAD_INPUT_DATASET_USING = "Load input dataset using: {}";

  /**
     * Get input supplier
     * TODO: return chainable object
     */
    void loadInput(InputReader input);

    default void writeLog(Logger log, String readerName) {
        writeLog(log, LOAD_INPUT_DATASET_USING, readerName);
    }

    Header parseHeader();

    List<Instance> parseInstances(Header header);
}
