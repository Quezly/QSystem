package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class QCommandEvent implements Listener {

    private QSystem plugin;
    public QCommandEvent(QSystem plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){

        Player player = e.getPlayer();
        List<String> allow_commands = plugin.getConfig().getStringList("allow_commands");
        String error_message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("error_message"));

        String message = e.getMessage();

        if (player.hasPermission("qsystem.command")) return;
        if (message.contains(" ")) message = message.split(" ")[0];

        if (!allow_commands.stream().anyMatch(message::startsWith)) {
            e.getPlayer().sendMessage(error_message);
            e.setCancelled(true);
        }


    }





    @EventHandler(ignoreCancelled = true)
    public void onChatInGame(PlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("qsystems.chat")) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("error_message_chat")));

            event.setCancelled(true);
        }
    }


}