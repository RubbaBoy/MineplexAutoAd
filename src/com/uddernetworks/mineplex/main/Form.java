package com.uddernetworks.mineplex.main;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Form {
    private JTextPane mineplexAutoAdWatcherTextPane;
    private JTextField usernameTextField;
    private JButton startButton;
    private JButton stopButton;
    private JTextPane running;
    private JPanel panel;
    private JTextPane timesWatched0TextPane;

    private int times = 0;

    public Form() {
        startButton.addActionListener(e -> {
            if (usernameTextField.getText().equals("") || usernameTextField == null) {
                JOptionPane.showMessageDialog(null, "The username box is empty!");
            } else {
                if (!Main.t.isAlive()) {
                    Main.t.start();
                    Main.name = usernameTextField.getText();
                    Main.running = true;
                    running.setText("Running: True");
                } else {
                    Main.t.start();
                    Main.name = usernameTextField.getText();
                    Main.running = true;
                    running.setText("Running: True");
                }
            }
        });

        stopButton.addActionListener(e -> {
            Main.running = false;
            JOptionPane.showMessageDialog(null, "Stopped app");
            System.exit(0);
        });
    }

    public void addWatch() {
        times++;

        timesWatched0TextPane.setText("Times Watched: " + times);
    }

    public void main() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Mineplex Auto Ad");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(37,41,44));
        frame.pack();
        frame.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        try {
            URL url = new URL("http://pbs.twimg.com/profile_images/667179736200830977/PYD-uWwL_normal.jpg");
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image img = kit.createImage(url);
            frame.setIconImage(img);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}