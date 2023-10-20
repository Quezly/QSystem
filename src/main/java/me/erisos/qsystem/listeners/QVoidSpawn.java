package me.erisos.qsystem.listeners;

import me.despical.commons.serializer.LocationSerializer;
import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class QVoidSpawn implements Listener {

    private QSystem plugin;
    public QVoidSpawn (QSystem plugin) {this.plugin = plugin;}

    @EventHandler
    public void OnVoidTeleportSpawn (PlayerMoveEvent e) {

        Player player = e.getPlayer();
        Location configlocation = LocationSerializer.fromString(plugin.getConfig().getString("spawn-location"));

        if(e.getTo().getBlockY() <= 0) {

            player.teleport(configlocation);

        }

    }
}
