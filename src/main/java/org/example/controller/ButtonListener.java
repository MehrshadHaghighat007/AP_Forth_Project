package org.example.controller;

import org.example.view.FirstFrame;
import org.example.view.FirstPanel;
import org.example.view.MyFrame;
import org.example.view.ParentButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ButtonListener implements ActionListener {

    private final ParentButton parentButton;

    public ButtonListener(ParentButton parentButton) {
        this.parentButton = parentButton;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        run();
    }

    private void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                FirstPanel firstPanel = (FirstPanel) parentButton.getParent();
                Window topLevelWindow = SwingUtilities.getWindowAncestor(firstPanel);
                if (topLevelWindow != null) {
                    topLevelWindow.dispose();
                }
                if (parentButton.getText().equals("Graphic")) {
                    System.out.println(CheckBoxListener.isIsSelected());
                    new GameManager(CheckBoxListener.isIsSelected());
                }
                if (parentButton.getText().equals("CLI")) {

                }
            }
        }, 0);
    }

}
