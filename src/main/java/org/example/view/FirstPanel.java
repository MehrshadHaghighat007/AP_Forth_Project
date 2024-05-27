package org.example.view;

import org.example.controller.ConfigController;

import javax.swing.*;

public class FirstPanel extends JPanel {
    private static FirstPanel firstPanel = null;
    private FirstPanel() {
        setLayout(null);
        setBounds(org.example.model.FirstPanel.getxCoordinate(), org.example.model.FirstPanel.getyCoordinate(), org.example.model.FirstPanel.getWIDTH(), org.example.model.FirstPanel.getHEIGHT());
        add(org.example.model.FirstPanel.getLABEL());
        add(new ParentButton("CLI", ConfigController.getConfigController().getConfig().getButtonsParameters().get("CLI").get("x")));
        add(new ParentButton("graphic", ConfigController.getConfigController().getConfig().getButtonsParameters().get("graphic").get("x")));
        add(CheckBox.getCheckBox());
    }

    public static FirstPanel getFirstPanel() {
        if (firstPanel == null) {
            firstPanel = new FirstPanel();
        }
        return firstPanel;
    }
}
