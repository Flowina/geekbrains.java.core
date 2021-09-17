package homework_4;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String[] words = {"овца", "мышка", "кошка", "кошка", "собака", "рыбка", "собака", "олень", "собака", "мышка"};
        HashSet<String> wordsSet = new HashSet<String>();

        for (int i = 0; i < words.length - 1; i++) {
            wordsSet.add(words[i]);
            if (words[i].equals(words[i + 1])) {
                System.out.println(i);

            }
        }
        System.out.println("уникальные " + wordsSet.size());
        System.out.println("Task 2");
        task2();
    }

    private static void task2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bill", "+79110000000");
        phoneBook.add("Bill", "+796411111111");
        phoneBook.add("Bill", "+79110000000");// duplicate
        phoneBook.add("Bill", "+888888");
        phoneBook.add("Marry", "+77777");

        String[] bill = phoneBook.get("Bill");
        System.out.println("Bill: " + Arrays.toString(bill));

        String[] marry = phoneBook.get("Marry");
        System.out.println("Marry: " + Arrays.toString(marry));

        String[] absent = phoneBook.get("John");
        System.out.println("absent: " + Arrays.toString(absent));

    }
}
