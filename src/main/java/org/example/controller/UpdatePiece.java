package org.example.controller;

import org.example.view.MyFrame;

public class UpdatePiece {
    private final Moveable moveableImpl;
    private final MyFrame myFrame;
    private final SwapImpl swapImpl;
    public UpdatePiece(MyFrame myFrame) {
        moveableImpl = new MoveableImpl();
        swapImpl = new SwapImpl(myFrame);
        this.myFrame = myFrame;
    }
    public void moveRight(int missingPieceIndex) {
        if (moveableImpl.rightIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + 1);
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + 1);
        }
    }
    public void moveLeft(int missingPieceIndex) {
        if (moveableImpl.leftIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - 1);
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - 1);
        }
    }
    public void moveUp(int missingPieceIndex) {
        if (moveableImpl.upIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width"));
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width"));
        }
    }
    public void moveDown(int missingPieceIndex) {
        if (moveableImpl.downIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width"));
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width"));
        }
    }
    public void moveRightAndUp(int missingPieceIndex) {
        if (moveableImpl.rightIsValid(missingPieceIndex) && moveableImpl.upIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
        }
    }
    public void moveRightAndDown(int missingPieceIndex) {
        if (moveableImpl.rightIsValid(missingPieceIndex) && moveableImpl.downIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") + 1);
        }
    }public void moveLeftAndUp(int missingPieceIndex) {
        if (moveableImpl.leftIsValid(missingPieceIndex) && moveableImpl.upIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex - ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
        }
    }public void moveLeftAndDown(int missingPieceIndex) {
        if (moveableImpl.leftIsValid(missingPieceIndex) && moveableImpl.downIsValid(missingPieceIndex)) {
            swapImpl.Swap(missingPieceIndex, missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().setMissingPiece(missingPieceIndex + ConfigController.getConfigController().getConfig().getTiles().get("width") - 1);
        }
    }
}
