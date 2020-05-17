package lesson2;

public class Homework2 {

    public static void main(String[] arg) {
        final String initString= "13 4 6 2\n2 3 2 25\n300 3 1 132\n3 46 17 r";
        try {
            String[][] resArr = transformString(initString);
            for (int i = 0; i < resArr.length; i++) {
                for (int j = 0; j < resArr[i].length; j++) {
                    System.out.print(resArr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(calculateStringArray(resArr));
        } catch (IncorrectQuantityOfArguments e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // 1. Написать метод, на вход которого подаётся такая строка,
    // метод должен преобразовать строку в двумерный массив типа String[][];
    private static String[][] transformString(String str) throws IncorrectQuantityOfArguments {

        String[][] resArray = new String[4][4];

        String separator1 = "\n";
        String separator2 = " ";

        String[] arrayStr1 = str.split(separator1);
        if (arrayStr1.length != 4)
            throw new IncorrectQuantityOfArguments("Invalid number of rows!");
        else {
            for (int i = 0; i < arrayStr1.length; i++) {
                String[] arrayStr2 = arrayStr1[i].split(separator2);
                if (arrayStr2.length != 4)
                    throw new IncorrectQuantityOfArguments("Invalid number of columns!");
                else {
                    for (int j = 0; j < arrayStr2.length; j++) {
                        resArray[i][j] = arrayStr2[j];
                    }
                }
            }
        }

        return resArray;
    }

    // 2. Преобразовать все элементы массива в числа типа int, просуммировать,
    // поделить полученную сумму на 2, и вернуть результат;
    private static float calculateStringArray(String[][] array) throws NumberFormatException{

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            int[][] supportIntArr = new int[array.length][array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                supportIntArr[i][j] = Integer.parseInt(array[i][j]);
                sum += supportIntArr[i][j];
            }
        }
        return sum /2;
    }
}
