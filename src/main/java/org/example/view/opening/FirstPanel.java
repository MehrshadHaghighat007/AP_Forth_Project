package org.example.view.opening;
import org.example.controller.game.ConfigController;

import javax.swing.*;

public class FirstPanel extends JPanel {
    private static FirstPanel firstPanel = null;

    private FirstPanel() {
        setLayout(null);
        setBounds(ConfigController.getConfigController().getConfig().getCoordinatesOfThePanel().get("x"), ConfigController.getConfigController().getConfig().getCoordinatesOfThePanel().get("y"), ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("width"), ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("height"));
        add(Label.getLabel());
        add(new ParentButton("CLI", ConfigController.getConfigController().getConfig().getButtonsParameters().get("CLI").get("x")));
        add(new ParentButton("Graphic", ConfigController.getConfigController().getConfig().getButtonsParameters().get("graphic").get("x")));
        add(CheckBox.getCheckBox());
    }

    public static FirstPanel getFirstPanel() {
        if (firstPanel == null) {
            firstPanel = new FirstPanel();
        }
        return firstPanel;
    }
}
