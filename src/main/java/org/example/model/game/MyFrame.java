package org.example.model.game;

import org.example.view.graphic.MyPanel;

public class MyFrame {
    private final MyPanel myPanel;
    public MyFrame() {
        myPanel = MyPanel.getInstance();
    }

    public MyPanel getMyPanel() {
        return myPanel;
    }
}
