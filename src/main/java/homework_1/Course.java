package homework_1;

import homework_1.hindrance.Hindrance;

import java.util.LinkedList;
import java.util.List;

public class Course {

    List<Hindrance> hindrances = new LinkedList<>();

    public void addHindance(Hindrance hindrance) {
        hindrances.add(hindrance);
    }

    public void runTeam(Team team) {
        for (Hindrance hi:hindrances
             ) {
            team.run(hi);
        }
        System.out.println("Finish");
    }
}
