package fr.demo.commands;

import fr.demo.DemoBukkitPlugin;
import fr.demo.gui.DemoGUI;
import fr.demo.gui.utils.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


/**
 * This class is a command executor
 * It's used to execute the command /ping
 * It's a simple command that send a message to the player
 * @see CommandExecutor
 * @see Command
 * @see GUI
 */
public class GuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        DemoBukkitPlugin main = DemoBukkitPlugin.getInstance();

        DemoGUI gui = new DemoGUI("menu", 9, "Menu de Demo");
        Player player = (Player) sender;

        main.getGuiManager().openGUI(player, gui);

        return true;
    }
}
