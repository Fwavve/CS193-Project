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
        SwingUtilities.invokeLater(GUI::new);
    }
}
