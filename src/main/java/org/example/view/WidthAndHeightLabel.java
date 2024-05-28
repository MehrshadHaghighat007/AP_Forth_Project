package org.example.view;

import org.example.controller.ConfigController;

import javax.swing.*;
import java.awt.*;

public class WidthAndHeightLabel extends JLabel {
    protected WidthAndHeightLabel(String text, Integer yCoordinate) {
        setBounds(ConfigController.getConfigController().getConfig().getwHParameters().get("bounds").get("x"), yCoordinate, ConfigController.getConfigController().getConfig().getwHParameters().get("bounds").get("width"), ConfigController.getConfigController().getConfig().getwHParameters().get("bounds").get("height"));
        setText(text);
        setBackground(new Color(1, 2, 3));
        setForeground(new Color(100, 200, 125));
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFocusable(false);
        setOpaque(true);
    }
}
