package ir.dastan.uni.es.fp.context;

import ir.dastan.uni.es.fp.constant.ConsoleColor;
import ir.dastan.uni.es.fp.entity.Algorithm;
import ir.dastan.uni.es.fp.ui.Menu;
import ir.dastan.uni.es.fp.util.AlgorithmUtil;
import ir.dastan.uni.es.fp.util.ContextUtil;
import ir.dastan.uni.es.fp.util.InputUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ApplicationContext {

    private static final int MINIMUM_LENGTH = 10;
    private static final int MINIMUM_SAMPLE_SIZE = 10;

    public static void start() {
        Menu.welcome();
        Menu.menu();
        int input = InputUtil.integer("Algorithm : ");
        Algorithm algorithm = AlgorithmUtil.getAlgorithm(input);
        if (algorithm == null) {
            start();
        }
        long length = InputUtil.bigInteger("Length : ");
        if (length < MINIMUM_LENGTH) {
            ContextUtil.getDisplayTextServiceImpl().set(ConsoleColor.RED_BOLD + "Length can not be less than " + MINIMUM_LENGTH + ConsoleColor.RESET).perform();
            start();
        }
        long sampleSize = InputUtil.bigInteger("Sample Size : ");
        if (sampleSize < MINIMUM_SAMPLE_SIZE) {
            ContextUtil.getDisplayTextServiceImpl().set(ConsoleColor.RED_BOLD + "Sample size can not be less than " + MINIMUM_SAMPLE_SIZE + ConsoleColor.RESET).perform();
            start();
        }
        AlgorithmUtil.getInstance(algorithm).run(sampleSize, length);
        Menu.bye();
        if (InputUtil.integer("Do you want to redo the algorithm? ") == 1) {
            start();
        }
    }
}
