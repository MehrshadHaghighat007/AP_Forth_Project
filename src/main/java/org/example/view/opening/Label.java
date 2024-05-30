package org.example.view.opening;

import org.example.controller.game.ConfigController;


import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    private static Label label = null;
    private Label() {
        setBounds(ConfigController.getConfigController().getConfig().getLabelParameters().get("location").get("x"), ConfigController.getConfigController().getConfig().getLabelParameters().get("location").get("y"), ConfigController.getConfigController().getConfig().getLabelParameters().get("size").get("width"), ConfigController.getConfigController().getConfig().getLabelParameters().get("size").get("height"));
        setText("Choose the mode of the game :");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBackground(new Color(1, 2, 3));
        setForeground(new Color(100, 200, 125));
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        setFocusable(true);
        setOpaque(true);
    }

    public static Label getLabel() {
        if (label == null) {
            label = new Label();
        }
        return label;
    }
}
