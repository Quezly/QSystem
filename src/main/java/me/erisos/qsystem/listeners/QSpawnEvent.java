package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class QSpawnEvent implements Listener {
    private final QSystem plugin;

    public QSpawnEvent(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Location location = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("spawn_location.world")),
                this.plugin.getConfig().getDouble("spawn_location.x"),
                this.plugin.getConfig().getDouble("spawn_location.y"),
                this.plugin.getConfig().getDouble("spawn_location.z"),
                (float)this.plugin.getConfig().getDouble("spawn_location.yaw"),
                (float)this.plugin.getConfig().getDouble("spawn_location.pitch"));

        Player player = e.getPlayer();
        if (this.plugin.getConfig().getBoolean("firstjoin_teleport_spawn")) {

            if (!e.getPlayer().hasPlayedBefore()) {
                if (this.plugin.getConfig().getString("spawn_location") == null) {
                    return;
                }
                player.teleport(location);
            }

            else if (e.getPlayer().hasPlayedBefore()) {
                if (this.plugin.getConfig().getBoolean("join_teleport_spawn")) {
                    if (this.plugin.getConfig().getString("spawn_location") == null) {
                        return;
                    }
                    player.teleport(location);
                }

            }
        }

    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if (this.plugin.getConfig().getBoolean("respawn_teleport_spawn")) {


            if (this.plugin.getConfig().getString("spawn_location") == null) {
                return;
            }

            Location location = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("spawn_location.world")),
                    this.plugin.getConfig().getDouble("spawn_location.x"),
                    this.plugin.getConfig().getDouble("spawn_location.y"),
                    this.plugin.getConfig().getDouble("spawn_location.z"),
                    (float)this.plugin.getConfig().getDouble("spawn_location.yaw"),
                    (float)this.plugin.getConfig().getDouble("spawn_location.pitch"));
            e.setRespawnLocation(location);
        }

    }
}