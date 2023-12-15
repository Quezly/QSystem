package me.erisos.qsystem.commands;

import me.despical.commons.util.Strings;
import me.erisos.qsystem.QSystem;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class QCommands implements CommandExecutor {

    private final QSystem plugin;

    public QCommands(QSystem plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            if (player.hasPermission("qsystem.admin")) {
                player.setWalkSpeed(0.2F);
                player.setFlySpeed(0.2F);
                player.setGameMode(GameMode.SURVIVAL);
                player.setFoodLevel(20);
                player.getActivePotionEffects().clear();

            } else {
                System.out.println(Strings.format(plugin.getConfig().getString("error_message")));
            }
        }

        return false;
    }
}
