package lesson2;

public class IncorrectQuantityOfArguments extends Exception {

    private String s;

    IncorrectQuantityOfArguments(String s) {
        this.s = s;
    }

    public String getString() {
        return s;
    }
}
