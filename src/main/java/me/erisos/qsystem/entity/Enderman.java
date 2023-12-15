package me.erisos.qsystem.entity;

import me.erisos.qsystem.QSystem;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class Enderman implements Listener {

    private QSystem plugin;
    public Enderman(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTeleport(EntityTeleportEvent e) {
        if (plugin.getConfig().getBoolean("mob_settings.enderman_teleport")) {
            if (!(e.getEntity().getType() == EntityType.ENDERMAN)) {
                return;
            }
            e.setCancelled(true);
        }


    }
}
