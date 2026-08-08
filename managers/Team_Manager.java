package managers;
import Models.Team;
import Models.Player;

/*This program should do the following
Create team
Delete team
Rename team
Hire players
Fire players
Buy staff
    buy apothacary
    buy assistants
    buy cheerleaders
    buy fan factor
Buy rerolls
Calculate TV
*/
public class Team_Manager {
    

public boolean hirePlayer(Team team, Player player) {
    if (team == null || player == null) {
        return false;
    }

    if (team.getTreasury() < player.getValue()) {
        System.out.println("This team does not have enough money to hire this player.");
        return false;
    }

    team.getPlayers().add(player);
    team.setTreasury(team.getTreasury() - player.getValue());

    return true;
}

public boolean firePlayer(Team team, Player player) {
    if (team == null || player == null) {
        return false;
    }

    return team.getPlayers().remove(player);
}
public boolean buyReroll(String teamName, int rerollCost){
    //This method will check if the team has enough money to buy a reroll. If they do it will subtract the cost from their treasury and add a reroll to their team.
    return true;
}

//this checks to make sure there is a Team to target.
public boolean buyApothecary(Team team){
    if(team == null){
        return false;
    }
    //This checks to see if the team can buy an apothecary by looking at the rules engine
    if (!Rules.Rules_Engine.canBuyApothecary(team.getRace())) {
        System.out.println("This team cannot buy an apothecary.");
        return false;
    }

//This checks to see if the team already has an apothecary
    if (team.hasApothecary()) {
        System.out.println("This team already has an apothecary.");
        return false;
    }

    //This checks the Rules engine to see what the teams rereolls cost will be
    int cost = Rules.Rules_Engine.getApothecaryCost(team.getRace());
    
    //This checks to see if the team has enough money to buy a reroll
    if (team.getTreasury() < cost) {
        System.out.println("This team does not have enough money to buy an apothecary.");
        return false;
    }

    // If all checks above are made then the code 
    // below will subtracts the cost of the apothecary from the teams treasury and adds an apothecary to the team.

        team.setTreasury(team.getTreasury() - cost);
        team.setHasApothecary(true);



    return true;
}

}
