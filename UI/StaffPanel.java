package UI;
//This will display the staff to the user so they can edit it.
import Models.Team;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;

public class StaffPanel extends JPanel {

    private Team currentTeam;

    private JSpinner apothecarySpinner;
    private JSpinner assistantCoachSpinner;
    private JSpinner cheerleaderSpinner;
    private JSpinner dedicatedFansSpinner;
    private JSpinner rerollSpinner;

    private JLabel messageLabel;
    private JButton saveButton;

    public StaffPanel() {
        setLayout(new GridLayout(7, 2, 10, 10));

        apothecarySpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 1, 1)
        );

        assistantCoachSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 20, 1)
        );

        cheerleaderSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 20, 1)
        );

        dedicatedFansSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 6, 1)
        );

        rerollSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 8, 1)
        );

        saveButton = new JButton("Save Changes");
        messageLabel = new JLabel("Select or create a team first.");

        add(new JLabel("Apothecary:"));
        add(apothecarySpinner);

        add(new JLabel("Assistant Coaches:"));
        add(assistantCoachSpinner);

        add(new JLabel("Cheerleaders:"));
        add(cheerleaderSpinner);

        add(new JLabel("Dedicated Fans:"));
        add(dedicatedFansSpinner);

        add(new JLabel("Rerolls:"));
        add(rerollSpinner);

        add(messageLabel);
        add(saveButton);

        saveButton.addActionListener(e -> saveChanges());

        setControlsEnabled(false);
    }

    private void saveChanges() {
        if (currentTeam == null) {
            messageLabel.setText("Create or load a team first.");
            return;
        }

        int apothecaryCount =
                (int) apothecarySpinner.getValue();

        int assistantCoachCount =
                (int) assistantCoachSpinner.getValue();

        int cheerleaderCount =
                (int) cheerleaderSpinner.getValue();

        int dedicatedFansCount =
                (int) dedicatedFansSpinner.getValue();

        int rerollCount =
                (int) rerollSpinner.getValue();

        currentTeam.setHasApothecary(apothecaryCount == 1);
        currentTeam.setAssistants(assistantCoachCount);
        currentTeam.setCheerleaders(cheerleaderCount);
        currentTeam.setFanFactor(dedicatedFansCount);
        currentTeam.setRerolls(rerollCount);

        messageLabel.setText("Staff changes saved.");
    }

    public void setCurrentTeam(Team team) {
        this.currentTeam = team;

        if (currentTeam == null) {
            resetControls();
            setControlsEnabled(false);
            messageLabel.setText("Select or create a team first.");
            return;
        }

        apothecarySpinner.setValue(
                currentTeam.hasApothecary() ? 1 : 0
        );

        assistantCoachSpinner.setValue(
                currentTeam.getAssistants()
        );

        cheerleaderSpinner.setValue(
                currentTeam.getCheerleaders()
        );

        dedicatedFansSpinner.setValue(
                currentTeam.getFanFactor()
        );

        rerollSpinner.setValue(
                currentTeam.getRerolls()
        );

        setControlsEnabled(true);

        messageLabel.setText(
                "Editing staff for: " + currentTeam.getName()
        );
    }

    private void resetControls() {
        apothecarySpinner.setValue(0);
        assistantCoachSpinner.setValue(0);
        cheerleaderSpinner.setValue(0);
        dedicatedFansSpinner.setValue(0);
        rerollSpinner.setValue(0);
    }

    private void setControlsEnabled(boolean enabled) {
        apothecarySpinner.setEnabled(enabled);
        assistantCoachSpinner.setEnabled(enabled);
        cheerleaderSpinner.setEnabled(enabled);
        dedicatedFansSpinner.setEnabled(enabled);
        rerollSpinner.setEnabled(enabled);
        saveButton.setEnabled(enabled);
    }
}