package org.example.view.warning;

import org.example.view.graphic.MyPanel;

import javax.swing.*;

public class Warning {
    public static void showSolvabilityMessage(MyPanel myPanel) {
        JOptionPane.showMessageDialog(myPanel, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
    }
    public static void showFinishedMessage(MyPanel myPanel) {
        JOptionPane.showMessageDialog(myPanel, "You finished the game, congratulation", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void CLISolvabilityMessage() {
        System.out.println("this puzzle is not solvable, change your config and try again");
    }
    public static void CLIFinishedMessage() {
        System.out.println("You finished the game, congratulation");
    }
}
