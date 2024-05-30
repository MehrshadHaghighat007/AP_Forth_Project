package org.example.view.opening;

import org.example.controller.game.ConfigController;

import javax.swing.*;

public class FirstFrame extends JFrame {
    public FirstFrame() {
        setSize(ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("width"), ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("height"));
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        add(FirstPanel.getFirstPanel());
        setVisible(true);
    }
}
