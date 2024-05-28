package org.example.controller;

import org.example.view.FirstFrame;
import org.example.view.FirstPanel;
import org.example.view.MyFrame;
import org.example.view.ParentButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final String text;
    public ButtonListener(ParentButton parentButton) {
        text = parentButton.getText();
        FirstPanel firstPanel = (FirstPanel) parentButton.getParent();
//        Window topLevelWindow = SwingUtilities.getWindowAncestor(firstPanel);
//        System.out.println(topLevelWindow);
//        if (topLevelWindow != null) {
//            topLevelWindow.dispose();
//        }
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (text.equals("Graphic")) {
            new GameManager(ConfigController.getConfigController());
        } else if (text.equals("CLI")) {

        }
    }
}
