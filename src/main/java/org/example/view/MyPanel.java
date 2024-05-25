package org.example.view;

import org.example.controller.PuzzlePiece;
import org.example.model.Size;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private static MyPanel panelInstance;
    private final org.example.model.MyPanel myPanelParameters;

    private MyPanel() {
        myPanelParameters = new org.example.model.MyPanel();
        Size size = new Size();
        this.setSize(size.getWidthGame(), size.getHeightGame());
        this.setLocation(size.getxCoordinate(), size.getyCoordinate());
    }

    public static MyPanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
            return panelInstance;
        }
        return panelInstance;
    }

//    public void swapPieces(int i, int j) {
//
//
//        if (gameFinished()) {
//            gameState = "finished";
//        }
//    }
//
//    public boolean gameFinished() {
//        for (int i = 0; i < 9; i++) {
//            int pieceIdentifier = puzzlePieces.get(i).getPuzzlePieceParameters().getPieceNumber();
//            if (pieceIdentifier == 8) {
//                continue;
//            }
//
//            if (pieceIdentifier != i) {
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePiece piece : myPanelParameters.getPuzzlePieces()) {
            g.drawImage(piece.getPuzzlePieceParameters().getImg(), piece.getPuzzlePieceParameters().getLocation().getX(), piece.getPuzzlePieceParameters().getLocation().getY(), (int) this.getSize().getWidth() / 3, (int) this.getSize().getHeight() / 3, null);
        }
    }

    public org.example.model.MyPanel getMyPanelParameters() {
        return myPanelParameters;
    }
}
