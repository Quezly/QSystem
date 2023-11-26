package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import me.erisos.qsystem.utils.Txt;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
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
        String message = e.getMessage();

        if (player.hasPermission("qsystem.command")) return;
        if (message.contains(" ")) message = message.split(" ")[0];

        if (!allow_commands.stream().anyMatch(message::startsWith)) {
            e.setCancelled(true);
            player.sendMessage(Txt.parse(plugin.getConfig().getString("error_message")));
            if (plugin.getConfig().getBoolean("not_allowed_command_send_title")) {
                player.sendTitle(Txt.parse(plugin.getConfig().getString("not_allowed_command_big_title")),
                        plugin.getConfig().getString("not_allowed_command_small_title"));
                player.playSound(player.getLocation(), Sound.ENTITY_GUARDIAN_ATTACK, 0.7F, 0.7F);
                player.playEffect(EntityEffect.TELEPORT_ENDER);
            }
        }


    }


}