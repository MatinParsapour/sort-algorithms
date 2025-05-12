package ir.dastan.uni.es.fp.util;

import ir.dastan.uni.es.fp.constant.ConsoleColor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int integer(String prompt) {
        try {
            ContextUtil.getDisplayTextServiceImpl().set(prompt).performInline();
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            ContextUtil.getDisplayTextServiceImpl().set(ConsoleColor.RED_BOLD + "Incorrect, please enter the number" + ConsoleColor.RESET).perform();
            scanner.nextLine();
            return integer(prompt);
        }
    }

    public static long bigInteger(String prompt) {
        try {
            ContextUtil.getDisplayTextServiceImpl().set(prompt).performInline();
            return scanner.nextLong();
        } catch (InputMismatchException exception) {
            ContextUtil.getDisplayTextServiceImpl().set(ConsoleColor.RED_BOLD + "Incorrect, please enter the number" + ConsoleColor.RESET).perform();
            scanner.nextLine();
            return bigInteger(prompt);
        }
    }
}
