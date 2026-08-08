package Models;

import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private Player_Position position;
    private int spp;
    private int value;
    private ArrayList<Skill> skills;

    private static final long serialVersionUID = 1L;

    public Player(String name, Player_Position position) {
        this.name = name;
        this.position = position;
        this.spp = 0;
        this.value = position.getCost();

        this.skills = new ArrayList<>();

        for (Skill skill : position.getSkills()) {
            this.skills.add(skill);
        }
    }

    public String getName() {
        return name;
    }

    public Player_Position getPosition() {
        return position;
    }

    public int getSpp() {
        return spp;
    }

    public void setSpp(int spp) {
        this.spp = spp;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    //This overide is what makes the player display its name,value skill 
    @Override
public String toString() {
    return name + " - "
            + position.getName() + " - "
            + value + "K - Skills: "
            + skillsToString();
}

private String skillsToString() {
    if (skills == null || skills.isEmpty()) {
        return "None";
    }

    String result = "";

    for (int i = 0; i < skills.size(); i++) {
        result += skills.get(i).getName();

        if (i < skills.size() - 1) {
            result += ", ";
        }
    }

    return result;
}
}