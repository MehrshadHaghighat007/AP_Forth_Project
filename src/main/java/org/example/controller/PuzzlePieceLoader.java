package org.example.controller;

import java.awt.*;
import java.io.IOException;

public class PuzzlePieceLoader {
    private ImageLoader imageLoader;

    public PuzzlePieceLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public PuzzlePiece loadPuzzlePiece(String imageName) throws IOException {
        Image image = imageLoader.loadImage(imageName);
        int pieceNumber = extractPieceNumber(imageName);
        return new PuzzlePiece(image, pieceNumber);
    }

    private int extractPieceNumber(String imageName) {
        if (!imageName.equals("missing.jpg")) {
            return Integer.parseInt(imageName.substring(0, 1)) - 1;
        } else {
            return 8;
        }
    }
}
