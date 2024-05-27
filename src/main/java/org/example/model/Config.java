package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Config {
    @SerializedName("images")
    private final ArrayList<String> images = new ArrayList<>();
    @SerializedName("initial-ordering")
    private ArrayList<Integer> initialOrdering;
    @SerializedName("size")
    private LinkedHashMap<String, Integer> size;
    @SerializedName("tiles")
    private LinkedHashMap<String, Integer> tiles;
    @SerializedName("first menu size")
    private LinkedHashMap<String, Integer> sizeOfTheFirstMenu;
    @SerializedName("first panel coordinate")
    private LinkedHashMap<String, Integer> coordinatesOfThePanel;
    @SerializedName("choose mode label")
    private LinkedHashMap<String, LinkedHashMap<String, Integer>> labelParameters;
    @SerializedName("buttons")
    private LinkedHashMap<String, LinkedHashMap<String, Integer>> buttonsParameters;
    @SerializedName("check box")
    private LinkedHashMap<String, LinkedHashMap<String, Integer>> checkBoxParameters;

    public ArrayList<String> getImages() {
        return images;
    }

    public ArrayList<Integer> getInitialOrdering() {
        return initialOrdering;
    }

    public LinkedHashMap<String, Integer> getSize() {
        return size;
    }

    public LinkedHashMap<String, Integer> getTiles() {
        return tiles;
    }

    public LinkedHashMap<String, Integer> getSizeOfTheFirstMenu() {
        return sizeOfTheFirstMenu;
    }

    public LinkedHashMap<String, LinkedHashMap<String, Integer>> getLabelParameters() {
        return labelParameters;
    }

    public LinkedHashMap<String, LinkedHashMap<String, Integer>> getButtonsParameters() {
        return buttonsParameters;
    }

    public LinkedHashMap<String, Integer> getCoordinatesOfThePanel() {
        return coordinatesOfThePanel;
    }

    public LinkedHashMap<String, LinkedHashMap<String, Integer>> getCheckBoxParameters() {
        return checkBoxParameters;
    }
}
