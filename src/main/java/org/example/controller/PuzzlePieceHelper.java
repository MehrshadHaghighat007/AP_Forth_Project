package org.example.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PuzzlePieceHelper {
    public PuzzlePieceHelper(String imageName) {
        loadPuzzlePiece(imageName);
    }
    private void loadPuzzlePiece(String imageName) {
        try {
            Image image = ImageIO.read(new File("src/assets/" + imageName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
