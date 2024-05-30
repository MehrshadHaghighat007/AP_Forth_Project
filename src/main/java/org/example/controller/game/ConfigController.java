package org.example.controller.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.config.Config;

import java.io.FileReader;
import java.io.IOException;

public class ConfigController {
    private static ConfigController configController = null;
    private static final String CONFIG_FILE = "src/config.json";
    private Config config;

    private ConfigController() {
        config = new Config();
        loadConfig();
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
            config = gson.fromJson(reader, Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Config getConfig() {
        return config;
    }
}
