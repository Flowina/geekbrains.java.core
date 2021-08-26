package homework_1;

import homework_1.hindrance.Barrier;
import homework_1.hindrance.Hole;
import homework_1.hindrance.Pool;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.addHindance(new Barrier(10));
        course1.addHindance(new Hole(15));
        course1.addHindance(new Pool(25));

        Team team1 = new Team(4);
        TeamMember number1=new TeamMember("Nick",1,100);
        TeamMember number10=new TeamMember("Mike",10,40);
        try {
            team1.addMember(number1);
            team1.addMember(number10);

           course1.runTeam(team1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
