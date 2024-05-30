package org.example.controller.game.imageLoading;

import java.io.IOException;

public interface ImageLoader {
    public void loadImage(String imageName) throws IOException;
    public void pieceNumberManager(String imageName);
}
