package com.mfa.estool;

import javax.swing.*;

public class MainWindow {

    private JPanel MainPanel;
    private JTextField helloWorldTextField;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainWindow().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
