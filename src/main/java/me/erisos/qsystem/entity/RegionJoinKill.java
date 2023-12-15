package me.erisos.qsystem.entity;

import me.erisos.qsystem.QSystem;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;

public class RegionJoinKill implements Listener {

    private QSystem plugin;
    public RegionJoinKill(QSystem plugin) {
        this.plugin = plugin;
    }


    Location min = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("mob_remove.pos1.world")),
            this.plugin.getConfig().getDouble("mob_remove.pos1.x"),
            this.plugin.getConfig().getDouble("mob_remove.pos1.y"),
            this.plugin.getConfig().getDouble("mob_remove.pos1.z"));

    Location max = new Location(this.plugin.getServer().getWorld(this.plugin.getConfig().getString("mob_remove.pos2.world")),
            this.plugin.getConfig().getDouble("mob_remove.pos2.x"),
            this.plugin.getConfig().getDouble("mob_remove.pos2.y"),
            this.plugin.getConfig().getDouble("mob_remove.pos2.z"));


    void Region(QSystem plugin, Location min, Location max) {


        if (plugin.getConfig().getBoolean("mob_remove.mob_remove_enable")) {
            plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
                for (LivingEntity entity : min.getWorld().getLivingEntities()) {
                    Location origin = entity.getLocation();

                    /*
                    BoundingBox boundingBox = new BoundingBox(min.getX(), min.getX(), min.getZ(), max.getX(), max.getY(), max.getZ());



                    if (boundingBox.contains(origin.getX(), origin.getY(), origin.getZ())) {
                        entity.remove();
                    }



                      ////////////////////     //////////////////////////////      ////////////////////       //////////////



                    if ((origin.getX() == min.getX() && origin.getX() == max.getX()) &&
                            ((origin.getY() == min.getY() && origin.getY() == max.getY()) &&
                                    (origin.getZ() == min.getZ() && origin.getZ() == max.getZ()))) {

                        entity.remove();

                    }


                         ////////////////////     //////////////////////////////      ////////////////////       //////////////



                    if (new IntRange(min.getX(), max.getX()).containsDouble(origin.getX())
                            && new IntRange(min.getY(), max.getY()).containsDouble(origin.getY())
                            && new IntRange(min.getZ(), max.getZ()).containsDouble(origin.getZ())) {

                        entity.remove();
                    }
                     */
                }
            }, 0, 20 * 10);
        }
    }
}
