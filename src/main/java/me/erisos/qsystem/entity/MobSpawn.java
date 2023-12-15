package me.erisos.qsystem.entity;

import me.erisos.qsystem.QSystem;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawn implements Listener {

    private QSystem plugin;
    public MobSpawn(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (plugin.getConfig().getBoolean("mob_settings.barrier_block_mob_spawn_disable")) {
            if (event.getEntity().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BARRIER) {
                event.setCancelled(true);
            }
        }
    }
}
