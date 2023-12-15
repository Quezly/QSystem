package me.erisos.qsystem.listeners;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class QVoidSpawn implements Listener {
    private final QSystem plugin;

    public QVoidSpawn(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnVoidTeleportSpawn(EntityDamageEvent e) {

        if (e.getEntity() instanceof Player) {

            Player player = (Player)e.getEntity();

            if (plugin.getConfig().getBoolean("spawn.void_damage_teleport_spawn")) {

                if (this.plugin.getConfig().getString("spawn.spawn_location") == null) {
                    return;
                }
                if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {


                    Location location = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("spawn_location.world")),
                            this.plugin.getConfig().getDouble("spawn.spawn_location.x"),
                            this.plugin.getConfig().getDouble("spawn.spawn_location.y"),
                            this.plugin.getConfig().getDouble("spawn.spawn_location.z"),
                            (float)this.plugin.getConfig().getDouble("spawn.spawn_location.yaw"),
                            (float)this.plugin.getConfig().getDouble("spawn_location.pitch"));
                    player.teleport(location);

                    player.sendMessage(Strings.format(plugin.getConfig().getString("spawn.teleport_spawn_message")));
                }

            }

        }

    }
}
