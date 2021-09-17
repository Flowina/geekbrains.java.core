package homework_3;

import java.util.Arrays;

public class Main<T> {
    public static void main(String[] args) throws Exception {
// задача 1
        System.out.println("Задача 1: поменять местами элементы: 0 и 2");
        Box[] boxes = {new Box(4), new Box(2), new Box(10), new Box(1)};
        System.out.println(Arrays.toString(boxes));
        new Main<Box>().changeTwoElements(boxes, 0, 2);
        System.out.println(Arrays.toString(boxes));

        // задача 2
        System.out.println("Задача 2.Коробки с фруктами");
        Box<Apple> apples = new Box(10);
        Box<Apple> apples2 = new Box(5);
        Box<Orange> oranges = new Box(20);

        for (int i = 0; i < apples.boxSize - 6; i++) {
            apples.addToBox(new Apple());
        }
        for (int i = 0; i < apples2.boxSize; i++) {
            apples2.addToBox(new Apple());

        }
        System.out.println("коробка 1: " + apples);
        System.out.println("коробка 2: " + apples2);
        System.out.println("пересыпаем яблоки из коробки 1 в коробку 2");
        apples.pour(apples2);
        System.out.println("коробка 1: " + apples);
        System.out.println("коробка 2: " + apples2);
    }


    public void changeTwoElements(T[] arr, int i, int s) {
        T temp = arr[s];
        arr[s] = arr[i];
        arr[i] = temp;
    }

}
