package homework_2;

public class Main {
    public static void main(String[] args) {
        String[][] array = {{"2", "4", "6", "6"}, {"12", "10", "44", "50"}, {"10", "14", "65", "6"}, {"4", "34", "70", "21"}};
        String[][] array2 = {{"2", "4", "6", "6"}, {"12", "10", "44", "50", "22"}, {"10", "14", "65", "6"}, {"4", "34", "70", "21"}};
        String[][] array3 = {{"2", "4", "6", "6"}, {"12", "10", "44", "5"}, {"10", "14", "65", "Какой-то текст"}, {"4", "34", "70", "21"}};

        try {
            calcSumAndCheckSize(array);
            calcSumAndCheckSize(array2);

        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            calcSumAndCheckSize(array3);
        } catch (MyArraySizeException | MyArrayDataException e) {

            e.printStackTrace();
        }
    }

    public static void calcSumAndCheckSize(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].length != 4 && array[j].length != 4) {
                    throw new MyArraySizeException();
                } else {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }

            }
        }
        System.out.println("Сумма массива:" + sum);
    }
}

