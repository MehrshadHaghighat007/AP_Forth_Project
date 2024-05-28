package org.example.controller;

import org.example.model.Location;
import org.example.model.PuzzlePiece;
import org.example.view.MyFrame;
import org.example.view.Warning;


import java.io.IOException;
import java.util.ArrayList;


public class GameManager {
    private final MyFrame myFrame;
    private final ConfigController configController;
    private final Solvable solvable;
    private final FinishHandler finishHandler;
    private boolean gameFinished = false;
//    private final boolean checkingSolvability = true;

    public GameManager(ConfigController configController) {
        myFrame = MyFrame.getMyFrame();
        this.configController = configController;
        solvable = new SolvableImpl(configController);
        finishHandler = new FinishHandler(myFrame);
        try {
            initialOrderingManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameLoop();
    }

    private void initialOrderingManager() throws IOException {
        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(ConfigController.getConfigController().getConfig().getInitialOrdering());
        for (int i = 0; i < piecesRandomOrder.size(); i++) {
            if (piecesRandomOrder.get(i) == configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height") - 1) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(i);
            }
        }
        if (!solvable.isSolvable(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getMissingPiece(), piecesRandomOrder)) {
            Warning.showSolvabilityMessage(myFrame.getMyFrameParameters().getMyPanel());
            gameFinished = true;
        }
        for (int i = 0; i < configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height"); i++) {
            if (myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getMissingPiece() != i) {
                if (i < 9) {
                    puzzlePieces.add(new PuzzlePiece("0" + (piecesRandomOrder.get(i) + 1) + ".png", new Location(myFrame.getMyFrameParameters().getMyPanel().getSizeOfTheGame().getHeightGame() / configController.getConfig().getTiles().get("width") * (i % configController.getConfig().getTiles().get("width")), myFrame.getMyFrameParameters().getMyPanel().getSizeOfTheGame().getWidthGame() / configController.getConfig().getTiles().get("height") * (i / configController.getConfig().getTiles().get("width")))));
                } else {
                    puzzlePieces.add(new PuzzlePiece((piecesRandomOrder.get(i) + 1) + ".png", new Location(myFrame.getMyFrameParameters().getMyPanel().getSizeOfTheGame().getHeightGame() / configController.getConfig().getTiles().get("width") * (i % configController.getConfig().getTiles().get("width")), myFrame.getMyFrameParameters().getMyPanel().getSizeOfTheGame().getWidthGame() / configController.getConfig().getTiles().get("height") * (i / configController.getConfig().getTiles().get("width")))));
                }
            } else {
                puzzlePieces.add(new PuzzlePiece("missing.png", new Location(myFrame.getMyFrameParameters().getMyPanel().getSizeOfTheGame().getHeightGame() / configController.getConfig().getTiles().get("width") * (i % configController.getConfig().getTiles().get("width")), myFrame.getMyFrameParameters().getMyPanel().getSizeOfTheGame().getWidthGame() / configController.getConfig().getTiles().get("height") * (i / configController.getConfig().getTiles().get("width")))));
            }
        }
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setPuzzlePieces(puzzlePieces);
        System.out.println(puzzlePieces);
        finishHandler.gameFinished();
        finishHandler.gameStateStatus();
    }

    private void gameLoop() {
        while (true) {

            myFrame.getMyFrameParameters().getMyPanel().repaint();
//            myFrame.repaint();

            if (myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getGameState().equals("finished")) {
                Warning.showFinishedMessage(myFrame.getMyFrameParameters().getMyPanel());
                gameFinished = true;
            }

            if (gameFinished) {
                break;
            }

            try {
                Thread.sleep(1000 / 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
