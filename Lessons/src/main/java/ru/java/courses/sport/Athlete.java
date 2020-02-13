package ru.java.courses.sport;

public class Athlete {
    private String name;
    private boolean active;

    public Athlete(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя или опыт");
        }
        this.name = name;
        this.active = true;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
