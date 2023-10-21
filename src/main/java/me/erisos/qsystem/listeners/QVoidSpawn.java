package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class QVoidSpawn implements Listener {
    private final QSystem plugin;

    public QVoidSpawn(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public boolean OnVoidTeleportSpawn(EntityDamageEvent e) {
        Player player = (Player)e.getEntity();
        if (e.getEntity() instanceof Player && e.getCause() == DamageCause.VOID) {
            Location location = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("spawn_location.world")), this.plugin.getConfig().getDouble("spawn_location.x"), this.plugin.getConfig().getDouble("spawn_location.y"), this.plugin.getConfig().getDouble("spawn_location.z"), (float)this.plugin.getConfig().getDouble("spawn_location.yaw"), (float)this.plugin.getConfig().getDouble("spawn_location.pitch"));
            player.teleport(location);
        }

        return false;
    }
}
