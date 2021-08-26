package homework_1.hindrance;

public class Hole extends Hindrance {
    public Hole(int complex) {
        super(complex);
    }

    @Override
    public String getInfo() {
        return "Яма сложность: " + complex;
    }
}
