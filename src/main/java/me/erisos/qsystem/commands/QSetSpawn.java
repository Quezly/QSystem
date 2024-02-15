package me.erisos.qsystem.commands;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
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
                    if (player.hasPermission("qcore.setspawn")) {

                        Location location = player.getLocation();
                        this.plugin.getConfig().set("spawn.spawn_location.world", location.getWorld().getName());
                        this.plugin.getConfig().set("spawn.spawn_location.x", location.getX());
                        this.plugin.getConfig().set("spawn.spawn_location.y", location.getY());
                        this.plugin.getConfig().set("spawn.spawn_location.z", location.getZ());
                        this.plugin.getConfig().set("spawn.spawn_location.yaw", location.getYaw());
                        this.plugin.getConfig().set("spawn_location.pitch", location.getPitch());
                        this.plugin.saveConfig();
                        player.sendMessage(Strings.format(this.plugin.getConfig().getString("spawn.setspawn_message")));
                        return false;
                    } else {
                        System.out.println(Strings.format(plugin.getConfig().getString("spawn.error_message")));
                    }
                    return false;


            } else {
                System.out.println(Strings.format(this.plugin.getConfig().getString("spawn.notspawn_message")));
                return false;
            }

    }
}