package org.example.controller;

import org.example.model.Location;
import java.awt.*;
import java.io.IOException;

public class PuzzlePiece {
    private org.example.model.PuzzlePiece puzzlePieceParameters;
    private PuzzlePieceLoader puzzlePieceLoader;


    public PuzzlePiece(Image image, int pieceNumber) {
        puzzlePieceParameters = new org.example.model.PuzzlePiece();
        puzzlePieceParameters.setImg(image);
        puzzlePieceParameters.setPieceNumber(pieceNumber);
    }

//    public PuzzlePiece(String imageName) {
//        try {
//            puzzlePieceLoader.loadPuzzlePiece(imageName);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public PuzzlePiece(String ImagePath, Location location) {

        (ImagePath);
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
