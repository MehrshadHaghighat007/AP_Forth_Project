package org.example.view;

import org.example.controller.ConfigController;

import java.util.ArrayList;

public class CLI {
    public void paint(ArrayList<Integer> puzzlePiece) {
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
}
