package ru.java.courses.sport.team.football;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.ScoringPlayer;

public class FootballPlayer extends Athlete implements ScoringPlayer {

    private PlayerRole role;
    private int goals;

    public FootballPlayer(String name, PlayerRole role) {
        super(name);
        setRole(role);
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Пустая роль");
        }
        this.role = role;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void score() {
        if (isActive()) {
            goals++;
        } else {
            throw new IllegalArgumentException("Запасные игроки не могут забивать голы");
        }
    }
}
