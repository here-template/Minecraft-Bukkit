package fr.demo;

import fr.demo.commands.GuiCommand;
import fr.demo.commands.MessageCommand;
import fr.demo.commands.PingCommand;
import fr.demo.gui.utils.GUIManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class DemoBukkitPlugin extends JavaPlugin implements Listener {

    private GUIManager guiManager; // GUIManager instance

    /**
     * This method is called when the plugin is enabled
     */
    @Override
    public void onEnable() {
        guiManager = new GUIManager(this); // Create a new GUIManager
        getLogger().info("DemoBukkitPlugin is enabled"); // This is a log message in the console

        Objects.requireNonNull(getCommand("ping")).setExecutor(new PingCommand()); // Register command ping
        Objects.requireNonNull(getCommand("message")).setExecutor(new MessageCommand()); // Register command message
        Objects.requireNonNull(getCommand("gui")).setExecutor(new GuiCommand()); // Register command gui

        getServer().getPluginManager().registerEvents(this, this); // Register the events for @EventHandler
    }

    /**
     * This method is called when the plugin is disabled
     */
    @Override
    public void onDisable() {
        getLogger().info("DemoBukkitPlugin is disabled");
    }

    /**
     * This method get main instance of the plugin (DemoBukkitPlugin)
     *
     * @return FileConfiguration config content of the config.yml
     */
    @Override
    public @NotNull FileConfiguration getConfig() {
        return super.getConfig();
    }


    /**
     * This method save the config.yml
     */
    @Override
    public void saveConfig() {
        super.saveConfig();
    }

    /**
     * This method get GUIManager instance
     *
     * @return GUIManager instance
     */
    public GUIManager getGuiManager() {
        return guiManager;
    }

    /**
     * This method get main instance of the plugin (DemoBukkitPlugin)
     *
     * @return DemoBukkitPlugin instance (this)
     */
    public static DemoBukkitPlugin getInstance() {
        return JavaPlugin.getPlugin(DemoBukkitPlugin.class);
    }
}