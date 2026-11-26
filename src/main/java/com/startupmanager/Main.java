package com.startupmanager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Main {
    public static void main(String[] args) {
        //Temp test
        /*
        StartupApp chrome = new StartupApp(
                "Google Chrome",
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
        );
        System.out.println(chrome.getName());
        System.out.println(chrome.isEnabled());
        chrome.setEnabled(false);
        System.out.println(chrome.isEnabled());

         */
        //starts the GUI
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
