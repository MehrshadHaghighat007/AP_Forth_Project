package org.example.controller;

import org.example.view.MyFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private final UpdatePiece updatePiece;
    private final FinishHandler finishHandler;
    private final MyFrame myFrame;
    private final boolean isSelected;
    public MyKeyListener(MyFrame myFrame, Boolean isSelected) {
        this.myFrame = myFrame;
        this.isSelected = isSelected;
        updatePiece = new UpdatePiece(myFrame);
        finishHandler = new FinishHandler(myFrame);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        

        int missingPieceIndex = MyFrame.getMyFrame(isSelected).getMyFrameParameters().getMyPanel().getMyPanelParameters().getMissingPiece();
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            updatePiece.moveRight(missingPieceIndex);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            updatePiece.moveLeft(missingPieceIndex);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            updatePiece.moveUp(missingPieceIndex);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            updatePiece.moveDown(missingPieceIndex);
        }
        if (isSelected) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_Q) {
                updatePiece.moveLeftAndUp(missingPieceIndex);
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_Z) {
                updatePiece.moveLeftAndDown(missingPieceIndex);
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_P) {
                updatePiece.moveRightAndUp(missingPieceIndex);
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_M) {
                updatePiece.moveRightAndDown(missingPieceIndex);
            }
        }
        finishHandler.gameFinished();
        finishHandler.gameStateStatus();
        if (myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getGameState().equals("finished")) {
            return;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
