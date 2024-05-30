package org.example.controller.game.swappable;

import org.example.model.cli.CLI;
import org.example.model.game.PuzzlePiece;
import org.example.view.graphic.MyFrame;

public class SwapImpl implements Swappable {
    private MyFrame myFrame;
    private CLI model;

    public SwapImpl(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public SwapImpl(CLI model) {
        this.model = model;
    }

    @Override
    public void Swap(int i, int j) {
        if (myFrame != null) {
            PuzzlePiece copy = myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getClone();
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).setImg(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getImg());
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).setPieceNumber(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getPieceNumber());
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).setImg(copy.getImg());
            myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).setPieceNumber(copy.getPieceNumber());
        } else {
            int destination = model.getPuzzlePieces().get(j);
            model.getPuzzlePieces().set(j, model.getPuzzlePieces().get(i));
            model.getPuzzlePieces().set(i , destination);
        }
    }
}
