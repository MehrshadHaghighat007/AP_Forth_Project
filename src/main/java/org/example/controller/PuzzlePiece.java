package org.example.controller;

import org.example.model.Location;
import java.awt.*;

public class PuzzlePiece {
    private org.example.model.PuzzlePiece puzzlePieceParameters;
    private PuzzlePieceLoader puzzlePieceLoader;
    private PuzzlePieceHelper puzzlePieceHelper;


//    public PuzzlePiece(Image image, int pieceNumber) {
//        puzzlePieceParameters = new org.example.model.PuzzlePiece();
//        puzzlePieceParameters.setImg(image);
//        puzzlePieceParameters.setPieceNumber(pieceNumber);
//    }

    public PuzzlePiece(String imageName) {
        puzzlePieceHelper = new PuzzlePieceHelper(imageName);

    }

    public PuzzlePiece(String ImagePath, Location location) {
        this(ImagePath);
        puzzlePieceParameters = new org.example.model.PuzzlePiece();
        puzzlePieceParameters.setLocation(location);
    }

    public PuzzlePiece(Image img, Location location, int pieceIdentifier) {
        puzzlePieceParameters = new org.example.model.PuzzlePiece();
        puzzlePieceParameters.setImg(img);
        puzzlePieceParameters.setLocation(location);
        puzzlePieceParameters.setPieceNumber(pieceIdentifier);
    }

    public org.example.model.PuzzlePiece getPuzzlePieceParameters() {
        return puzzlePieceParameters;
    }

    public PuzzlePiece getClone() {
        PuzzlePiece clone = new PuzzlePiece(puzzlePieceParameters.getImg(), puzzlePieceParameters.getLocation(), puzzlePieceParameters.getPieceNumber());

        return clone;
    }


//    public void setPuzzlePieceParameters(org.example.model.PuzzlePiece puzzlePieceParameters) {
//        this.puzzlePieceParameters = puzzlePieceParameters;
//    }
//
//    public PuzzlePieceLoader getPuzzlePieceLoader() {
//        return puzzlePieceLoader;
//    }
//
//    public void setPuzzlePieceLoader(PuzzlePieceLoader puzzlePieceLoader) {
//        this.puzzlePieceLoader = puzzlePieceLoader;
//    }
}
