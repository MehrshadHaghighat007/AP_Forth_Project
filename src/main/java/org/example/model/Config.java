package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Config {
    @SerializedName("images")
    private ArrayList<String> images = new ArrayList<>();
    @SerializedName("initial-ordering")
    private ArrayList<Integer> initialOrdering = new ArrayList<>();
    @SerializedName("Size")
    private LinkedHashMap<String, Integer> size;
    @SerializedName("tiles")
    private LinkedHashMap<String, Integer> tiles;

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public ArrayList<Integer> getInitialOrdering() {
        return initialOrdering;
    }

    public void setInitialOrdering(ArrayList<Integer> initialOrdering) {
        this.initialOrdering = initialOrdering;
    }

    public LinkedHashMap<String, Integer> getSize() {
        return size;
    }

    public void setSize(LinkedHashMap<String, Integer> size) {
        this.size = size;
    }

    public LinkedHashMap<String, Integer> getTiles() {
        return tiles;
    }

    public void setTiles(LinkedHashMap<String, Integer> tiles) {
        this.tiles = tiles;
    }
}
