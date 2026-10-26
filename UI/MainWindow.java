//RUN THIS FILE TO RUN THE PROGRAM
package UI;

import Models.Team;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;

import Storage.Data_Storage;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFileChooser;

public class MainWindow extends JFrame {

    private Team currentTeam; 
    private TeamPanel teamPanel;
    private PlayerPanel playerPanel;
    private SingleEditPanel SingleEditPanel;

    private JButton saveButton;
    private JButton loadButton;

    public MainWindow() {
        setTitle("OrcManager");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        playerPanel = new PlayerPanel();
        SingleEditPanel = new SingleEditPanel();
        

        teamPanel = new TeamPanel(team -> {
            currentTeam = team;
            playerPanel.setCurrentTeam(currentTeam);
        });

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Team Selector", teamPanel);
        tabs.addTab("Team Editor", playerPanel);
        tabs.addTab("Player Editor", SingleEditPanel);

        add(tabs, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

saveButton = new JButton("Save Team");
loadButton = new JButton("Load Team");

buttonPanel.add(saveButton);
buttonPanel.add(loadButton);

saveButton.addActionListener(e -> saveCurrentTeam());
loadButton.addActionListener(e -> loadTeam());

add(buttonPanel, BorderLayout.NORTH);
add(tabs, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }

    //This method is used to save the current team to a file.
    private void saveCurrentTeam() {
    if (currentTeam == null) {
        System.out.println("No team to save.");
        return;
    }

    JFileChooser fileChooser = new JFileChooser();

    int result = fileChooser.showSaveDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        boolean saved = Data_Storage.saveTeam(currentTeam, filePath);

        if (saved) {
            System.out.println("Team saved.");
        } else {
            System.out.println("Team could not be saved.");
        }
    }
}
//This method is used to load a team file.
private void loadTeam() {
    teamPanel.setCurrentTeam(currentTeam);
    JFileChooser fileChooser = new JFileChooser();

    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        Team loadedTeam = Data_Storage.loadTeam(filePath);

        if (loadedTeam != null) {
            currentTeam = loadedTeam;
            playerPanel.setCurrentTeam(currentTeam);

            System.out.println("Team loaded: " + currentTeam.getName());
        } else {
            System.out.println("Team could not be loaded.");
        }
    }
}
}