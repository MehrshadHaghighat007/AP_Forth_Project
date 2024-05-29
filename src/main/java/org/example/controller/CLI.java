package org.example.controller;

import java.util.Scanner;

public class CLI {
    private static org.example.view.CLI view;
    private static org.example.model.CLI model;
    private static UpdatePiece updatePiece;

    public CLI(org.example.view.CLI view, org.example.model.CLI model) {
        CLI.view = view;
        CLI.model = model;
        updatePiece = new UpdatePiece(model);
    }

    public static void scanner() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        try {
            if (answer.length() > 1) {
                view.answerIsNotValid();
            } else {
                int number = Integer.parseInt(answer.substring(0, 1));
                int missing = model.getMissingPiece();
                if (number == 1) {
                    updatePiece.moveRight(missing);
                } else if (number == 2) {
                    updatePiece.moveLeft(missing);
                } else if (number == 3) {
                    updatePiece.moveUp(missing);
                } else if (number == 4) {
                    updatePiece.moveDown(missing);
                } else {
                    view.answerIsNotValid();
                }
                if (view.isSelected()) {
                    if (number == 5) {
                        updatePiece.moveRightAndUp(missing);
                    } else if (number == 6) {
                        updatePiece.moveRightAndDown(missing);
                    } else if (number == 7) {
                        updatePiece.moveLeftAndUp(missing);
                    } else if (number == 8) {
                        updatePiece.moveLeftAndUp(missing);
                    } else {
                        view.answerIsNotValid();
                    }
                }
            }
        } catch (Exception StringIndexOutOfBoundsException) {
            view.answerIsNotValid();
        }
    }
}
