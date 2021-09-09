package homework_2;

public class Main {
    public static void main(String[] args) {

        String[][] validArr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] invalidArr = {{"aaa", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] invalidArrLength = {{"aaa", "2", "3", "4", "5"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            System.out.println(sum(validArr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(sum(invalidArr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(sum(invalidArrLength));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        final int expectedArrLength = 4;
        int sum = 0;
        if (arr.length != expectedArrLength) {
            throw new MyArraySizeException(arr.length, expectedArrLength);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != expectedArrLength) {
                throw new MyArraySizeException(arr[i].length, expectedArrLength);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int c = Integer.parseInt(arr[i][j]);
                    sum = sum + c;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }

            }
        }


        return sum;
    }
}
