
package com.startupmanager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

public class GUI {
    private JFrame frame;
    private JPanel appListPanel;
    private ArrayList<StartupApp> applications;
    public GUI() {
        applications = new ArrayList<>();
        createWindow();
    }
    private void createWindow() {
        frame = new JFrame("Startup Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));
        JLabel title = new JLabel("Startup Manager", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JButton addButton= new JButton("Add Application");
        addButton.addActionListener(e -> addApplication());
        appListPanel = new JPanel();
        appListPanel.setLayout(new BoxLayout(appListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(appListPanel);
        JPanel topPanel =new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane,BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addApplication() {
        JFileChooser fileChooser =new JFileChooser();
        fileChooser.setDialogTitle("Select an Application");
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            StartupApp app = new StartupApp(selectedFile.getName(), selectedFile.getAbsolutePath());
            applications.add(app);
            displayApplication(app);
        }
    }
    private void displayApplication(StartupApp app) {
        JPanel appPanel = new JPanel(new BorderLayout(10, 5));

        appPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel nameLabel = new JLabel(app.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel pathLabel= new JLabel(app.getExecutablePath());
        JPanel textPanel= new JPanel(new GridLayout(2, 1));
        textPanel.add(nameLabel);
        textPanel.add(pathLabel);

        //creates a check box for if the app will be enabled or not
        JCheckBox enabledCheckBox = new JCheckBox("Enabled", app.isEnabled());
        enabledCheckBox.addActionListener(e -> app.setEnabled(enabledCheckBox.isSelected()));

        //create remove button
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            applications.remove(app);
            appListPanel.remove(appPanel);
            appListPanel.revalidate();
            appListPanel.repaint();
        });

        JPanel controlPanel =new JPanel();
        controlPanel.add(enabledCheckBox);
        controlPanel.add(removeButton);
        appPanel.add(textPanel, BorderLayout.CENTER);
        appPanel.add(controlPanel, BorderLayout.EAST);

        appPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        appListPanel.add(appPanel);
        appListPanel.revalidate();
        appListPanel.repaint();
    }
}
