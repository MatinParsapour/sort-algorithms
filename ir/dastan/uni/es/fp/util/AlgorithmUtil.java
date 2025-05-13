package ir.dastan.uni.es.fp.util;

import ir.dastan.uni.es.fp.constant.ConsoleColor;
import ir.dastan.uni.es.fp.entity.*;
import ir.dastan.uni.es.fp.factory.AlgorithmFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ir.dastan.uni.es.fp.constant.Constant.EXCEL_MAXIMUM_ROW;
import static ir.dastan.uni.es.fp.constant.Constant.GROUP_SIZE;

public class AlgorithmUtil {

    private static final int EFFICIENT_CONSOLE_PRINTING_SIZE = 1000;

    private static final Map<Integer, Algorithm> algorithms = new HashMap<>() {
        {
            put(1, AlgorithmFactory.getBubbleSortAlgorithm());
            put(2, AlgorithmFactory.getInsertionSortAlgorithm());
            put(3, AlgorithmFactory.getMergeSortAlgorithm());
            put(4, AlgorithmFactory.getQuickSortAlgorithm());
        }
    };

    private static AlgorithmUtil instance;
    private Algorithm algorithm;

    private AlgorithmUtil() {}

    public static AlgorithmUtil getInstance(Algorithm algorithm) {
        if (instance == null) {
            instance = new AlgorithmUtil();
        }
        instance.changeAlgorithm(algorithm);
        return instance;
    }

    private void changeAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void run(long sampleSize, long size) {
        long index = 0;
        long counter = 1;
        List<Long> durations = new ArrayList<>();
        boolean printDataInExcel = ((size / GROUP_SIZE) * sampleSize) <= EXCEL_MAXIMUM_ROW;
        boolean printDataInConsole = ((size / GROUP_SIZE) * sampleSize) <= EFFICIENT_CONSOLE_PRINTING_SIZE;
        if (!printDataInConsole) {
            ContextUtil.getDisplayTextServiceImpl().set(ConsoleColor.RED_BOLD + "WARNING : Because of large sample size and length of list, only summarized data will be printed." + ConsoleColor.RESET).perform();
        }
        ContextUtil.getExcelServiceImpl().set((int) size);
        while (index < sampleSize) {
            algorithm.populate(size);
            ContextUtil.getDisplayTextServiceImpl().set(String.format("%s%s%s", "-".repeat(50), "Sample Number " + counter,"-".repeat(50))).perform();
            if (printDataInConsole) {
                ContextUtil.getDisplayTextServiceImpl().set(String.format("%s:", "Unsorted List")).perform();
                ContextUtil.getDisplayListService().set(algorithm.getList()).perform();
            }
            if (printDataInExcel) ContextUtil.getExcelServiceImpl().set(index).set(algorithm).perform();
            long time = ContextUtil.getChronometerServiceImpl().set(algorithm).perform();
            durations.add(time);
            if (printDataInExcel) ContextUtil.getExcelServiceImpl().set(index).set(algorithm).perform();
            if (printDataInConsole) {
                ContextUtil.getDisplayTextServiceImpl().set(String.format("%s:", "Sorted List")).perform();
                ContextUtil.getDisplayListService().set(algorithm.getList()).perform();
            }
            ContextUtil.getDisplayTextServiceImpl().set(String.format("%s%s%s", "-".repeat(37), String.format("Sample %s sorted in %s nano seconds", counter, time), "-".repeat(37))).perform();
            algorithm.clear();
            index++;
            counter++;
        }
        ContextUtil.getDisplayListService().set(durations).perform();
        ContextUtil.getExcelServiceImpl().set(algorithm).set(durations).set(true).perform();
        if (!printDataInExcel) {
            ContextUtil.getDisplayTextServiceImpl().set(ConsoleColor.RED_BACKGROUND_BRIGHT + "WARNING : Because of large sample size and length of list, only time of list being sorted be added to excel" + ConsoleColor.RESET).perform();
        }
        ContextUtil.getExcelServiceImpl().clear();
    }

    public static Algorithm getAlgorithm(int index) {
        return algorithms.get(index);
    }
}
