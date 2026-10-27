package UI;
//This is a panel for editing a single player, including there Level, spp, and other relevant things of that nature.

import Models.Player;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;


public class SingleEditPanel extends JPanel {

    private Player currentPlayer;

    private JComboBox<Player> playerSelect;
    private JTextField nameField;
    private JSpinner jerseySpinner;
    private JSpinner sppSpinner;

    private JButton saveButton;

    private Runnable playerUpdatedListener;

    public SingleEditPanel() {
        setLayout(new GridLayout(5, 2, 10, 10));

        //This is supposed to create a dropdown menu for selecting a player on the team to be edited
        //TODO Populate the playerSelect dropdown with players from the current team
        playerSelect = new JComboBox<>();
        add(new JLabel("Select Player:"));
        add(playerSelect);
        playerSelect.addActionListener(e -> {
            Player selectedPlayer = (Player) playerSelect.getSelectedItem();
            setPlayer(selectedPlayer);
        });

        //This is used to rename the player
        nameField = new JTextField();
    
        //this is used to set or reset the jersey number of the player
        jerseySpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 99, 1)
        );

        //this is used to set or reset the SPP of the player
        sppSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 999, 1)
        );
        //Suprise suprise this is used to put the save button on the page
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

    //This method is used to set the current player for editing
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
    //This below is the method that is used to manage the act of saving the changes that are to the character
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
