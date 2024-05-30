package org.example.view.graphic;

import org.example.controller.listeners.MyKeyListener;
import org.example.model.game.SizeOfTheGame;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame;
    private final org.example.model.game.MyFrame myFrameParameters;
    private MyFrame(Boolean isSelected) {
        myFrameParameters = new org.example.model.game.MyFrame();
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

    public org.example.model.game.MyFrame getMyFrameParameters() {
        return myFrameParameters;
    }
}
