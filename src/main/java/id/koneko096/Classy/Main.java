package id.koneko096.Classy;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Classifier.Knn;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Data.InstanceSetFactory;
import id.koneko096.Classy.Loader.BaseLoader;
import id.koneko096.Classy.Loader.CsvLoader;
import id.koneko096.Classy.Loader.IO.FileInputReaderFactory;
import id.koneko096.Classy.Runner.ClassificationRunner;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;

        BaseClassifier classifier = new Knn(5);
        ClassificationRunner runner = new ClassificationRunner(classifier);

        BaseLoader loader = new CsvLoader();
        loader.loadInput(FileInputReaderFactory.make("data/glass/glass.csv"));

        InstanceSet dataset = InstanceSetFactory.make(loader);
        out.println(runner.crossValidate(dataset, 10));
    }
}
