package org.example.view;

import org.example.MyKeyListener;
import org.example.model.SizeOfTheGame;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame;
    private final org.example.model.MyFrame myFrameParameters;
    private final SizeOfTheGame sizeOfTheGame;

    private MyFrame() {
        myFrameParameters = new org.example.model.MyFrame();
        sizeOfTheGame = new SizeOfTheGame();
        setSize(sizeOfTheGame.getWidthGame(), sizeOfTheGame.getHeightGame());
        setLocation(sizeOfTheGame.getxCoordinate(), sizeOfTheGame.getyCoordinate());
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

    public SizeOfTheGame getSizeOfTheGame() {
        return sizeOfTheGame;
    }
}
