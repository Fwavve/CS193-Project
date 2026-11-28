package com.startupmanager;
import javax.swing.*;
import java.awt.*;
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
        JButton addButton = new JButton("Add Application");
        addButton.addActionListener(e -> addApplication());
        appListPanel = new JPanel();
        appListPanel.setLayout(new BoxLayout(appListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(appListPanel);
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    private void addApplication() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Application");
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            StartupApp app = new StartupApp(
                    selectedFile.getName(),
                    selectedFile.getAbsolutePath()
            );
            applications.add(app);
            displayApplication(app);
        }
    }

    private void displayApplication(StartupApp app) {
        JPanel appPanel = new JPanel(new BorderLayout(10, 5));
        appPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel nameLabel = new JLabel(app.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel pathLabel = new JLabel(app.getExecutablePath());
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(nameLabel);
        textPanel.add(pathLabel);
        appPanel.add(textPanel, BorderLayout.CENTER);
        appPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 65)
        );

        appListPanel.add(appPanel);
        appListPanel.revalidate();
        appListPanel.repaint();
    }
}
