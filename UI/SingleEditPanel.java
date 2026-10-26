package UI;
//This is a panel for editing a single player, including there Level, spp, and other relevant things of that nature.

import Models.Player;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;

public class SingleEditPanel extends JPanel {

    private Player currentPlayer;
    private SingleEditPanel singleEditPanel;
    private JTextField nameField;
    private JSpinner jerseySpinner;
    private JSpinner sppSpinner;

    private JButton saveButton;

    private Runnable playerUpdatedListener;

    public SingleEditPanel() {
        setLayout(new GridLayout(4, 2, 10, 10));

        nameField = new JTextField();
        singleEditPanel = this;
    

        jerseySpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 99, 1)
        );

        sppSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 999, 1)
        );

        saveButton = new JButton("Save Player Changes");

        add(new JLabel("Player Name:"));
        add(nameField);

        add(new JLabel("Jersey Number:"));
        add(jerseySpinner);

        add(new JLabel("SPP:"));
        add(sppSpinner);

        add(new JLabel());
        add(saveButton);

        saveButton.addActionListener(e -> saveChanges());

        setFieldsEnabled(false);


        
    }

    

    public void setPlayer(Player player) {
        this.currentPlayer = player;

        if (player == null) {
            clearFields();
            setFieldsEnabled(false);
            return;
        }

        nameField.setText(player.getName());
        jerseySpinner.setValue(player.getJerseyNumber());
        sppSpinner.setValue(player.getSpp());

        setFieldsEnabled(true);
    }

    private void saveChanges() {
        if (currentPlayer == null) {
            return;
        }

        String newName = nameField.getText().trim();
        int newJerseyNumber = (int) jerseySpinner.getValue();
        int newSPP = (int) sppSpinner.getValue();

        if (newName.isEmpty()) {
            return;
        }

        currentPlayer.setName(newName);
        currentPlayer.setJerseyNumber(newJerseyNumber);
        currentPlayer.setSpp(newSPP);

        if (playerUpdatedListener != null) {
            playerUpdatedListener.run();
        }
    }

    public void setPlayerUpdatedListener(Runnable listener) {
        this.playerUpdatedListener = listener;
    }

    private void clearFields() {
        nameField.setText("");
        jerseySpinner.setValue(1);
        sppSpinner.setValue(0);
    }

    private void setFieldsEnabled(boolean enabled) {
        nameField.setEnabled(enabled);
        jerseySpinner.setEnabled(enabled);
        sppSpinner.setEnabled(enabled);
        saveButton.setEnabled(enabled);
    }
}
