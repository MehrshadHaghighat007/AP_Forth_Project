package org.example.view;

import org.example.controller.ConfigController;

import java.util.ArrayList;

public class CLI {
    private final ArrayList<Integer> puzzlePiece;
    private final boolean isSelected;

    public CLI(ArrayList<Integer> puzzlePiece, Boolean isSelected) {
        this.puzzlePiece = puzzlePiece;
        this.isSelected = isSelected;
    }

    public void paint() {
        for (int i = 0; i < puzzlePiece.size(); i++) {
            if (puzzlePiece.get(i) < 10) {
                if (i % ConfigController.getConfigController().getConfig().getTiles().get("width") != ConfigController.getConfigController().getConfig().getTiles().get("width") - 1) {
                    System.out.print(" " + puzzlePiece.get(i) + " ");
                } else {
                    System.out.println(" " + puzzlePiece.get(i) + " ");
                }
            } else {
                if (i % ConfigController.getConfigController().getConfig().getTiles().get("width") != ConfigController.getConfigController().getConfig().getTiles().get("width") - 1) {
                    System.out.print(" " + puzzlePiece.get(i));
                } else {
                    System.out.println(" " + puzzlePiece.get(i));
                }
            }
        }
    }

    public void choose() {
        System.out.println("choose on of this movement :" + "\n" + "1 - right" + "\n" + "2 - left" + "\n" + "3 - up" + "\n" + "4 - down");
        if (isSelected) {
            System.out.println("5 - right|up" + "\n" + "6 - right|down" + "\n" + "7 - left|right" + "\n" + "8 - left|down");
        }
        org.example.controller.CLI.scanner();
    }

    public void answerIsNotValid() {
        System.out.println("please enter a valid number");
        choose();
    }

    public boolean isSelected() {
        return isSelected;
    }
}
