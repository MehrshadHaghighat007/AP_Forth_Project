package org.example.model.game;
import java.util.ArrayList;

public class MyPanel {
    private ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    private int missingPiece = 0;
    private String gameState = "#";

    public ArrayList<PuzzlePiece> getPuzzlePieces() {
        return puzzlePieces;
    }

    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getGameState() {
        return gameState;
    }
}
