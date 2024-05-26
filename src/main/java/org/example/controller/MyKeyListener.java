package org.example.controller;

import org.example.view.MyFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private final UpdatePiece updatePiece;
    private final FinishHandler finishHandler;
    private final MyFrame myFrame;
    public MyKeyListener(MyFrame myFrame) {
        this.myFrame = myFrame;
        updatePiece = new UpdatePiece(myFrame);
        finishHandler = new FinishHandler(myFrame);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int missingPieceIndex = MyFrame.getMyFrame().getMyFrameParameters().getMyPanel().getMyPanelParameters().getMissingPiece();
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            updatePiece.moveRight(missingPieceIndex);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            updatePiece.moveLeft(missingPieceIndex);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            updatePiece.moveUp(missingPieceIndex);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            updatePiece.moveDown(missingPieceIndex);
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
