package UI;

/*
This will display the Actual Team Like
The Team Name
The Treasury
The Players
The Win/Loss of the team
*/

import Models.Race;
import Models.Team;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class TeamPanel extends JPanel {

    private JTextField teamNameField;
    private JComboBox<Race> raceDropdown;
    private JButton createTeamButton;
    private JTextArea outputArea;

    private TeamCreatedListener listener;

    public TeamPanel(TeamCreatedListener listener) {
        this.listener = listener;

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Team Name:");
        teamNameField = new JTextField();

        JLabel raceLabel = new JLabel("Race:");
        raceDropdown = new JComboBox<>(Race.values());

        createTeamButton = new JButton("Create Team");

        formPanel.add(nameLabel);
        formPanel.add(teamNameField);

        formPanel.add(raceLabel);
        formPanel.add(raceDropdown);

        formPanel.add(createTeamButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(formPanel, BorderLayout.NORTH);
        add(outputArea, BorderLayout.CENTER);

        createTeamButton.addActionListener(e -> createTeam());
    }

    private void createTeam() {
        String teamName = teamNameField.getText();
        Race selectedRace = (Race) raceDropdown.getSelectedItem();

        if (teamName == null || teamName.isEmpty()) {
            outputArea.setText("Please enter a team name.");
            return;
        }

        Team newTeam = new Team(teamName, selectedRace);

        outputArea.setText("Created team:\n");
        outputArea.append("Name: " + newTeam.getName() + "\n");
        outputArea.append("Race: " + newTeam.getRace() + "\n");
        outputArea.append("Treasury: " + newTeam.getTreasury() + "K\n");

        if (listener != null) {
            listener.onTeamCreated(newTeam);
        }
    }
    public void setCurrentTeam(Team team) {
    if (team == null) {
        return;
    }

    teamNameField.setText(team.getName());
    raceDropdown.setSelectedItem(team.getRace());

    outputArea.setText("Loaded team:\n");
    outputArea.append("Name: " + team.getName() + "\n");
    outputArea.append("Race: " + team.getRace() + "\n");
    outputArea.append("Treasury: " + team.getTreasury() + "K\n");
    outputArea.append("Players: " + team.getPlayers().size() + "\n");
}
}