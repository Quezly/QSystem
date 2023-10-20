package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.w3c.dom.Entity;
import org.w3c.dom.events.Event;

public class QPvpEvent implements Listener {


    QSystem plugin = JavaPlugin.getPlugin(QSystem.class);

    @EventHandler
    public void OnPvp (EntityDamageByEntityEvent e) {

        Player player = (Player) e.getEntity();

        if(plugin.getConfig().getBoolean("pvp")) {
            if (!player.hasPermission("qsystem.pvp")) {
                e.setCancelled(true);
            }
        }
    }

}
