package org.example.controller;

public class SizeCalculation {
    private final ConfigController configController;
    private final int maxSize;

    public SizeCalculation() {
        configController = ConfigController.getConfigController();
        maxSize = Math.max(configController.getConfig().getSize().get("width"), configController.getConfig().getSize().get("height"));
    }

    public int calculatedWidth() {
        return maxSize / configController.getConfig().getTiles().get("width");

    }

    public int calculatedHeight() {
        return maxSize / configController.getConfig().getTiles().get("height");
    }

    public int calculatedXCoordinate() {
        return (configController.getConfig().getSize().get("width") - calculatedWidth()) / 2;
    }

    public int calculatedYCoordinate() {
        return (configController.getConfig().getSize().get("height") - calculatedHeight()) / 2;
    }
}
