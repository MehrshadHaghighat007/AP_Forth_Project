package org.example.controller.game.solvable;

import java.util.ArrayList;

public interface Solvable {
    public Boolean isSolvable(int missingPiece, ArrayList<Integer> piecesOrder);
}
