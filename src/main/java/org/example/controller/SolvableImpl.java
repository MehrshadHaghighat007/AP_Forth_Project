package org.example.controller;

import java.util.ArrayList;

public class SolvableImpl implements Solvable {
    private final ConfigController configController;
    public  SolvableImpl(ConfigController configController) {
        this.configController = configController;
    }
    @Override
    public Boolean isSolvable(int missingPiece, ArrayList<Integer> piecesOrder) {
        int inversionCount = 0;

        for (int i = 0; i < configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height"); i++) {
            for (int j = i + 1; j < configController.getConfig().getTiles().get("width") * configController.getConfig().getTiles().get("height"); j++) {
                if (piecesOrder.get(i) > piecesOrder.get(j)) {
                    inversionCount += 1;
                }
            }
        }

        int parity = inversionCount % 2;
        int distanceOfMissingPiece = ((configController.getConfig().getTiles().get("width") - 1) - (missingPiece % configController.getConfig().getTiles().get("width"))) + ((configController.getConfig().getTiles().get("height") - 1) - (missingPiece / configController.getConfig().getTiles().get("width")));

        parity ^= (distanceOfMissingPiece % 2);
        if (parity == 0) {
            return true;
        }
        return false;
    }
}
