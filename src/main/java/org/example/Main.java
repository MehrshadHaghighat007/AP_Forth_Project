package org.example;

import org.example.controller.ConfigController;
import org.example.controller.GameManager;
import org.example.view.FirstFrame;
import org.example.view.MyFrame;


public class Main {
    public static void main(String[] args) {
//        ConfigController configController = ConfigController.getConfigController();
//        new GameManager(configController);
        new FirstFrame();
    }
}