package homework_2;

public class MyArraySizeException extends Exception {
    private int currentArrLength;
    private int expectedArrLength;

    public MyArraySizeException(int currentArrLength, int expectedArrLength) {
        super(String.format("неправильный размер массива, текущая длинна = %d, ожидаемая длинна = %d:", currentArrLength, expectedArrLength));
        this.currentArrLength = currentArrLength;
        this.expectedArrLength = expectedArrLength;
    }

    public int getCurrentArrLength() {
        return currentArrLength;

    }

    public int getExpectedArrLength() {
        return expectedArrLength;
    }
}
