package me.erisos.qsystem.commands;

import me.erisos.qsystem.QSystem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayer;

public class QSetSpawn implements CommandExecutor {

    private QSystem plugin;

    public QSetSpawn(QSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Location location = player.getLocation();

            plugin.getConfig().set("spawn_location", location);
            plugin.saveConfig();

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("setspawn_message")));

            return false;

        }

            Player player = (Player) sender;
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("notspawn_message")));




        return false;
    }

}
