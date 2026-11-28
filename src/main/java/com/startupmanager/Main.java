package com.startupmanager;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Main {
    public static void main(String[] args) {
        //starts the GUI
        //test
        StartupApp chrome = new StartupApp(
                "Google Chrome",
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
        );
        LaunchApp launcher = new LaunchApp();
        try {
            launcher.launch(chrome);
            System.out.println("Chrome launched successfully!");
        } catch (IOException e) {
            System.out.println("Could not launch Chrome: " + e.getMessage());
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
    private static void createWindow() {
        JFrame frame = new JFrame("Startup Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        JLabel welcomeLabel = new JLabel(
                "Welcome to Startup Manager!",
                SwingConstants.CENTER
        );
        frame.add(welcomeLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
