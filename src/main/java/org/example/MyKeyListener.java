package org.example;

import org.example.controller.UpdatePiece;
import org.example.view.MyFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private final UpdatePiece updatePiece;
    public MyKeyListener(MyFrame myFrame) {
        updatePiece = new UpdatePiece(myFrame);
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

//        if (MyPanel.getInstance().gameState.equals("finished")) {
//            return;
//        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
