package com.mfa.estool;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    private JPanel MainPanel;
    private JTextArea textArea1;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {

        JFrame frame = new JFrame("ES Tool");
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.setContentPane(new MainWindow().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
