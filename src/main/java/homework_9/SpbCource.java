package homework_9;

public class SpbCource implements Course {
    private final int id;

    public SpbCource(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
