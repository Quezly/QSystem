package me.erisos.qsystem.listeners;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.List;


public class QChatEvent implements Listener {

    private QSystem plugin;
    public QChatEvent(QSystem plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onSwear(AsyncPlayerChatEvent e) {

        Player player = (Player) e.getPlayer();
        String messages = e.getMessage();
        if (plugin.getConfig().getBoolean("bad_words_blocker.swear_blocker")) {

            List<String> bad_word = plugin.getConfig().getStringList("bad_words_blocker.bad_words");
            if (bad_word.contains(messages)) {
                e.setCancelled(true);
                player.sendTitle(Strings.format(plugin.getConfig().getString("bad_words_blocker.bad_alert_big_title")),
                        plugin.getConfig().getString("bad_words_blocker.bad_alert_small_title"));
                player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_HORSE_DEATH, 0.7F, 0.7F);
                player.playEffect(EntityEffect.ZOMBIE_TRANSFORM);
            }
        }

    }

    @EventHandler(ignoreCancelled = true)
    public void onChat(PlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("qsystem.chat")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Strings.format(plugin.getConfig().getString("error_message_chat")));

        }
    }

}
