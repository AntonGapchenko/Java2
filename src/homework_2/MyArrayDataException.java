package homework_2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i,int j) {
        super("В строке №" + (i+1) +" в столбце № " + (j+1) +  " лежит символ или текст вместо числа");
    }

}
