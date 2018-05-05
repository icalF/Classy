# Classy [![Build Status](https://travis-ci.org/koneko096/Classy.svg?branch=master)](https://travis-ci.org/koneko096/Classy)

Simple kNN and NaiveBayes classifier implementation

## Usage example

```java

public class Test {
    public static void main(String[] args) {
        PrintStream out = System.out;
        BaseLoader csvLoader = new CsvLoader();

        BaseClassifier knn = new KNearestNeighbor(4);
        ClassificationRunner knnRunner = new ClassificationRunner(knn);
        csvLoader.loadInput(FileInputReaderFactory.make("data/glass/glass.csv"));

        InstanceSet glassDataset = InstanceSetFactory.make(csvLoader, "glass dataset");
        out.println(String.format("KNN: %f", knnRunner.crossValidate(glassDataset, 10)));
    }
}

```

Example project see on `example` directory