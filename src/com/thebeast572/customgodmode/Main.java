package com.thebeast572.customgodmode;

import com.thebeast572.customgodmode.handlers.customGamemodeFunctions;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    static Plugin plugin;

    public void onEnable() {
        registerCommands();
        registerEvents();
        plugin = this;
    }

    public void onDisable() {
        plugin = null;
    }

    public Plugin getPlugin() {
        return plugin;

    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new customGamemodeFunctions(), this);
    }

    public void registerCommands() {
        this.getCommand("decigod").setExecutor(new MainCommand());
    }
}
