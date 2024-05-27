package org.example.controller;

import org.example.view.MyFrame;

public class FinishHandler {
    private final MyFrame myFrame;
    public FinishHandler(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    public boolean gameFinished() {
        for (int i = 0; i < ConfigController.getConfigController().getConfig().getTiles().get("width") * ConfigController.getConfigController().getConfig().getTiles().get("height"); i++) {

            int pieceIdentifier = myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getPieceNumber();
            System.out.println(pieceIdentifier);
            if (pieceIdentifier == (ConfigController.getConfigController().getConfig().getTiles().get("width") * ConfigController.getConfigController().getConfig().getTiles().get("height")) - 1) {
                continue;
            }

            if (pieceIdentifier != i) {
                return false;
            }
        }
        return true;
    }
    public void gameStateStatus() {
        if (gameFinished()) {
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setGameState("finished");
        }
    }
}
