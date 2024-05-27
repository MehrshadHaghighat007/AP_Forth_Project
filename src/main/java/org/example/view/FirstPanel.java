package org.example.view;

import javax.swing.*;

public class FirstPanel extends JPanel {
    private static FirstPanel firstPanel = null;
    private FirstPanel() {
        setBounds(org.example.model.FirstPanel.getxCoordinate(), org.example.model.FirstPanel.getyCoordinate(), org.example.model.FirstPanel.getWIDTH(), org.example.model.FirstPanel.getHEIGHT());
        add(org.example.model.FirstPanel.getLABEL());
    }

    public static FirstPanel getFirstPanel() {
        if (firstPanel == null) {
            firstPanel = new FirstPanel();
        }
        return firstPanel;
    }
}
