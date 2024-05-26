package org.example.model;

import org.example.view.MyPanel;

public class MyFrame {
    private final MyPanel myPanel;
    public MyFrame() {
        myPanel = MyPanel.getInstance();
    }

    public MyPanel getMyPanel() {
        return myPanel;
    }
}
