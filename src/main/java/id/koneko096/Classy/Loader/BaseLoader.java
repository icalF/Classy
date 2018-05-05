package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.Header;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Loader.IO.InputReader;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class BaseLoader {
    public void loadInput(InputReader input) {
        log.debug("Load input dataset using: {}", input.getName());
    }

    public Header loadHeader() {
        return null;
    }

    public List<Instance> loadInstances(Header header) {
        return null;
    }
}
