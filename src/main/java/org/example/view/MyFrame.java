package org.example.view;

import org.example.controller.MyKeyListener;
import org.example.model.SizeOfTheGame;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame;
    private final org.example.model.MyFrame myFrameParameters;
    private MyFrame(Boolean isSelected) {
        myFrameParameters = new org.example.model.MyFrame();
        SizeOfTheGame sizeOfTheGame = new SizeOfTheGame();
        setSize(sizeOfTheGame.getWidthGame(), sizeOfTheGame.getHeightGame());
        setLocation(sizeOfTheGame.getxCoordinate(), sizeOfTheGame.getyCoordinate());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(myFrameParameters.getMyPanel());
        addKeyListener(new MyKeyListener(this, isSelected));
        setVisible(true);
    }

    public static MyFrame getMyFrame(Boolean isSelected) {
        if (myFrame == null) {
            myFrame = new MyFrame(isSelected);
        }
        return myFrame;
    }

    public org.example.model.MyFrame getMyFrameParameters() {
        return myFrameParameters;
    }
}
