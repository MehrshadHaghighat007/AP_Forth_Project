package org.example.view;

import org.example.controller.ConfigController;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox {
    public CheckBox() {
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
    }
}
