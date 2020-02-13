package ru.java.courses.sport.team.football;

import ru.java.courses.sport.ScoringPlayer;

public class FootballPlayer extends ScoringPlayer {

    public FootballPlayer(String name, PlayerRole role) {//////////////////?
        super(name);
        if (role == null) {
            throw new IllegalArgumentException("У игрока должна быть роль");
        }
        setRole(role);
    }
}
