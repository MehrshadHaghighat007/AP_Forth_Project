package org.example.view;

import org.example.controller.ButtonListener;
import org.example.controller.ConfigController;

import javax.swing.*;
import java.awt.*;

public class ParentButton extends JButton {
    protected ParentButton(String text, Integer xCoordinate) {
        setBounds(xCoordinate, ConfigController.getConfigController().getConfig().getButtonsParameters().get("bounds").get("y"), ConfigController.getConfigController().getConfig().getButtonsParameters().get("bounds").get("width"), ConfigController.getConfigController().getConfig().getButtonsParameters().get("bounds").get("height"));
        setText(text);
        setBackground(new Color(1, 2, 3));
        setForeground(new Color(100, 200, 125));
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        setFocusable(false);
        addActionListener(new ButtonListener(this));
        setOpaque(true);
    }
}
