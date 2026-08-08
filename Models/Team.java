package Models;

import java.util.ArrayList;

public class Team {
    private String name; //The custom name like for example "Reikland Reavers"
    private Race race; //This is what kind of team it is Like "Human" or something like "Underworld Denazins"
    private int treasury; //Money
    private ArrayList<Player> players; //A list of all players
    private int rerolls; //The amount of rerolls the team has
    private boolean apothecary; //If the team has an apothecary or not
    private int fanFactor; //The teams fan factor
    private int assistants; //The amount of assistants the team has
    private int cheerleaders; //The amount of cheerleaders the team has
    private int Win; //The teams total Wins
    private int Loss; //The teams total Loses
    private int TTV; //This is the Total Team value.

    public Team(String name, Race race){
        this.name = name;
        this.race = race;
        this.treasury = 1000;
        this.players = new ArrayList<>();
        this.rerolls = 0;
        this.Win = 0;
        this.Loss = 0;
        this.TTV = 0;    
    }
 //getter for name
    public String getName() {
        return name;
    }
    //setter for name
    public void setName(String name) {
        this.name = name;
    }
 //getter for race
    public Race getRace() {
        return race;
    }
//setter for race
    public void setRace(Race race) {
        this.race = race;
    }

 //getter for treasury
    public int getTreasury() {
        return treasury;
    }
 //setter for treasury
    public void setTreasury(int treasury) {
        this.treasury = treasury;
    }
 //getter for players
    public ArrayList<Player> getPlayers() {
        return players;
    }
//setter for players
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


 //getter for rerolls
    public int getRerolls() {
        return rerolls;
    }
 //setter for rerolls
    public void setRerolls(int rerolls) {
        this.rerolls = rerolls;
    }

    //getter for apothecary
    public boolean hasApothecary() {
        return apothecary;
    }
    
    //setter for apothecary
    public void setHasApothecary(boolean doesHaveApothecary) {
        this.apothecary = doesHaveApothecary;
    }

 //getter for fan factor
    public int getFanFactor() {
        return fanFactor;
    }
    //Setter for fan factor
    public void setFanFactor(int fanFactor) {
        this.fanFactor = fanFactor;
    }

 //getter for assistants
    public int getAssistants() {
        return assistants;
    }
    //Setter for assistants
    public void setAssistants(int assistants) {
        this.assistants = assistants;
    }

 //getter for cheerleaders
    public int getCheerleaders() {
        return cheerleaders;
    }
    //Setter for cheerleaders
    public void setCheerleaders(int cheerleaders) {
        this.cheerleaders = cheerleaders;
    }

 //getter for WIN
    public int getWins() {
        return Win;
    }
    //Setter for WIN
    public void setWins(int win) {
        this.Win = win;
    }

 //getter for Losses
    public int getLosses() {
        return Loss;
    }
    //Setter for Losses
    public void setLosses(int loss) {
        this.Loss = loss;
    }
 //getter for TTV
    public int getTTV() {
        return TTV;
    }
    //Setter for TTV
    public void setTTV(int ttv) {
        this.TTV = ttv;
    }


    //This will make it so that when displaying the team in a dropdown or list, it will show the name and race of the team instead of a weird string of numbers.
    @Override
public String toString() {
    return name + " - " + race;
}

    
}
