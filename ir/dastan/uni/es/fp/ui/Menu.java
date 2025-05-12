package ir.dastan.uni.es.fp.ui;

import ir.dastan.uni.es.fp.util.ContextUtil;

public class Menu {

    public static void welcome() {
        ContextUtil.getDisplayTextServiceImpl().set("Welcome").perform();
    }

    public static void menu() {
        ContextUtil.getDisplayTextServiceImpl().set(String.format("|     1-%-20s|\n|     2-%-20s|\n|     3-%-20s|\n|     4-%-20s|", "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort")).perform();
    }

    public static void bye() {
        ContextUtil.getDisplayTextServiceImpl().set("Press 1 to redo the algorithm, or press any other key to close").perform();
    }

}
