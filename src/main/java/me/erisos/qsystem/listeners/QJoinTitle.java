package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import me.erisos.qsystem.utils.Txt;
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

        if (this.plugin.getConfig().getBoolean("join_title.join_send_title")) {
            player.sendTitle(Txt.parse(plugin.getConfig().getString("join_title.join_big_title")),
                    Txt.parse(plugin.getConfig().getString("join_title.join_small_title")));
        }
    }


}
