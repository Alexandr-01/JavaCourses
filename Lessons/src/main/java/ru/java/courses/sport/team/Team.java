package ru.java.courses.sport.team;

import ru.java.courses.sport.Coach;
import ru.java.courses.sport.ScoringPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class Team<T extends ScoringPlayer> {
    private String name;
    private List<T> players = new ArrayList<T>();
    private Coach coach;

    public Team(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя");
        }

        this.name = name;
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

    public int getPlayersCount() {
        return players.size();
    }

    public void addPlayer(T player) {
        if (getPlayersCount() < getMaxPlayersCount()) {
            players.add(player);
        } else {
            throw new IllegalArgumentException("Достигнуто максимальное оличество игроков");
        }
    }

    public void addPlayers(T... players) {
        for (T player : players) {
            addPlayer(player);
        }
    }

    public void removePlayer(T player) {
        players.remove(player);
    }

    public int getScore() {
        int res = 0;
        for (int i = 0; i < getPlayersCount(); i++) {
            res += players.get(i).getGoals();
        }
        return res;
    }


    public abstract int getMaxPlayersCount();
}