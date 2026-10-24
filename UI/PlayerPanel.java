
package UI;

import Models.Team;
import Models.Player;
import Models.Player_Position;
import Rules.Rules_Engine;
import managers.Team_Manager;
import managers.Player_Manager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;


/* This will Display a Single Player Like
There Name
There Position
There Stats
There SPP
There Value

 */

public class PlayerPanel extends JPanel {

    private Team currentTeam;

    //This creates the Player Name field
    private JTextField playerNameField;
    private JSpinner jerseyNumberSpinner;

    private JComboBox<Team> teamDropdown;

    //this creates the Position Dropdown
    private JComboBox<Player_Position> positionDropdown;


    //This is creates both Hiring and Firing of buttons
    private JButton hireButton;
    private JButton fireButton;

    private DefaultListModel<Player> rosterListModel;
    private JList<Player> rosterList;

    private JTextArea outputArea;

    private Team_Manager teamManager;
    private Player_Manager playerManager;

    public PlayerPanel() {
        teamManager = new Team_Manager();
        playerManager = new Player_Manager();

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));

        playerNameField = new JTextField();
        jerseyNumberSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        teamDropdown = new JComboBox<>();
        positionDropdown = new JComboBox<>();

        hireButton = new JButton("Hire Player");
        fireButton = new JButton("Fire Selected Player");

        formPanel.add(new JLabel("Player Name:"));
        formPanel.add(playerNameField);
        formPanel.add(new JLabel("Jersey Number:"));
        formPanel.add(jerseyNumberSpinner);

        formPanel.add(new JLabel("Team:"));
        formPanel.add(teamDropdown);

        formPanel.add(new JLabel("Position:"));
        formPanel.add(positionDropdown);

        formPanel.add(hireButton);
        formPanel.add(fireButton);

        rosterListModel = new DefaultListModel<>();
        rosterList = new JList<>(rosterListModel);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(rosterList), BorderLayout.CENTER);
        add(outputArea, BorderLayout.SOUTH);

        hireButton.addActionListener(e -> hirePlayer());
        fireButton.addActionListener(e -> fireSelectedPlayer());
    }

    public void setCurrentTeam(Team team) {
        this.currentTeam = team;
        refreshPositionDropdown();
        refreshRosterList();
        refreshTeamDropdown();

        if (currentTeam != null) {
            outputArea.setText("Current team: " + currentTeam.getName()
                    + "\nTreasury: " + currentTeam.getTreasury() + "K");
        }
    }

    private void refreshPositionDropdown() {
        positionDropdown.removeAllItems();

        if (currentTeam == null) {
            return;
        }

        ArrayList<Player_Position> positions =
                Rules_Engine.getAllowedPositions(currentTeam.getRace());

        for (Player_Position position : positions) {
            positionDropdown.addItem(position);
        }
    }

    private void refreshTeamDropdown() {
        teamDropdown.removeAllItems();

        if (currentTeam == null) {
            return;
        }

        teamDropdown.addItem(currentTeam);
        teamDropdown.setSelectedItem(currentTeam);
    }

    private void refreshRosterList() {
        rosterListModel.clear();

        if (currentTeam == null) {
            return;
        }

        for (Player player : currentTeam.getPlayers()) {
            rosterListModel.addElement(player);
        }
    }

    private void hirePlayer() {
        if (currentTeam == null) {
            outputArea.setText("Create a team first.");
            return;
        }

        String playerName = playerNameField.getText();

        if (playerName == null || playerName.isEmpty()) {
            outputArea.setText("Enter a player name.");
            return;
        }

        Player_Position selectedPosition =
                (Player_Position) positionDropdown.getSelectedItem();

        if (selectedPosition == null) {
            outputArea.setText("Choose a position.");
            return;
        }

        Player newPlayer = playerManager.createPlayer(
            playerName, (Integer) jerseyNumberSpinner.getValue(), selectedPosition);

        if (newPlayer == null) {
            outputArea.setText("Could not create player.");
            return;
        }

        boolean hired = teamManager.hirePlayer(currentTeam, newPlayer);

        if (hired) {
            outputArea.setText("Hired " + playerName
                    + " as " + selectedPosition.getName()
                    + "\nTreasury: " + currentTeam.getTreasury() + "K");

            playerNameField.setText("");
            refreshRosterList();
        } else {
            outputArea.setText("Could not hire player. Check treasury or roster rules.");
        }
    }

    private void fireSelectedPlayer() {
        if (currentTeam == null) {
            outputArea.setText("Create a team first.");
            return;
        }

        Player selectedPlayer = rosterList.getSelectedValue();

        if (selectedPlayer == null) {
            outputArea.setText("Select a player to fire.");
            return;
        }

        boolean fired = teamManager.firePlayer(currentTeam, selectedPlayer);

        if (fired) {
            outputArea.setText("Fired " + selectedPlayer.getName()
                    + "\nTreasury: " + currentTeam.getTreasury() + "K");
            refreshRosterList();
        } else {
            outputArea.setText("Could not fire player.");
        }
    }
    
}