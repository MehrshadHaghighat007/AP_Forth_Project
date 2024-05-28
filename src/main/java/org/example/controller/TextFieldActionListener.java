package org.example.controller;

import org.example.view.TextFields;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldActionListener implements ActionListener {
    private final TextFields textFields;
    private TextFieldHandler textFieldHandler;
    public TextFieldActionListener(TextFields textFields) {
        this.textFields = textFields;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (textFields.getText() != null) {
            textFieldHandler = new TextFieldHandler(textFields.getText());
            System.out.println(textFields.getText());
        }
    }
}
