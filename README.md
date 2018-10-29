# Classy [![Build Status](https://travis-ci.org/koneko096/Classy.svg?branch=master)](https://travis-ci.org/koneko096/Classy)
 [ ![Download](https://api.bintray.com/packages/koneko096/maven/classy-core/images/download.svg) ](https://bintray.com/koneko096/maven/classy-core/_latestVersion)
 
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

        try {
            glassDataset.dropFields(Arrays.asList("Al", "K"));
        } catch (UndefinedFieldException e) {
            // handle error
        }

        out.println(String.format("KNN: %f", knnRunner.crossValidate(glassDataset, 10)));
    }
}

```

Example project see on `example` directory
