package org.example.model;

import org.example.controller.ImageLoader;
import org.example.controller.ImageLoaderImpl;

import java.awt.*;
import java.io.IOException;


public class PuzzlePiece {
    private Image img;
    private int pieceNumber;
    private Location location;

    public PuzzlePiece(String imageName) throws IOException {
        ImageLoader imageLoader = new ImageLoaderImpl(this);
        imageLoader.loadImage(imageName);
        imageLoader.pieceNumberManager(imageName);
    }

    public PuzzlePiece(String ImagePath, Location location) throws IOException {
        this(ImagePath);
        this.location = location;
    }

    public PuzzlePiece(Image img, Location location, int pieceIdentifier) {
        this.img = img;
        this.location = location;
        this.pieceNumber = pieceIdentifier;
    }

    public PuzzlePiece getClone() {
        return new PuzzlePiece(img, location, pieceNumber);
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
