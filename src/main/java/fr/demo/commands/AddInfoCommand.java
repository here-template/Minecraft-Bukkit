package fr.demo.commands;

import fr.demo.DemoBukkitPlugin;
import fr.demo.database.utils.DbConnection;
import fr.demo.gui.utils.GUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;


/**
 * This class is a command executor
 * It's used to execute the command /ping
 * It's a simple command that send a message to the player
 * @see CommandExecutor
 * @see Command
 * @see GUI
 */
public class AddInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        final Player player = (Player) sender;
        final UUID uuid = player.getUniqueId();
        final DbConnection dbConnection = DemoBukkitPlugin.getInstance().getDatabaseManager().getDemoDB();

        if (args.length == 0) {
            player.sendMessage("§cUsage: /addinfo <info>");
            return true;
        }

        try {
            final Connection connection = dbConnection.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `infos` WHERE `uuid` = ?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                player.sendMessage(ChatColor.RED + "You already have an info in the database");
                return true;
            }

            preparedStatement = connection.prepareStatement("INSERT INTO `infos` (`uuid`, `info`) VALUES (?, ?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, String.join(" ", args));

            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.GREEN + "Your info has been added to the database");

        } catch (Exception e) {
            e.printStackTrace();
        }

        String info = String.join(" ", args);
       return true;
    }
}
