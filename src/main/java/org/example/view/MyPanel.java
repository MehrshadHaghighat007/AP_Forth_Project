package org.example.view;

import org.example.model.PuzzlePiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    private static MyPanel panelInstance;
    public ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    public int missingPiece = 0;
    public String gameState = "#";

    private MyPanel() {

    }

    public static MyPanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
            return panelInstance;
        }
        return panelInstance;
    }

    public void swapPieces(int i, int j) {
        PuzzlePiece copy = this.puzzlePieces.get(i).getClone();
        puzzlePieces.get(i).setImg(puzzlePieces.get(j).getImg());
        puzzlePieces.get(i).setPieceNumber(puzzlePieces.get(j).getPieceNumber());
        puzzlePieces.get(j).setImg(copy.getImg());
        puzzlePieces.get(j).setPieceNumber(copy.getPieceNumber());

        if (gameFinished()) {
            gameState = "finished";
        }
    }

    public boolean gameFinished() {
        for (int i = 0; i < 9; i++) {
            int pieceIdentifier = puzzlePieces.get(i).getPieceNumber();
            if (pieceIdentifier == 8) {
                continue;
            }

            if (pieceIdentifier != i) {
                return false;
            }
        }
        return true;
    }

    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePiece piece : puzzlePieces) {
            g.drawImage(piece.getImg(), piece.getLocation().getX(), piece.getLocation().getY(), (int) this.getSize().getWidth() / 3, (int) this.getSize().getHeight() / 3, null);
        }
    }


    public static MyPanel getPanelInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
        }
        return panelInstance;
    }
}
