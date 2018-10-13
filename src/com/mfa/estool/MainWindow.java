package com.mfa.estool;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    private JPanel MainPanel;
    private JTextArea responseField;
    private JTextField urlField;
    private JTextField indexField;
    private JTextField typeField;
    private JTextField idField;
    private JComboBox requestType;
    private JButton sendRequest;
    private JTextArea sourceField;

    public JTextArea getResponseField() {
        return responseField;
    }

    public void setResponseField(JTextArea responseField) {
        this.responseField = responseField;
    }

    public JTextField getUrlField() {
        return urlField;
    }

    public void setUrlField(JTextField urlField) {
        this.urlField = urlField;
    }

    public JTextField getIndexField() {
        return indexField;
    }

    public void setIndexField(JTextField indexField) {
        this.indexField = indexField;
    }

    public JTextField getTypeField() {
        return typeField;
    }

    public void setTypeField(JTextField typeField) {
        this.typeField = typeField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JComboBox getRequestType() {
        return requestType;
    }

    public void setRequestType(JComboBox requestType) {
        this.requestType = requestType;
    }

    public JButton getSendRequest() {
        return sendRequest;
    }

    public void setSendRequest(JButton sendRequest) {
        this.sendRequest = sendRequest;
    }

    public JTextArea getSourceField() {
        return sourceField;
    }

    public void setSourceField(JTextArea sourceField) {
        this.sourceField = sourceField;
    }

    public void fillRequestTypes (MainWindow mainWindow) {
        mainWindow.getRequestType().addItem("GET");
        mainWindow.getRequestType().addItem("POST");
        mainWindow.getRequestType().addItem("DELETE");
        mainWindow.getRequestType().addItem("PATCH");
        mainWindow.getRequestType().addItem("PUT");
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("ES Tool");
        MainWindow mainWindow = new MainWindow();
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.setContentPane(mainWindow.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mainWindow.fillRequestTypes(mainWindow);
    }

}
