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
        try {
            initialOrderingManager(isSelected, mode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initialOrderingManager(Boolean isSelected, String mode) throws IOException {
        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(ConfigController.getConfigController().getConfig().getInitialOrdering());
        solvabilityManager(isSelected, missingPieceHandler(piecesRandomOrder), piecesRandomOrder);
        if (mode.equals("Graphic")) {
            graphicManager(missingPieceHandler(piecesRandomOrder), isSelected, puzzlePieces, piecesRandomOrder);
        } else {
            CLIManager(missingPieceHandler(piecesRandomOrder), isSelected, piecesRandomOrder);
        }
    }

    private int missingPieceHandler(ArrayList<Integer> piecesRandomOrder) {
        int a = 0;
        for (int i = 0; i < piecesRandomOrder.size(); i++) {
            if (piecesRandomOrder.get(i) == configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height") - 1) {
                a = i;
                break;
            }
        }
        return a;
    }

    private void solvabilityManager(Boolean isSelected, Integer missingPiece, ArrayList<Integer> piecesRandomOrder) {
        if (!isSelected) {
            gameFinished = !solvable.isSolvable(missingPiece, piecesRandomOrder);
        }
    }


    private void graphicManager(Integer missingPiece, Boolean isSelected, ArrayList<PuzzlePiece> puzzlePieces, ArrayList<Integer> piecesRandomOrder) throws IOException {
        myFrame = MyFrame.getMyFrame(isSelected);
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPiece);
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
        if (gameFinished) {
            Warning.showSolvabilityMessage(myFrame.getMyFrameParameters().getMyPanel());
            myFrame.dispose();
        }
        finishHandler = new FinishHandler(myFrame);
        finishHandler.gameStateStatus();
        GraphicGameLoop();
    }

    private void CLIManager(Integer missingPiece, Boolean isSelected, ArrayList<Integer> piecesRandomOrder) {
        model = new CLI();
        model.setMissingPiece(missingPiece);



        ArrayList<Integer> pieceHelper = new ArrayList<>(piecesRandomOrder.size());
        for (Integer integer : piecesRandomOrder) {
            pieceHelper.add(integer + 1);
        }
        model.setPuzzlePieces(pieceHelper);
        view = new org.example.view.CLI(model.getPuzzlePieces(), isSelected);
        org.example.controller.CLI controller = new org.example.controller.CLI(view, model);
        if (gameFinished) {
            Warning.CLISolvabilityMessage();

        }
        finishHandler = new FinishHandler(model);
        finishHandler.gameStateStatus();
        CLIGameLoop();

    }

    private void GraphicGameLoop() {
        while (true) {

            myFrame.getMyFrameParameters().getMyPanel().repaint();
            myFrame.repaint();

            if (myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getGameState().equals("finished")) {
                Warning.showFinishedMessage(myFrame.getMyFrameParameters().getMyPanel());
                myFrame.dispose();
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

    private void CLIGameLoop() {
        while (true) {

            view.paint();

            if (model.getGameState().equals("finished")) {
                Warning.CLIFinishedMessage();
                gameFinished = true;
            }

            if (gameFinished) {
                System.exit(0);
                break;
            }

            view.choose();

            try {
                Thread.sleep(1000 / 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
