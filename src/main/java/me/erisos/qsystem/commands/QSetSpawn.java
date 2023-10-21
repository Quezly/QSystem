package me.erisos.qsystem.commands;

import me.erisos.qsystem.QSystem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QSetSpawn implements CommandExecutor {
    private final QSystem plugin;

    public QSetSpawn(QSystem plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;

            if (sender instanceof Player) {

                if (player.hasPermission("qsystem.setspawn")) {

                    Location location = player.getLocation();
                    this.plugin.getConfig().set("spawn_location.world", location.getWorld().getName());
                    this.plugin.getConfig().set("spawn_location.x", location.getX());
                    this.plugin.getConfig().set("spawn_location.y", location.getY());
                    this.plugin.getConfig().set("spawn_location.z", location.getZ());
                    this.plugin.getConfig().set("spawn_location.yaw", location.getYaw());
                    this.plugin.getConfig().set("spawn_location.pitch", location.getPitch());
                    this.plugin.saveConfig();
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("setspawn_message")));
                    return false;
                } else {
                    System.out.println(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("error_message")));
                }
                return false;

            } else {
                System.out.println(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("notspawn_message")));
                return false;
            }

    }
}