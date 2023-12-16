package me.erisos.qsystem.entity;

import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.util.BoundingBox;

public class RegionJoinKill implements Listener {

    private final QSystem plugin;
    private final Location min, max;

    public RegionJoinKill(QSystem plugin) {
        this.plugin = plugin;

        FileConfiguration config = plugin.getConfig();

        this.min = new Location(plugin.getServer().getWorld(config.getString("mob_remove.pos1.world")),
                config.getDouble("mob_remove.pos1.x"),
                config.getDouble("mob_remove.pos1.y"),
                config.getDouble("mob_remove.pos1.z"));

        this.max = new Location(plugin.getServer().getWorld(config.getString("mob_remove.pos2.world")),
                config.getDouble("mob_remove.pos2.x"),
                config.getDouble("mob_remove.pos2.y"),
                config.getDouble("mob_remove.pos2.z"));

        startChecking();
    }

    private void startChecking() {
        if (!plugin.getConfig().getBoolean("mob_remove.mob_remove_enable")) return;

        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            for (LivingEntity entity : min.getWorld().getLivingEntities()) {
                Location origin = entity.getLocation();
                BoundingBox boundingBox = new BoundingBox(min.getX(), min.getX(), min.getZ(), max.getX(), max.getY(), max.getZ());

                if (boundingBox.contains(origin.getX(), origin.getY(), origin.getZ())) {
                    entity.remove();
                }
            }
        }, 0, 20 * 10);
    }
}