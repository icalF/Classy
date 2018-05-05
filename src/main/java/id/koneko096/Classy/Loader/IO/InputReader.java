package id.koneko096.Classy.Loader.IO;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    @Getter private String name;

    public InputReader(InputStream stream, String name) {
        this.reader = new BufferedReader(new InputStreamReader(stream), 32768);
        this.tokenizer = null;
        this.name = name;
    }

    @SneakyThrows
    public String next() {
        return reader.readLine();
    }

    @SneakyThrows
    public String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = reader.readLine();
            if (line == null)
                return null;

            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }
}
