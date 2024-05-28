package org.example.view;

import org.example.controller.ConfigController;
import org.example.controller.TextFieldActionListener;

import javax.swing.*;
import java.awt.*;

public class TextFields extends JTextField {
    protected TextFields(Integer yCoordinate) {
        setBounds(ConfigController.getConfigController().getConfig().getTextFieldParameters().get("bounds").get("x"), yCoordinate, ConfigController.getConfigController().getConfig().getTextFieldParameters().get("bounds").get("width"), ConfigController.getConfigController().getConfig().getTextFieldParameters().get("bounds").get("height"));
        setForeground(new Color(100, 200, 125));
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        setHorizontalAlignment(SwingConstants.CENTER);
//        addActionListener(new TextFieldActionListener(this));
        setOpaque(true);
    }
}
