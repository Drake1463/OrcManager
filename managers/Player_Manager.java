package managers;

import Models.Player;
import Models.Player_Position;
import Models.Skill;

/*
This Program should:
Create player
Gain SPP
Level up
Add skills
Add injuries
Retire player
*/

public class Player_Manager {

    public Player createPlayer(String name, Player_Position position) {
        if (name == null || name.isEmpty() || position == null) {
            return null;
        }

        return new Player(name, position);
    }

    public boolean addSPP(Player player, int amount) {
        if (player == null || amount <= 0) {
            return false;
        }

        player.setSpp(player.getSpp() + amount);
        return true;
    }

    public boolean addSkill(Player player, Skill skill) {
        if (player == null || skill == null) {
            return false;
        }

        player.getSkills().add(skill);
        return true;
    }

    public boolean canLevelUp(Player player) {
        if (player == null) {
            return false;
        }

        return player.getSpp() >= 6;
    }
}
