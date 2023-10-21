package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class QJoinEvent implements Listener {
    private final QSystem plugin;

    public QJoinEvent(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPermission("qsystem.admin")) {
            if (this.plugin.getConfig().getBoolean("set_walk_speed")) {
                player.setWalkSpeed(0.0F);
            }

            if (this.plugin.getConfig().getBoolean("set_fly_speed")) {
                player.setFlySpeed(0.0F);
            } else {
                player.setFlySpeed(0.2F);
            }

            if (this.plugin.getConfig().getBoolean("set_invisibility_effect")) {
                player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(600, 1));
            } else {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
            }

            player.setFoodLevel(20);
            player.setGameMode(GameMode.valueOf(this.plugin.getConfig().getString("set_gamemode")));
        }

        if (this.plugin.getConfig().getBoolean("join_screen_text")) {
            player.sendTitle(plugin.getConfig().getString("big_screen_text"), plugin.getConfig().getString("small_screen_text"));
        }

    }

    @EventHandler
    public void OnJump(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (this.plugin.getConfig().getBoolean("set_jump_block") && e.getTo().getBlockY() - e.getFrom().getBlockY() >= 1 && !player.hasPermission("qsystem.admin")) {
            e.setCancelled(true);
        }

    }
}