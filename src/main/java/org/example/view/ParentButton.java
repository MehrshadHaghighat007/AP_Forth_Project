package org.example.view;

import javax.swing.*;

public class ParentButton extends JButton {
    private static ParentButton parentButton = null;
    private ParentButton(String text, Integer xCoordinate) {
        setBounds();
    }

    public static ParentButton getParentButton(String text, Integer xCoordinate) {
        if (parentButton == null) {
            parentButton = new ParentButton(text, xCoordinate);
        }
        return parentButton;
    }
}
