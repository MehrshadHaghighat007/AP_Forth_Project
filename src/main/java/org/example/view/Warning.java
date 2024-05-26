package org.example.view;

import javax.swing.*;

public class Warning extends JOptionPane {
    public static void showSolvabilityMessage(MyPanel myPanel) {
        showMessageDialog(myPanel, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
    }
    public static void showFinishedMessage(MyPanel myPanel) {
        showMessageDialog(myPanel, "You finished the game, congratulation", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
    }
}
