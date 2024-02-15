package me.erisos.qsystem.listeners;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class QJoinTitle implements Listener {

    private final QSystem plugin;

    public QJoinTitle(QSystem plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void OnScreenText(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        int configSecond = plugin.getConfig().getInt("join_title.title_send_after_seconds");

        if (this.plugin.getConfig().getBoolean("join_title.join_send_title")) {
            plugin.getServer().getScheduler().runTaskLater(plugin, () ->
                    player.sendTitle(Strings.format(plugin.getConfig().getString("join_title.join_big_title")),
                            Strings.format(plugin.getConfig().getString
                                    ("join_title.join_small_title"))), configSecond * 20);
        }
    }


}
