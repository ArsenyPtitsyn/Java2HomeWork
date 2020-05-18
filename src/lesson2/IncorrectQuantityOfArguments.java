package lesson2;

public class IncorrectQuantityOfArguments extends Exception {

    private String message;

    IncorrectQuantityOfArguments(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
