package org.example.controller.game;

import org.example.controller.game.moveChecking.Moveable;
import org.example.controller.game.moveChecking.MoveableImpl;
import org.example.controller.game.swappable.SwapImpl;
import org.example.model.cli.CLI;
import org.example.view.graphic.MyFrame;

public class UpdatePiece {
    private final Moveable moveableImpl;
    private MyFrame myFrame;
    private final SwapImpl swapImpl;
    private CLI model;
    private boolean mode = false;

    public UpdatePiece(MyFrame myFrame) {
        moveableImpl = new MoveableImpl();
        swapImpl = new SwapImpl(myFrame);
        this.myFrame = myFrame;
        mode = true;
    }

    public UpdatePiece(CLI model) {
        moveableImpl = new MoveableImpl();
        swapImpl = new SwapImpl(model);
        this.model = model;
    }

    public void moveRight(int missingPieceIndex) {
        if (moveableImpl.rightIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + 1);
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + 1);
            } else {
                model.setMissingPiece(missingPieceIndex + 1);
            }
        }
    }

    public void moveLeft(int missingPieceIndex) {
        if (moveableImpl.leftIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - 1);
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - 1);
            } else {
                model.setMissingPiece(missingPieceIndex - 1);
            }
        }
    }

    public void moveUp(int missingPieceIndex) {
        if (moveableImpl.upIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width"));
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width"));
            } else {
                model.setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width"));
            }
        }
    }

    public void moveDown(int missingPieceIndex) {
        if (moveableImpl.downIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width"));
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width"));
            } else {
                model.setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width"));
            }
        }
    }

    public void moveRightAndUp(int missingPieceIndex) {
        if (moveableImpl.rightIsValid(missingPieceIndex) && moveableImpl.upIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            } else {
                model.setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            }
        }
    }

    public void moveRightAndDown(int missingPieceIndex) {
        if (moveableImpl.rightIsValid(missingPieceIndex) && moveableImpl.downIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            } else {
                model.setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            }
        }
    }

    public void moveLeftAndUp(int missingPieceIndex) {
        if (moveableImpl.leftIsValid(missingPieceIndex) && moveableImpl.upIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            } else {
                model.setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            }
        }
    }

    public void moveLeftAndDown(int missingPieceIndex) {
        if (moveableImpl.leftIsValid(missingPieceIndex) && moveableImpl.downIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            if (mode) {
                myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            } else {
                model.setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            }
        }
    }
}
