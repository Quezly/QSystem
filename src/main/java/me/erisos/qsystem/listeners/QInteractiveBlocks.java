package me.erisos.qsystem.listeners;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class QInteractiveBlocks implements Listener {

    private final QSystem plugin;

    public QInteractiveBlocks(QSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ClickBlock(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (plugin.getConfig().getBoolean("interactive_blocks.disable_blocks")) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && BlockList(e.getClickedBlock().getType())) {
               e.setCancelled(BlockList(e.getClickedBlock().getType()));
               if (plugin.getConfig().getBoolean("interactive_blocks.disable_blocks_send_message")) {
                   player.sendMessage(Strings.format(plugin.getConfig().getString("interactive_blocks.disable_blocks_message")));
               }
            }
        }
    }

    private boolean BlockList(Material blockType) {
        FileConfiguration config = plugin.getConfig();
        return config.getStringList("interactive_blocks.block_list").contains(blockType.name());
    }


    public void PlaceBlock (BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPermission("qcore.placeblock")) {
            e.setCancelled(true);
            player.sendMessage(Strings.format(plugin.getConfig().getString("blocks.disable_block_placement_message")));
        }
    }

    public void BreakBlock (BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPermission("qcore.breakblock")) {
            e.setCancelled(true);
            player.sendMessage(Strings.format(plugin.getConfig().getString("blocks.disable_block_break_message")));
        }
    }
}
