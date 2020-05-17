package lesson2;

public class IncorrectNumberOfArguments extends Exception {
    private String s;

    IncorrectNumberOfArguments(String s) {
        this.s = s;
    }

    public String getString() {
        return s;
    }
}
