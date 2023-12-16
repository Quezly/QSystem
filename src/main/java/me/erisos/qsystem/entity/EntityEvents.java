package me.erisos.qsystem.entity;

import me.erisos.qsystem.QSystem;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTeleportEvent;

public class EntityEvents implements Listener {

    private final QSystem plugin;

    public EntityEvents(QSystem plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {
        if (!plugin.getConfig().getBoolean("mob_settings.enderman_teleport_disable")) return;
        if (event.getEntity().getType() != EntityType.ENDERMAN) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (!plugin.getConfig().getBoolean("mob_settings.barrier_block_mob_spawn_disable")) return;
        if (event.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.BARRIER) return;

        event.setCancelled(true);
    }
}