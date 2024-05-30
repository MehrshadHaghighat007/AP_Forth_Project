package org.example.controller;

import org.example.view.CheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxListener implements ActionListener {
    private final CheckBox checkBox;
    private static boolean isSelected;
    public CheckBoxListener(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        isSelected = checkBox.isSelected();
    }

    public static boolean isIsSelected() {
        return isSelected;
    }
}
