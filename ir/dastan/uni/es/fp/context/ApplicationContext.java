package ir.dastan.uni.es.fp.context;

import ir.dastan.uni.es.fp.entity.Algorithm;
import ir.dastan.uni.es.fp.ui.Menu;
import ir.dastan.uni.es.fp.util.AlgorithmUtil;
import ir.dastan.uni.es.fp.util.InputUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ApplicationContext {

    public static void start() {
        Menu.welcome();
        Menu.menu();
        int input = InputUtil.integer("Algorithm : ");
        long length = InputUtil.bigInteger("Length : ");
        long sampleSize = InputUtil.bigInteger("Sample Size : ");
        Algorithm algorithm = AlgorithmUtil.getAlgorithm(input, length);
        if (algorithm == null) {
            start();
        }
        AlgorithmUtil.getInstance(algorithm).run(sampleSize);
    }

    public static void end() throws IOException {
        Menu.bye();
        if (InputUtil.integer("Do you want to redo the algorithm? ") == 1) {
            start();
        }
    }
}
