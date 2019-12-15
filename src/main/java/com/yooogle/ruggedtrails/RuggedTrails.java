package com.yooogle.ruggedtrails;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RuggedTrails extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        setupDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    // Methods
    private void setupDefaultConfig() {

        // Grab the config
        config = getConfig();

        // Setup the defaults
        config.addDefault("ReduceRamUsage", false);

        config.addDefault("enable_trails_in_survival", true);
        config.addDefault("enable_trails_in_adventure", true);
        config.addDefault("enable_trails_in_creative", false);
        config.addDefault("enable_trails_in_spectator", false);

        // Save the defaults
        config.options().copyDefaults(true);
        saveConfig();

    }
}
