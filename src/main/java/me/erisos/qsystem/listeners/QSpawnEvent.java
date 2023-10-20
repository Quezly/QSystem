package me.erisos.qsystem.listeners;

import me.despical.commons.serializer.LocationSerializer;
import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class QSpawnEvent implements Listener {

    private QSystem plugin;
    public QSpawnEvent (QSystem plugin) {this.plugin = plugin;}


    @EventHandler
    public boolean onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Location configlocation = LocationSerializer.fromString(plugin.getConfig().getString("spawn-location"));

        if (plugin.getConfig().getBoolean("join_teleport_spawn")) {
            if (configlocation == null) {

                return false;
            }
            player.teleport(configlocation);
            return false;
        }
        return false;
    }

    @EventHandler
    public boolean onRespawn(PlayerRespawnEvent e) {
        Location configlocation = LocationSerializer.fromString(plugin.getConfig().getString("spawn-location"));

        if (plugin.getConfig().getBoolean("respawn_teleport_spawn")) {
            if (configlocation == null) {
                return false;
            }
            e.setRespawnLocation(configlocation);
            return false;
        }
        return false;
    }



}
