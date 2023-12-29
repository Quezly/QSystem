package me.erisos.qsystem.listeners;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class QInteractiveBlocks implements Listener {

    private final QSystem plugin;

    public QInteractiveBlocks(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ClickBlock(PlayerInteractEvent e) {
        if (plugin.getConfig().getBoolean("interactive_blocks.disable_crafting_table")) {
            if (e.getAction().toString().contains("RIGHT_CLICK_BLOCK")) {
               e.setCancelled(BlockList(e.getClickedBlock().getType()));
               if (plugin.getConfig().getBoolean("interactive_blocks.disable_blocks_send_message")) {
                   Strings.format(plugin.getConfig().getString("interactive_blocks.disable_blocks_message"));
               }
            }
        }
    }

    private boolean BlockList(Material blockType) {
        FileConfiguration config = plugin.getConfig();
        return config.getStringList("interactive_blocks.block_list").contains(blockType.name());
    }
}
