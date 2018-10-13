package com.mfa.estool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    private JPanel MainPanel;
    private JTextArea responseField;
    private JTextField hostnameField;
    private JTextField indexField;
    private JTextField typeField;
    private JTextField idField;
    private JComboBox requestType;
    private JButton sendRequest;
    private JTextArea sourceField;
    private JTextField portField;
    private JTextField schemeField;

    public JTextArea getResponseField() {
        return responseField;
    }

    public void setResponseField(JTextArea responseField) {
        this.responseField = responseField;
    }

    public JTextField getHostnameField() {
        return hostnameField;
    }

    public void setHostnameField(JTextField hostnameField) {
        this.hostnameField = hostnameField;
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

    public JTextField getPortField() {
        return portField;
    }

    public void setPortField(JTextField portField) {
        this.portField = portField;
    }

    public JTextField getSchemeField() {
        return schemeField;
    }

    public void setSchemeField(JTextField schemeField) {
        this.schemeField = schemeField;
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
        mainWindow.getRequestType().addItem("INDEX");
        mainWindow.getRequestType().addItem("GET");
        mainWindow.getRequestType().addItem("EXISTS");
        mainWindow.getRequestType().addItem("DELETE");
        mainWindow.getRequestType().addItem("UPDATE");
    }


    public void sendRequest () {
        String requestType = getRequestType().getSelectedItem().toString();
        ESRestHighLevelClient esRestHighLevelClient = new ESRestHighLevelClient();
        esRestHighLevelClient.createNewClient(getHostnameField().getText(), Integer.parseInt(getPortField().getText()), getSchemeField().getText());

        switch (requestType) {
            case "INDEX":
                String response = esRestHighLevelClient.sendIndexRequest(getIndexField().getText(), getTypeField().getText(), getIdField().getText(), getSourceField().getText());
                getResponseField().append(response);
                break;
        }

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("ES Tool");
        final MainWindow mainWindow = new MainWindow();
        final ESRestHighLevelClient esRestHighLevelClient = new ESRestHighLevelClient();
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.setContentPane(mainWindow.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mainWindow.fillRequestTypes(mainWindow);

        mainWindow.getSendRequest().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.sendRequest();
            }
        });
    }

}
