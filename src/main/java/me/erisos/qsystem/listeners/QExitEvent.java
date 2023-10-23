package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

public class QExitEvent implements Listener {
    private final QSystem plugin;

    public QExitEvent(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnExit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if (!this.plugin.getConfig().getBoolean("on_exit_reset")) {
            player.setFoodLevel(20);
            player.getActivePotionEffects().clear();
            player.setWalkSpeed(0.2F);
            player.setFlySpeed(0.2F);
        }

    }
}
