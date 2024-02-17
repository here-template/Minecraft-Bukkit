package fr.demo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


/**
 * This class is a command executor
 * It's used to execute the command /ping
 * It's a simple command that send a message to the player
 * @see CommandExecutor
 * @see Command
 * @see Player
 */
public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage("Hi " + player.getName() + ", Pong!");
        return true;
    }
}
