package org.example.view;

import org.example.MyKeyListener;
import org.example.model.Size;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame;
    private final org.example.model.MyFrame myFrameParameters;

    private MyFrame() {
        myFrameParameters = new org.example.model.MyFrame();
        Size size = new Size();
        setSize(size.getWidthGame(), size.getHeightGame());
        setLocation(size.getxCoordinate(), size.getyCoordinate());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(myFrameParameters.getMyPanel());
        addKeyListener(new MyKeyListener(this));
        setVisible(true);
    }

    public static MyFrame getMyFrame() {
        if (myFrame == null) {
            myFrame = new MyFrame();
        }
        return myFrame;
    }

    public org.example.model.MyFrame getMyFrameParameters() {
        return myFrameParameters;
    }

}
