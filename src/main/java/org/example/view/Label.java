package org.example.view;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    private static Label label = null;

    private Label() {
        setBounds(org.example.model.Label.getxCoordinate(), org.example.model.Label.getyCoordinate(), org.example.model.Label.getWIDTH(), org.example.model.Label.getHEIGHT());
        setText("Choose the mode of the game :");
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
