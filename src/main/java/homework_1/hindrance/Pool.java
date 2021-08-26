package homework_1.hindrance;

public class Pool extends Hindrance {
    public Pool(int complex) {
        super(complex);
    }

    @Override
    public String getInfo() {
        return "Бассейн сложность: " + complex;
    }
}
