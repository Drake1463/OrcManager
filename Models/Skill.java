package Models;

import java.io.Serializable;


public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean expert;
    private int value;
    private String name;
    private String description;
    private String type;

    public Skill(String name) {
        this.name = name;
        this.description = "";
        this.type = "";
        this.value = 0;
        this.expert = false;
    }

    public Skill(String name, String description, String type, int value, boolean expert) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.value = value;
        this.expert = expert;
    }

    public String getName() {
        return name;
    }

    public boolean isExpert() {
        return expert;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}