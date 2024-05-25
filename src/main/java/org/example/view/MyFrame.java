package org.example.view;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame;
    private MyFrame() {

    }

    public static MyFrame getMyFrame() {
        if (myFrame == null) {
            myFrame = new MyFrame();
        }
        return myFrame;
    }
}
