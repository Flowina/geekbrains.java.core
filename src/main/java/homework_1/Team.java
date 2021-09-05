package homework_1;

import homework_1.hindrance.Hindrance;

public class Team {
    TeamMember[] teamMembers;

    public Team(int teamLengh) {
        this.teamMembers = new TeamMember[teamLengh];
    }

    public void addMember(TeamMember teamMember) throws Exception {
        for (int i = 0; i < teamMembers.length; i++) {
            if (teamMembers[i] == null) {
                teamMembers[i] = teamMember;
                return;
            }
        }
        throw new Exception("извини, команда укомплектована");
    }

    public void run(Hindrance hi) {
        for (TeamMember y : teamMembers
        ) {
            if (y == null || y.getPower() < 0) {
                continue;
            }
            y.run(hi.complex);
            if (y.getPower() > 0) {
                System.out.println(y.getInfo() + " преодолел препятствие " + hi.getInfo());
            } else System.out.println(y.getInfo() + " сошел с дистанции");
        }
    }
}
