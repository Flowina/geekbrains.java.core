package homework_4;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }
        HashSet<String> phones = phoneBook.get(name);
        phones.add(phone);
    }

    public String[] get(String name) {
        if (phoneBook.containsKey(name)) {
            HashSet<String> phones = phoneBook.get(name);
            return phones.toArray(new String[phones.size()]);
        }
        return new String[0];
    }
}
