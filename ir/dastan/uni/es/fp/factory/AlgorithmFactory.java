package ir.dastan.uni.es.fp.factory;

import ir.dastan.uni.es.fp.entity.*;

public class AlgorithmFactory {

    public static Algorithm getBubbleSortAlgorithm() {
        return new Bubble();
    }

    public static Algorithm getInsertionSortAlgorithm() {
        return new Insertion();
    }

    public static Algorithm getMergeSortAlgorithm() {
        return new Merge();
    }

    public static Algorithm getQuickSortAlgorithm() {
        return new Quick();
    }

}
