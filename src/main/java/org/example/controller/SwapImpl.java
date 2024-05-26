package org.example.controller;

import org.example.model.PuzzlePiece;
import org.example.view.MyFrame;

public class SwapImpl implements Swappable {
    private final MyFrame myFrame;
    public SwapImpl(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void Swap(int i, int j) {
        PuzzlePiece copy = myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getClone();
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).setImg(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getImg());
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).setPieceNumber(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getPieceNumber());
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).setImg(copy.getImg());
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).setPieceNumber(copy.getPieceNumber());
    }
}
