package me.erisos.qsystem.commands;

import me.despical.commons.serializer.LocationSerializer;
import me.erisos.qsystem.QSystem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QSpawn implements CommandExecutor {


    private QSystem plugin;

    public QSpawn(QSystem plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {

            Player player = (Player) sender;
            Location configlocation = LocationSerializer.fromString(plugin.getConfig().getString("spawn-location"));

            if (args.length == 1) {
                switch (args[0].toLowerCase()) {

                    case "setspawn":

                        if (player.hasPermission("qsystem.setspawn")) {
                            Location location = player.getLocation();
                            plugin.getConfig().set("spawn-location", LocationSerializer.toString(location));
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("setspawn_message")));
                            plugin.saveConfig();
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("error_message")));
                        }
                        break;

                    case "lobi":
                    case "spawn":
                        if (configlocation == null) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("notspawn_message")));
                            return false;
                        }

                        if (player.hasPermission("qsystem.spawn")) {
                            player.teleport(configlocation);
                        }
                        break;

                }

            }

        }

        return false;
    }
}
