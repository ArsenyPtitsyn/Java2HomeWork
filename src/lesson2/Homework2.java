package lesson2;

public class Homework2 {

    public static void main(String[] arg) {
        final String initString= "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[] arrStr = transformString(initString);
        for (int i = 0; i < arrStr.length; i++)
            System.out.print(arrStr[i] + " ");
    }

    //Написать метод, на вход которого подаётся такая строка,
    // метод должен преобразовать строку в двумерный массив типа String[][];
    private static String[] transformString(String str) {
        String separrtor = " ";
        return str.split(separrtor);
    }
}
