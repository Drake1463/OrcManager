package Rules;
import Models.Race;
import Models.Skill;
import Models.Player_Position;
import java.util.ArrayList;
import java.util.Arrays;
/*This part is for the rules of bloodbowl
some things that it will keep track of
Can the Player level up
How much does this player cost
What is the teams TV
The skill list
reroll Purchases. */
public class Rules_Engine {

private static ArrayList<Skill> makeSkills(String... skillNames) {
    ArrayList<Skill> skills = new ArrayList<>();

    for (String skillName : skillNames) {
        skills.add(new Skill(skillName));
    }
    return skills;
}
    public static ArrayList<Player_Position>
    getAllowedPositions(Race race){
        ArrayList<Player_Position> roster = new ArrayList<>();
        switch (race) {
            //TODO Add other races and their allowed positions
            case HUMANS:
    roster.addAll(Arrays.asList(
        new Player_Position("Halfling Hopeful",0 ,"Lineman", 3, 30, 5, 2, 3, 4, 7,
                makeSkills("Dodge", "Right Stuff", "Stunty")),

        new Player_Position("Lineman",0 ,"Lineman", 16, 50, 6, 3, 3, 4, 9,
                makeSkills()),

        new Player_Position("Thrower",0 ,"Thrower", 2, 75, 6, 3, 3, 3, 9,
                makeSkills("Pass", "Sure Hands")),

        new Player_Position("Catcher",0 ,"Catcher", 2, 75, 8, 3, 3, 4, 8,
                makeSkills("Catch", "Dodge")),

        new Player_Position("Blitzer",0 ,"Blitzer", 2, 85, 7, 3, 3, 4, 9,
                makeSkills("Block", "Tackle")),

        new Player_Position("Ogre",0 ,"Ogre", 1, 140, 5, 5, 4, 5, 10,
                makeSkills("Bone Head", "Mighty Blow", "Thick Skull", "Throw Team-mate", "Loner (3+)"))
    ));
    break;
        
            default:
                break;
        } 
        return roster;
    }

    public static int getrerollCost(Race race){
        switch (race) {
            case HUMANS:
                return 50;
            default:
                return 0;
        }
    }

    //This method will return true if the team can buy a apothecary. The buying will be found in Team Manager
    public static boolean canBuyApothecary(Race race){
        switch (race) {
            case HUMANS:
                return true;

            case NURGLE:
                return false;
                
            default:
                return true;
        }
    }

     public static int getApothecaryCost(Race race){
        switch (race) {
            case HUMANS:
                return 50;
            default:
                return 0;
        }
    }
}
