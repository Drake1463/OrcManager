package Models;

import java.util.ArrayList;
import java.io.Serializable;


public class Player_Position implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int jerseyNumber;
    private String category;
    private int maxAllowed;
    private int cost;

    private int movement;
    private int strength;
    private int agility;
    private int passing;
    private int armor;
    private ArrayList<Skill> skills;

    public Player_Position(String name, int jerseyNumber, String category, int maxAllowed, int cost, int movement, int strength, int agility, int passing, int armor, ArrayList<Skill> skills) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.category = category;
        this.maxAllowed = maxAllowed;
        this.cost = cost;
        this.movement = movement;
        this.strength = strength;
        this.agility = agility;
        this.passing = passing;
        this.armor = armor;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getCategory() {
        return category;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public int getCost() {
        return cost;
    }

    public int getMovement() {
        return movement;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getPassing() {
        return passing;
    }

    public int getArmor() {
        return armor;
    }

    public ArrayList<Skill> getSkills() {
        return skills;    
    }

    @Override
    public String toString() {
    return name + " - "  + cost + "K";
}
    

}
