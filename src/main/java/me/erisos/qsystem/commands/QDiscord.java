package me.erisos.qsystem.commands;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QDiscord implements CommandExecutor {
    private final QSystem plugin;

    public QDiscord(QSystem plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        player.sendMessage(Strings.format(plugin.getConfig().getString("discord_link")));

        return false;
    }

}
