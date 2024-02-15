package me.erisos.qsystem.commands;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
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

                if (player.hasPermission("qcore.spawn")) {
                    if (!this.plugin.getConfig().isSet("spawn.spawn_location")) {
                        player.sendMessage(Strings.format(this.plugin.getConfig().getString("spawn.notspawn_message")));
                        return false;
                    }

                    Location location = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("spawn.spawn_location.world")),
                            this.plugin.getConfig().getDouble("spawn.spawn_location.x"),
                            this.plugin.getConfig().getDouble("spawn.spawn_location.y"),
                            this.plugin.getConfig().getDouble("spawn.spawn_location.z"),
                            (float)this.plugin.getConfig().getDouble("spawn.spawn_location.yaw"),
                            (float)this.plugin.getConfig().getDouble("spawn.spawn_location.pitch"));

                    player.teleport(location);
                    player.sendMessage(Strings.format(plugin.getConfig().getString("spawn.teleport_spawn_message")));
                }
            }



        return false;
    }
}
