package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import me.erisos.qsystem.utils.Txt;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
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
                player.sendTitle(Txt.parse(plugin.getConfig().getString("bad_words_blocker.bad_alert_big_title")),
                        plugin.getConfig().getString("bad_words_blocker.bad_alert_small_title"));
                player.playSound(player.getLocation(), Sound.ENTITY_GUARDIAN_ATTACK, 0.7F, 0.7F);
                player.playEffect(EntityEffect.TELEPORT_ENDER);
            }
        }

    }

    @EventHandler(ignoreCancelled = true)
    public void onChat(PlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("qsystems.chat")) {
            event.getPlayer().sendMessage(Txt.parse(plugin.getConfig().getString("error_message_chat")));

            event.setCancelled(true);
        }
    }

}
