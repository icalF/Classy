package id.koneko096.Classy;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Classifier.Knn;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Loader.CsvLoader;
import id.koneko096.Classy.Runner.ClassificationRunner;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;

        BaseClassifier classifier = new Knn(5);
        ClassificationRunner runner = new ClassificationRunner(classifier);

        InstanceSet dataset = new CsvLoader().parseFile("data/glass/glass.csv");
        out.println(runner.crossValidate(dataset, 10));
    }
}
