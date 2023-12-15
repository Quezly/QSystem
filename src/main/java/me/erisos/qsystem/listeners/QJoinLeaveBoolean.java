package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class QJoinLeaveBoolean implements Listener {

    private final QSystem plugin;

    public QJoinLeaveBoolean(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("join_leave_message_disable")) {
            e.setJoinMessage(null);
        }
    }

    @EventHandler
    public void OnLeave(PlayerQuitEvent e) {
        if (plugin.getConfig().getBoolean("join_leave_message_disable")) {
            e.setQuitMessage(null);
        }
    }
}
