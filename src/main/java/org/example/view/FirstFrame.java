package org.example.view;

import javax.swing.*;

public class FirstFrame extends JFrame {
    private static FirstFrame firstFrame = null;
    private FirstFrame() {
        setSize(org.example.model.FirstFrame.getWIDTH(), org.example.model.FirstFrame.getHEIGHT());
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        add(org.example.model.FirstFrame.getFirstPanel());
        setVisible(true);
    }

    public static FirstFrame getFirstFrame() {
        if (firstFrame == null) {
            firstFrame = new FirstFrame();
        }
        return firstFrame;
    }
}
