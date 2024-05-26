package org.example.controller;

import java.awt.*;
import java.io.IOException;

public interface ImageLoader {
    public void loadImage(String imageName) throws IOException;
    public void pieceNumberManager(String imageName);
}
