package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import me.erisos.qsystem.commands.QSpawn;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class QJoinEvent implements Listener {

    private QSystem plugin;
    public QJoinEvent(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();


        if(!player.hasPermission("qsystem.admin")) {

            if(plugin.getConfig().getBoolean("set_walk_speed")) {
                player.setWalkSpeed(0);
            }

            if(plugin.getConfig().getBoolean("set_fly_speed")) {
                player.setFlySpeed(0);
            } else {
                player.setFlySpeed(0.2f);
            }
            if(plugin.getConfig().getBoolean("set_invisibility_effect")) {
                player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(600,1));
            } else {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
            }

            player.setFoodLevel(20);
            player.setGameMode(GameMode.valueOf(plugin.getConfig().getString("set_gamemode")));
        }

        if(plugin.getConfig().getBoolean("join_screen_text")) {

            player.sendTitle("","");

        }



    }

    /*
    public boolean isSameBlock(PlayerMoveEvent event) {
        return isSameBlock(event.getFrom(), event.getTo());
    }
    */

    /*
    private boolean isSameBlock(Location one, Location two) {
        if (one.getBlockX() != two.getBlockX()) {
            return false;
        } else if (one.getBlockZ() != two.getBlockZ()) {
            return false;
        } else {
            return one.getBlockY() != two.getBlockY() ? false : one.getWorld().equals(two.getWorld());
        }
    }
    */

    @EventHandler
    public void OnJump(PlayerMoveEvent e) {

       Player player = e.getPlayer();

       /*
       if(!isSameBlock(e)) {
           e.setCancelled(true);
       }
        */

       if(plugin.getConfig().getBoolean("set_jump_block")) {
           if(e.getTo().getBlockY() - e.getFrom().getBlockY() >= 1) { //Oyuncunun 1 veya 2 blok yukarı çıkıp çıkmadığını kontrol ediyoruz.
               if(!player.hasPermission("qsystem.admin")) { e.setCancelled(true);
               }
           }
       }
  }

}

