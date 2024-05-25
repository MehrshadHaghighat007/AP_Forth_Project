package org.example;

import org.example.controller.PuzzlePiece;
import org.example.model.Location;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
//        JFrame frame = new JFrame();



//        int screenWidth;
//        int screenHeight;
//        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
//        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
//        int maxSize = Math.max(screenWidth, screenHeight) / 3;
//        panel.setSize(maxSize, maxSize);
//        panel.setLocation(screenWidth / 2 - maxSize / 2, screenHeight / 2 - maxSize / 2);
//        frame.setSize(panel.getSize());
//        frame.setLocation(panel.getLocation());
//        frame.add(panel);

        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(Arrays.asList(7, 0, 1, 8, 3, 2, 6, 5, 4));

        for (int i = 0; i < piecesRandomOrder.size(); i++)
            if (piecesRandomOrder.get(i) == 8)
                panel.setMissingPiece(i);

        boolean gameFinished = false;
        if (!solvable(panel.missingPiece, piecesRandomOrder)) {
            JOptionPane.showMessageDialog(frame, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
            gameFinished = true;
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(i + " " + piecesRandomOrder.get(i));
            if (panel.missingPiece != i) {
                puzzlePieces.add(new org.example.controller.PuzzlePiece(piecesRandomOrder.get(i) + 1 + ".png", new Location(panel.getHeight() / 3 * (i % 3), panel.getWidth() / 3 * (i / 3))));
            } else {
                puzzlePieces.add(new org.example.controller.PuzzlePiece("missing.jpg", new Location(panel.getHeight() / 3 * (i % 3), panel.getWidth() / 3 * (i / 3))));
            }
        }
        panel.setPuzzlePieces(puzzlePieces);

        frame.setVisible(true);
        while (true) {
            try {
                // TODO: CHANGE THIS FOR IMPROVING YOUR FRAME RATE... (OPTIONAL)
                Thread.sleep(1000 / 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            panel.repaint();
            frame.repaint();

            if (gameFinished) {
                break;
            }

            if (panel.gameState.equals("finished")) {
                JOptionPane.showMessageDialog(frame, "You finished the game, congratulation", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
                gameFinished = true;
            }
        }
    }
}