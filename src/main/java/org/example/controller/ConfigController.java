package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Config;

import java.io.FileReader;
import java.io.IOException;

public class ConfigController {
    private static ConfigController configController = null;
    private static final String CONFIG_FILE = "src/config.json";
    private final org.example.model.ConfigController configControllerParameters;

    private ConfigController() {
        configControllerParameters = new org.example.model.ConfigController();
        loadConfig();
        calculate();
    }

    public static ConfigController getConfigController() {
        if (configController == null) {
            configController = new ConfigController();
        }
        return configController;
    }

    private void loadConfig() {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            configControllerParameters.setConfig(gson.fromJson(reader, Config.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public org.example.model.ConfigController getConfigControllerParameters() {
        return configControllerParameters;
    }

}
