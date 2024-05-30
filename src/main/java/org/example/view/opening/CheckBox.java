package org.example.view.opening;

import org.example.controller.listeners.CheckBoxListener;
import org.example.controller.game.ConfigController;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox {
    private static CheckBox checkBox = null;
    private CheckBox() {
        setBounds(ConfigController.getConfigController().getConfig().getCheckBoxParameters().get("location").get("x"), ConfigController.getConfigController().getConfig().getCheckBoxParameters().get("location").get("y"), ConfigController.getConfigController().getConfig().getCheckBoxParameters().get("size").get("width"), ConfigController.getConfigController().getConfig().getCheckBoxParameters().get("size").get("height"));
        setText("Oblique movement allowed :");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBackground(new Color(1, 2, 3));
        setForeground(new Color(100, 200, 125));
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.TOP);
        setFocusable(false);
        setOpaque(true);
        addActionListener(new CheckBoxListener(this));
    }

    public static CheckBox getCheckBox() {
        if (checkBox == null) {
            checkBox = new CheckBox();
        }
        return checkBox;
    }
}
