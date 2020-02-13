package ru.java.courses.sport;

import ru.java.courses.sport.team.football.PlayerRole;

public interface ScoringPlayer {

    PlayerRole role;/////////////////////////?
    int goals;

    public void score() {///////////////////////////////////?
        if (isActive()) {
            goals++;
        } else {
            throw new IllegalArgumentException("Запасные игроки не могут забивать голы");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя");
        }
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public PlayerRole getRole() {
        return role;
    }////////////////////////////?

    public void setRole(PlayerRole role) {
        this.role = role;
    }//////////////?

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
