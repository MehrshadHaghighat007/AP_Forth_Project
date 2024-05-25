package org.example.controller;

public interface Moveable {
    public boolean rightIsValid(int missingPieceIndex);
    public boolean leftIsValid(int missingPieceIndex);
    public boolean upIsValid(int missingPieceIndex);
    public boolean downIsValid(int missingPieceIndex);
}
