package org.example.view;

import org.example.controller.ConfigController;
import org.example.model.PuzzlePiece;
import org.example.model.SizeOfTheGame;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private static MyPanel panelInstance;
    private final org.example.model.MyPanel myPanelParameters;
    private final SizeOfTheGame sizeOfTheGame;

    private MyPanel() {
        myPanelParameters = new org.example.model.MyPanel();
        sizeOfTheGame = new SizeOfTheGame();
        this.setSize(sizeOfTheGame.getWidthGame(), sizeOfTheGame.getHeightGame());
        this.setLocation(sizeOfTheGame.getxCoordinate(), sizeOfTheGame.getyCoordinate());
    }

    public static MyPanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
            return panelInstance;
        }
        return panelInstance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePiece piece : myPanelParameters.getPuzzlePieces()) {
            System.out.println("OK");
            g.drawImage(piece.getImg(), piece.getLocation().getX(), piece.getLocation().getY(), (int) this.getSize().getWidth() / ConfigController.getConfigController().getConfig().getTiles().get("width"), (int) this.getSize().getHeight() / ConfigController.getConfigController().getConfig().getTiles().get("height"), null);
        }
    }

    public org.example.model.MyPanel getMyPanelParameters() {
        return myPanelParameters;
    }

    public SizeOfTheGame getSizeOfTheGame() {
        return sizeOfTheGame;
    }
}
