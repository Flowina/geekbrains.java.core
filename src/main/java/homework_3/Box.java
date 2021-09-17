package homework_3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> fruits;
    final int boxSize;

    public Box(int size) {
        fruits = new ArrayList<>(size);
        boxSize = size;
    }

    public int getSize() {
        return fruits.size();
    }


    @Override
    public String toString() {
        return "Box {" +
                "объем=" + boxSize + ", заполнено = " + getSize() +
                '}';
    }

    public float getWeight() {
        float sum = 0;
        for (T fruit : fruits
        ) {
            sum = sum + fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box box) {
        return box.getWeight() == this.getWeight();
    }

    public void addToBox(T fruit) throws Exception {
        if (this.getSize() == boxSize) {
            throw new Exception("Нет места");
        }
        fruits.add(fruit);
    }

    public T extractFromBox(int index) {
        return fruits.remove(index);
    }

    public void pour(Box<T> box) throws Exception {
        while (box.getSize() > 0) {
            T fruit = box.extractFromBox(0);
            if (fruit != null) {
                this.addToBox(fruit);
            }
        }
    }

}
