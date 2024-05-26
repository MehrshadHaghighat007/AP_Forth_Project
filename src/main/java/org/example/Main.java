package org.example;

import org.example.controller.ConfigController;
import org.example.controller.GameManager;
import org.example.view.MyFrame;

public class Main {
    public static void main(String[] args) {
        ConfigController configController = ConfigController.getConfigController();
        System.out.println(configController.getConfig().getSize().get("width"));
        new GameManager(MyFrame.getMyFrame(), configController);
    }
}