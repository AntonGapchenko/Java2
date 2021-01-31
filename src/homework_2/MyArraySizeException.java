package homework_2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Не корректный размер массива. Массив должен быть 4X4");
    }
}
