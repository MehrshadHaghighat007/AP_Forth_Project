package org.example.controller;

import org.example.view.CLI;
import org.example.view.MyFrame;

public class FinishHandler {
    private MyFrame myFrame;
    private CLI view;

    public FinishHandler(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public FinishHandler(org.example.view.CLI view) {
        this.view = view;
    }

    private boolean gameFinished() {
        for (int i = 0; i < ConfigController.getConfigController().getConfig().getTiles().get("width") * ConfigController.getConfigController().getConfig().getTiles().get("height"); i++) {
            int pieceIdentifier;

            if (myFrame != null) {
                pieceIdentifier = myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getPieceNumber();
            } else {
                pieceIdentifier = view.getModel().getPuzzlePieces().get(i);
            }


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
            if (myFrame != null) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setGameState("finished");
            } else {
                view.getModel().setGameState("finished");
            }
        }
    }
}
