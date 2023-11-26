package me.erisos.qsystem.commands;

import me.erisos.qsystem.QSystem;
import me.erisos.qsystem.utils.Txt;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QSpawn implements CommandExecutor {
    private final QSystem plugin;

    public QSpawn(QSystem plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            if (plugin.getConfig().getBoolean("spawn_command")) {
                if (player.hasPermission("qsystem.spawn")) {
                    if (!this.plugin.getConfig().isSet("spawn_location")) {
                        player.sendMessage(Txt.parse(this.plugin.getConfig().getString("notspawn_message")));
                        return false;
                    }

                    Location location = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("spawn_location.world")),
                            this.plugin.getConfig().getDouble("spawn_location.x"),
                            this.plugin.getConfig().getDouble("spawn_location.y"),
                            this.plugin.getConfig().getDouble("spawn_location.z"),
                            (float)this.plugin.getConfig().getDouble("spawn_location.yaw"),
                            (float)this.plugin.getConfig().getDouble("spawn_location.pitch"));

                    player.teleport(location);
                    player.sendMessage(Txt.parse(plugin.getConfig().getString("teleport_spawn_message")));
                }
            }
        }



        return false;
    }
}
