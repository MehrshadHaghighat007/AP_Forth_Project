package org.example.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PuzzlePieceHelper {
    public PuzzlePieceHelper(String imageName) throws IOException {
        loadPuzzlePiece(imageName);
        extractPieceNumber(imageName);
    }

    private void loadPuzzlePiece(String imageName) throws IOException {
        Image image = ImageIO.read(new File("src/assets/" + imageName));
    }

    private int extractPieceNumber(String imageName) {
        if (!imageName.equals("missing.jpg")) {
            return Integer.parseInt(imageName.substring(0, 1)) - 1;
        } else {
            return 8;
        }
    }
}
