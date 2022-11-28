package edu.menu.console;

public class ConsoleColor {

    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String WHITE = "\u001B[37m";
    public static final String CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";


    private String _message = "";

    public static String colorln(String msg, String colorCode) {
        return colorCode + msg + ANSI_RESET;
    }

    public ConsoleColor append(String msg) {
        _message += msg;
        return this;
    }

    public ConsoleColor red() {
        _message += RED;
        return this;
    }

    public ConsoleColor red(String msg) {
        _message += RED + msg + ANSI_RESET;
        return this;
    }

    public ConsoleColor yellow() {
        _message += YELLOW;
        return this;
    }

    public ConsoleColor yellow(String msg) {
        _message += YELLOW + msg + ANSI_RESET;
        return this;
    }

    public ConsoleColor cyan() {
        _message += CYAN;
        return this;
    }

    
    public ConsoleColor cyan(String msg) {
        _message += CYAN + msg + ANSI_RESET;
        return this;
    }
    
    public ConsoleColor reset() {
        _message += ANSI_RESET;
        return this;
    }

    public String msg() {
        return _message;
    }

}
