package org.example.view.graphic;

import org.example.controller.game.ConfigController;
import org.example.model.game.PuzzlePiece;
import org.example.model.game.SizeOfTheGame;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private static MyPanel panelInstance;
    private final org.example.model.game.MyPanel myPanelParameters;
    private final SizeOfTheGame sizeOfTheGame;

    private MyPanel() {
        myPanelParameters = new org.example.model.game.MyPanel();
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
            g.drawImage(piece.getImg(), piece.getLocation().getX(), piece.getLocation().getY(), (int) this.getSize().getWidth() / ConfigController.getConfigController().getConfig().getTiles().get("width"), (int) this.getSize().getHeight() / ConfigController.getConfigController().getConfig().getTiles().get("height"), null);
        }
    }

    public org.example.model.game.MyPanel getMyPanelParameters() {
        return myPanelParameters;
    }

    public SizeOfTheGame getSizeOfTheGame() {
        return sizeOfTheGame;
    }
}
