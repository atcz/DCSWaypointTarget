package main.UI;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GUI {
    static private JPanel gui;
    static private JFrame frame;
    static private Crosshair crosshair;
    static private JButton displayTargetButton;
    static private JButton removeTargetButton;

    public static void show(){
        FlatDarkLaf.setup();
        crosshair = new Crosshair();
        gui = new JPanel(new GridLayout(0, 1, 10, 10));
        gui.setPreferredSize(new Dimension(150,120));
        gui.setBorder(new EmptyBorder(10, 10, 10, 10));
        displayTargetButton = new JButton("Display target");
        removeTargetButton = new JButton("Remove target");

        displayTargetButton.addActionListener(e -> {
            displayState();
        });
        removeTargetButton.addActionListener(e -> {
            standbyState();
        });

        gui.add(displayTargetButton);
        gui.add(removeTargetButton);

        displayState();
        frame = new JFrame("DCS Waypoint Target");
        frame.add(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setFocusableWindowState(true);
        frame.pack();
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(0, dim.height-frame.getHeight());
        frame.setVisible(true);
    }

    private static void displayState(){
        crosshair.show();
//        textArea.setText("Target displayed!");
        displayTargetButton.setEnabled(false);
        removeTargetButton.setEnabled(true);
    }

    private static void standbyState(){
        crosshair.hide();
//        textArea.setText("");
        displayTargetButton.setEnabled(true);
        removeTargetButton.setEnabled(false);
    }
}