package lesson2;

public class Homework2 {

    public static void main(String[] arg) {
        final String initString= "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] resArr = transformString(initString);
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr[i].length; j++) {
                System.out.print(resArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Написать метод, на вход которого подаётся такая строка,
    // метод должен преобразовать строку в двумерный массив типа String[][];
    private static String[][] transformString(String str) {

        String[][] resArray = new String[4][4];

        String separrtor1 = "\n";
        String separrtor2 = " ";

        String[] arrayStr1 = str.split(separrtor1);
        for (int i = 0; i < arrayStr1.length; i++) {
            String[] arrayStr2 = arrayStr1[i].split(separrtor2);
            for (int j = 0; j < arrayStr2.length; j++) {
                resArray[i][j] = arrayStr2[j];
            }
        }

        return resArray;
    }
}
