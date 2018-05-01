package id.koneko096.Classy;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Classifier.KNearestNeighbor;
import id.koneko096.Classy.Classifier.NaiveBayes;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Data.InstanceSetFactory;
import id.koneko096.Classy.Loader.ArffLoader;
import id.koneko096.Classy.Loader.BaseLoader;
import id.koneko096.Classy.Loader.CsvLoader;
import id.koneko096.Classy.Loader.IO.FileInputReaderFactory;
import id.koneko096.Classy.Runner.ClassificationRunner;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;
        BaseLoader csvLoader = new CsvLoader();

        BaseClassifier knn = new KNearestNeighbor(8);
        ClassificationRunner knnRunner = new ClassificationRunner(knn);
        csvLoader.loadInput(FileInputReaderFactory.make("data/glass/glass.csv"));

        InstanceSet glassDataset = InstanceSetFactory.make(csvLoader);
        out.println(String.format("KNN: %f", knnRunner.crossValidate(glassDataset, 10)));

        BaseLoader arffLoader = new ArffLoader();

        BaseClassifier nb = new NaiveBayes();
        ClassificationRunner nbRunner = new ClassificationRunner(nb);
        arffLoader.loadInput(FileInputReaderFactory.make("data/car/car.arff"));

        InstanceSet carDataset = InstanceSetFactory.make(arffLoader);
        out.println(String.format("NB: %f", nbRunner.crossValidate(carDataset, 10)));
    }
}
