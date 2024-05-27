package org.example.model;

import org.example.controller.ConfigController;
import org.example.view.FirstPanel;

public class FirstFrame {
    private static final int WIDTH = ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("width");
    private static final int HEIGHT = ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("height");
    private static final FirstPanel firstPanel = FirstPanel.getFirstPanel();

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static FirstPanel getFirstPanel() {
        return firstPanel;
    }
}
