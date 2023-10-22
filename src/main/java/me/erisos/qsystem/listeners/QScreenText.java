package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class QScreenText implements Listener {

    private final QSystem plugin;

    public QScreenText(QSystem plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void OnScreenText(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (this.plugin.getConfig().getBoolean("join_screen_text")) {
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("big_screen_text")),
                    ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("small_screen_text")));
        }
    }


}
