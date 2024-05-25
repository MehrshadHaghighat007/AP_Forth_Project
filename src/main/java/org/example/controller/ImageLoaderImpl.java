package org.example.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLoaderImpl implements ImageLoader {
    @Override
    public Image loadImage(String imageName) throws IOException {
        return ImageIO.read(new File("src/assets/" + imageName));
    }
}
