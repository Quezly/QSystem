package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class QPvpEvent implements Listener {
    QSystem plugin = (QSystem)JavaPlugin.getPlugin(QSystem.class);

    public QPvpEvent() {
    }

    @EventHandler
    public void OnPvp(EntityDamageByEntityEvent e) {
        Player player = (Player)e.getEntity();
        if (this.plugin.getConfig().getBoolean("pvp") && !player.hasPermission("qsystem.pvp")) {
            e.setCancelled(true);
        }

    }
}
