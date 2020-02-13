package ru.java.courses.sport.team;

import ru.java.courses.sport.Coach;
import ru.java.courses.sport.ScoringPlayer;

import java.util.List;

public abstract class Team<T extends ScoringPlayer> {
    private String Name;
    private List<T> players;
    private Coach coach;

    public Team(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя");
        }
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя");
        }
        this.Name = name;
    }

    public List<T> getPlayers() {
        return players;
    }

    public void setPlayers(List<T> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getPlayersCount() { //метод количество игроков (пункт 11)
        return players.size();
    }

    public void addPlayer(T player) {
        players.add(player);
    }

    public void addPlayers(T... players) {
        for (T player : players) {
            addPlayer(player);
        }
    }

    public void removePlayer(T player) {
        players.remove(player);
    }

    public int getScore() {////////////////////////////////////////////////?
        int res = 0;
        for (int i = 0; i == getPlayersCount() - 1; i++) {
            res += players.get(i).getGoals();
        }
        return res;
    }
}