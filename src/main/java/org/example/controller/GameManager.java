package org.example.controller;

import org.example.model.CLI;
import org.example.model.Location;
import org.example.model.PuzzlePiece;
import org.example.view.MyFrame;
import org.example.view.Warning;


import java.io.IOException;
import java.util.ArrayList;


public class GameManager {
    private MyFrame myFrame;
    private final ConfigController configController;
    private final Solvable solvable;
    private FinishHandler finishHandler;
    private CLI model;
    private org.example.view.CLI view;
    private boolean gameFinished = false;

    public GameManager(Boolean isSelected, String mode) {
        configController = ConfigController.getConfigController();
        solvable = new SolvableImpl(configController);
        missingPieceHandler();
        if (mode.equals("Graphic")) {
            graphicManager(isSelected);
        } else {
            CLI();
        }
        finishHandlerManager(mode);
        try {
            initialOrderingManager(isSelected, mode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameLoop();
    }

    private int missingPieceHandler() {
//        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(ConfigController.getConfigController().getConfig().getInitialOrdering());
        int missingPiece = 0;
        for (int i = 0; i < piecesRandomOrder.size(); i++) {
            if (piecesRandomOrder.get(i) == configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height") - 1) {
                missingPiece = i;
            }
        }
        return missingPiece;
    }

    private void graphicManager(boolean isSelected) {
        myFrame = MyFrame.getMyFrame(isSelected);

    }

    private void CLI() {
        model = new CLI();
        view = new org.example.view.CLI();
    }

    private void finishHandlerManager(String mode) {
        if (mode.equals("Graphic")) {
            finishHandler = new FinishHandler(myFrame);
        } else {
            finishHandler = new FinishHandler(model);
        }
    }

    private void initialOrderingManager(Boolean isSelected, String mode) throws IOException {
        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(ConfigController.getConfigController().getConfig().getInitialOrdering());
        int missingPiece = 0;
        for (int i = 0; i < piecesRandomOrder.size(); i++) {
            if (piecesRandomOrder.get(i) == configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height") - 1) {
                missingPiece = i;
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(i);
                model.setMissingPiece(i);
            }
        }
        if (!isSelected) {
            if (!solvable.isSolvable(missingPiece, piecesRandomOrder)) {
                if (mode.equals("Graphic")) {
                    Warning.showSolvabilityMessage(myFrame.getMyFrameParameters().getMyPanel());
                } else {
                    Warning.CLISolvabilityMessage();
                }
                gameFinished = true;
            }
        } else {
            gameFinished = false;
        }
        if (mode.equals("Graphic")) {
            graphicManager(puzzlePieces, piecesRandomOrder);
        } else {
            CLIManager(piecesRandomOrder);
        }
        finishHandler.gameFinished();
        finishHandler.gameStateStatus();
    }

    private void graphicManager(ArrayList<PuzzlePiece> puzzlePieces, ArrayList<Integer> piecesRandomOrder) throws IOException {
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
    }

    private void CLIManager(ArrayList<Integer> piecesRandomOrder) {
        piecesRandomOrder.replaceAll(integer -> integer + 1);
        model.setPuzzlePieces(piecesRandomOrder);
        view.paint(model.getPuzzlePieces());
    }

    private void gameLoop() {
        while (true) {

            myFrame.getMyFrameParameters().getMyPanel().repaint();
            myFrame.repaint();

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
