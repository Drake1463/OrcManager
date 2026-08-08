package Storage;

import Models.Team;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Data_Storage {

    public static boolean saveTeam(Team team, String filePath) {
        if (team == null || filePath == null || filePath.isEmpty()) {
            return false;
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(team);

            objectOut.close();
            fileOut.close();

            return true;
        } catch (IOException e) {
            System.out.println("Error saving team: " + e.getMessage());
            return false;
        }
    }

    public static Team loadTeam(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return null;
        }

        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Team loadedTeam = (Team) objectIn.readObject();

            objectIn.close();
            fileIn.close();

            return loadedTeam;
        } catch (IOException e) {
            System.out.println("Error loading team: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Team class not found: " + e.getMessage());
            return null;
        }
    }
}