package ru.java.courses.sport.team.football;

import ru.java.courses.sport.team.Team;

public class FootballTeam extends Team<FootballPlayer> {

    public FootballTeam(String name) {
        super(name);
    }

    public void addPlayer(FootballPlayer player) {
        if (getPlayersCount() < 20) {
            addPlayer(player);
        } else {
            throw new IllegalArgumentException("Достигнуто максимальное оличество игроков");
        }
    }

}
