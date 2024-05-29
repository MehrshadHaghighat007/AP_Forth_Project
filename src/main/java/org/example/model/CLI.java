package org.example.model;

import java.util.ArrayList;

public class CLI {
    private ArrayList<Integer> puzzlePieces = new ArrayList<>();
    private int missingPiece = 0;
    private String gameState = "#";

    public ArrayList<Integer> getPuzzlePieces() {
        return puzzlePieces;
    }

    public void setPuzzlePieces(ArrayList<Integer> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }
}
