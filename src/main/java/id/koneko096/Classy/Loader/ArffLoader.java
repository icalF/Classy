package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Loader.IO.InputReader;

import java.util.List;

public class ArffLoader implements BaseLoader {
    private InputReader input;

    @Override
    public void loadInput(InputReader input) {
        this.input = input;
    }

    @Override
    public List<String> loadHeader() {
        return null;
    }

    @Override
    public List<Instance> loadInstances(List<String> header) {
        return null;
    }
}
