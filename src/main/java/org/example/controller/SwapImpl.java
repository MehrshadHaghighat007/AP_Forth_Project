package org.example.controller;

import org.example.view.MyFrame;

public class SwapImpl implements Swappable {
    private final MyFrame myFrame;
    public SwapImpl() {
        myFrame = MyFrame.getMyFrame();
    }

    @Override
    public void Swap(int i, int j) {
        PuzzlePiece copy = myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getClone();
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getPuzzlePieceParameters().setImg(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getPuzzlePieceParameters().getImg());
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(i).getPuzzlePieceParameters().setPieceNumber(myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getPuzzlePieceParameters().getPieceNumber());
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getPuzzlePieceParameters().setImg(copy.getPuzzlePieceParameters().getImg());
        myFrame.getMyFrameParameters().getMyPanel().getMyPanelParameters().getPuzzlePieces().get(j).getPuzzlePieceParameters().setPieceNumber(copy.getPuzzlePieceParameters().getPieceNumber());
    }
}
