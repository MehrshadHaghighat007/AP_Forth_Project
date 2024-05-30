package org.example.view.cli;

import org.example.controller.game.ConfigController;

public class CLI {
    private final boolean isSelected;

    private final org.example.model.cli.CLI model;

    private final org.example.controller.game.CLI controller;

    public CLI(Boolean isSelected) {

        this.isSelected = isSelected;

        model = new org.example.model.cli.CLI();

        controller = new org.example.controller.game.CLI(this);
    }

    public void paint() {
        for (int i = 0; i < model.getPuzzlePieces().size(); i++) {
            if (model.getPuzzlePieces().get(i) < 10) {
                if (i % ConfigController.getConfigController().getConfig().getTiles().get("width") != ConfigController.getConfigController().getConfig().getTiles().get("width") - 1) {
                    System.out.print(" " + (model.getPuzzlePieces().get(i) + 1) + " ");
                } else {
                    System.out.println(" " + (model.getPuzzlePieces().get(i) + 1) + " ");
                }
            } else {
                if (i % ConfigController.getConfigController().getConfig().getTiles().get("width") != ConfigController.getConfigController().getConfig().getTiles().get("width") - 1) {
                    System.out.print(" " + (model.getPuzzlePieces().get(i) + 1));
                } else {
                    System.out.println(" " + (model.getPuzzlePieces().get(i) + 1));
                }
            }
        }
    }

    public void choose() {
        System.out.println("choose on of this movement :" + "\n" + "1 - right" + "\n" + "2 - left" + "\n" + "3 - up" + "\n" + "4 - down");
        if (isSelected) {
            System.out.println("5 - right|up" + "\n" + "6 - right|down" + "\n" + "7 - left|up" + "\n" + "8 - left|down");
        }
        controller.scanner();
    }

    public void answerIsNotValid() {
        System.out.println("please enter a valid number");
        choose();
    }

    public org.example.model.cli.CLI getModel() {
        return model;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
