package homework_1;

public class TeamMember {
    String name;
    int number;
    int power;
    public int getPower() {
        return power;
    }

    public TeamMember(String name, int number, int power) {
        this.name = name;
        this.number = number;
        this.power = power;
    }

    public String getInfo() {
        return "имя : "+name + ", №" + number + ", сила: " + power;
    }

    public void run(int energy) {
        this.power -= energy;
    }
}
