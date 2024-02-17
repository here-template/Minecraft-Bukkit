package fr.demo.commands;

import fr.demo.DemoBukkitPlugin;
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
 * @see Player
 */
public class MessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        DemoBukkitPlugin main = DemoBukkitPlugin.getInstance();
        Player player = (Player) sender;
        FileConfiguration config = main.getConfig();
        player.sendMessage(Objects.requireNonNull(config.get("message")).toString());
        return true;
    }
}
