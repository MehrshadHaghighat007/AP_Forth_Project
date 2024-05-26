package org.example.controller;

import org.example.model.PuzzlePiece;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageLoaderImpl implements ImageLoader {
    private final PuzzlePiece puzzlePiece;
    public ImageLoaderImpl(PuzzlePiece puzzlePiece) {
        this.puzzlePiece = puzzlePiece;
    }
    @Override
    public void loadImage(String imageName) throws IOException {
        puzzlePiece.setImg(ImageIO.read(new File("src/assets/" + imageName)));
    }

    @Override
    public void pieceNumberManager(String imageName) {
        if (!imageName.equals("missing.png")) {
            puzzlePiece.setPieceNumber(Integer.parseInt(imageName.substring(0, 1)) - 1);
        } else {
            puzzlePiece.setPieceNumber((ConfigController.getConfigController().getConfig().getTiles().get("width") * ConfigController.getConfigController().getConfig().getTiles().get("height")) - 1);
        }
    }
}
