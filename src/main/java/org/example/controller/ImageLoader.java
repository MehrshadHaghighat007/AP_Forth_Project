package org.example.controller;

import java.awt.*;
import java.io.IOException;

public interface ImageLoader {
    Image loadImage(String imageName) throws IOException;
}
