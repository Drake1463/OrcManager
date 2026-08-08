//RUN THIS FILE TO RUN THE PROGRAM
package UI;

import Models.Team;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

public class MainWindow extends JFrame {

    private Team currentTeam; 
    private TeamPanel teamPanel;
    private PlayerPanel playerPanel;

    public MainWindow() {
        setTitle("OrcManager");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        playerPanel = new PlayerPanel();

        teamPanel = new TeamPanel(team -> {
            currentTeam = team;
            playerPanel.setCurrentTeam(currentTeam);
        });

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Team", teamPanel);
        tabs.addTab("Players", playerPanel);

        add(tabs, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }
}