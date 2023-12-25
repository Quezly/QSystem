package me.erisos.qsystem.commands;

import me.erisos.qsystem.QSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class QSmithing implements CommandExecutor {

    private final QSystem plugin;

    public QSmithing(QSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player player)) return true;

        var inventory = plugin.getServer().createInventory(null, InventoryType.SMITHING, "Zırh Tasarımcısı");
        player.openInventory(inventory);

        return true;
    }
}
