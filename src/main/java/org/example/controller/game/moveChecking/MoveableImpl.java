package org.example.controller.game.moveChecking;

import org.example.controller.game.ConfigController;

public class MoveableImpl implements Moveable {

    @Override
    public boolean rightIsValid(int missingPieceIndex) {
        return missingPieceIndex % ConfigController.getConfigController().getConfig().getTiles().get("width") != ConfigController.getConfigController().getConfig().getTiles().get("width") - 1;
    }

    @Override
    public boolean leftIsValid(int missingPieceIndex) {
        return missingPieceIndex % ConfigController.getConfigController().getConfig().getTiles().get("width") != 0;
    }

    @Override
    public boolean upIsValid(int missingPieceIndex) {
        return missingPieceIndex > ConfigController.getConfigController().getConfig().getTiles().get("width") - 1;
    }

    @Override
    public boolean downIsValid(int missingPieceIndex) {
        return missingPieceIndex < ConfigController.getConfigController().getConfig().getTiles().get("width") * (ConfigController.getConfigController().getConfig().getTiles().get("height") - 1);
    }
}
