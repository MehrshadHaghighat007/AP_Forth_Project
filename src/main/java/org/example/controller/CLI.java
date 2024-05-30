package org.example.controller;

import java.util.Scanner;

public class CLI {
    private final org.example.view.CLI view;
    private final UpdatePiece updatePiece;
    private final FinishHandler finishHandler;

    public CLI(org.example.view.CLI view) {
        this.view = view;
        updatePiece = new UpdatePiece(view.getModel());
        finishHandler = new FinishHandler(view);
    }

    public void scanner() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        try {
            if (answer.length() > 1) {
                view.answerIsNotValid();
            } else {
                int number = Integer.parseInt(answer.substring(0, 1));
                int missing = view.getModel().getMissingPiece();
                if (number == 1) {
                    updatePiece.moveRight(missing);
                } else if (number == 2) {
                    updatePiece.moveLeft(missing);
                } else if (number == 3) {
                    updatePiece.moveUp(missing);
                } else if (number == 4) {
                    updatePiece.moveDown(missing);
                } else if (view.isSelected()) {
                    if (number == 5) {
                        updatePiece.moveRightAndUp(missing);
                    } else if (number == 6) {
                        updatePiece.moveRightAndDown(missing);
                    } else if (number == 7) {
                        updatePiece.moveLeftAndUp(missing);
                    } else if (number == 8) {
                        updatePiece.moveLeftAndUp(missing);
                    }
                } else {
                    view.answerIsNotValid();
                }

            }
        } catch (Exception StringIndexOutOfBoundsException) {
            view.answerIsNotValid();
        }
        finishHandler.gameStateStatus();
    }
}
