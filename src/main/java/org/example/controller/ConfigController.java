package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.example.model.ImageConfig;
import org.example.model.InitialOrderingConfig;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigController {
    private static ConfigController configController = null;
    private static final String CONFIG_FILE = "src/config.json";
    private ImageConfig imageConfig;
    private InitialOrderingConfig initialOrderingConfig;

    private ConfigController() {
        loadConfig();
    }

    public static ConfigController getConfigController() {
        if (configController == null) {
            configController = new ConfigController();
        }
        return configController;
    }

    private void loadConfig() {
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            Gson gson = new Gson();
            JsonObject object = (JsonObject) gson.fromJson(reader, Object.class);
            JsonArray imageArray = (JsonArray) object.get("images");
            ArrayList<String> imageHelper = new ArrayList<>();
            for (int i = 0; i < imageArray.size(); i++) {
                imageHelper.add(i, imageArray.get(i).toString());
            }
            imageConfig.setImages(imageHelper);

            JsonArray initialOrderingArray = (JsonArray) object.get("initial-ordering");
            ArrayList<JsonElement> initialOrderingHelper = new ArrayList<>();
            for (int i = 0; i < imageArray.size(); i++) {
                initialOrderingHelper.add(i, initialOrderingArray.get(i));
            }
            initialOrderingConfig.setInitialOrdering(initialOrderingHelper);

            imageConfig = gson.fromJson(reader, ImageConfig.class);
            initialOrderingConfig = gson.fromJson(reader, InitialOrderingConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void imageConfigLoader() {

    }



//    public String getImagePath(String imageName) {
//        if (imageConfig != null && imageConfig.getImages().contains(imageName)) {
//            for (int )
//        }
//        return null;
//    }
}
