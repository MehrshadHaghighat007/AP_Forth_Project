package org.example.view;

import org.example.controller.ButtonListener;
import org.example.controller.ConfigController;

import javax.swing.*;

public class FirstPanel extends JPanel {

    public FirstPanel(FirstFrame firstFrame) {
        setLayout(null);
        setBounds(ConfigController.getConfigController().getConfig().getCoordinatesOfThePanel().get("x"), ConfigController.getConfigController().getConfig().getCoordinatesOfThePanel().get("y"), ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("width"), ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("height"));
        add(new Label());
        add(new ParentButton("CLI", ConfigController.getConfigController().getConfig().getButtonsParameters().get("CLI").get("x")));
        ParentButton parentButton = new ParentButton("Graphic", ConfigController.getConfigController().getConfig().getButtonsParameters().get("graphic").get("x"));
        parentButton.addActionListener(new ButtonListener(parentButton));
        add(new ParentButton("Graphic", ConfigController.getConfigController().getConfig().getButtonsParameters().get("graphic").get("x")));
        add(new CheckBox());
        add(new WidthAndHeightLabel("Width :", ConfigController.getConfigController().getConfig().getwHParameters().get("width").get("y")));
        add(new WidthAndHeightLabel("Height :", ConfigController.getConfigController().getConfig().getwHParameters().get("height").get("y")));
        add(new TextFields(ConfigController.getConfigController().getConfig().getTextFieldParameters().get("width").get("y")));
        add(new TextFields(ConfigController.getConfigController().getConfig().getTextFieldParameters().get("height").get("y")));
        firstFrame.add(this);
    }
}
